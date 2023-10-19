package daos.daoimpl;

import daos.AttendanceDao;
import models.attendance.Attendance;
import models.specialModels.StatusCount;
import models.specialModels.StatusCountWithClass;
import play.api.db.Database;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDaoImpl implements AttendanceDao {
    private final Database db;

    @Inject
    public AttendanceDaoImpl(Database db) {
        this.db = db;
    }

    @Override
    public void addAttendance(Attendance attendance) {
        try (Connection connection = db.getConnection()) {
            String query = "INSERT INTO attendance (attendance_id, roll_no, date, status) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, attendance.getAttendanceId());
            statement.setInt(2, attendance.getRollNo());
            statement.setString(3, attendance.getDate());
            statement.setString(4, attendance.getStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addBulkAttendance(List<Attendance> attendanceList) {
        try (Connection connection = db.getConnection()) {
            String query = "INSERT INTO attendance (attendance_id, roll_no, date, status) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            for (Attendance attendance : attendanceList) {
                statement.setInt(1, attendance.getAttendanceId());
                statement.setInt(2, attendance.getRollNo());
                statement.setString(3, attendance.getDate());
                statement.setString(4, attendance.getStatus());
                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Attendance> getAttendanceByRollNo(Attendance attendance) {
        List<Attendance> attendanceList = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            String query = "SELECT * FROM attendance WHERE roll_no = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, attendance.getRollNo());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Attendance attendance1 = new Attendance();
                attendance1.setAttendanceId(resultSet.getInt("attendance_id"));
                attendance1.setRollNo(resultSet.getInt("roll_no"));
                attendance1.setDate(resultSet.getString("date"));
                attendance1.setStatus(resultSet.getString("status"));

                attendanceList.add(attendance1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }

    @Override
    public List<Attendance> getAllAttendance() {
        List<Attendance> attendanceList = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            String query = "SELECT * FROM attendance";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Attendance attendance = new Attendance();
                attendance.setAttendanceId(resultSet.getInt("attendance_id"));
                attendance.setRollNo(resultSet.getInt("roll_no"));
                attendance.setDate(resultSet.getString("date"));
                attendance.setStatus(resultSet.getString("status"));

                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }
    @Override
    public List<Attendance> getAttendanceByFilter(Attendance attendance) {
        List<Attendance> attendanceList = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            String query = "SELECT * FROM attendance WHERE";
            boolean conditionsAdded = false;

            if (attendance.getRollNo() > 0) {
                query += " roll_no = ?";
                conditionsAdded = true;
            }

            if (attendance.getDate() != null && !attendance.getDate().isEmpty()) {
                if (conditionsAdded) {
                    query += " AND";
                }
                query += " date = ?";
                conditionsAdded = true;
            }

            if (attendance.getStatus() != null && !attendance.getStatus().isEmpty()) {
                if (conditionsAdded) {
                    query += " AND";
                }
                query += " status = ?";
            }

            PreparedStatement statement = connection.prepareStatement(query);

            int parameterIndex = 1;
            if (attendance.getRollNo() > 0) {
                statement.setInt(parameterIndex++, attendance.getRollNo());
            }

            if (attendance.getDate() != null && !attendance.getDate().isEmpty()) {
                statement.setString(parameterIndex++, attendance.getDate());
            }

            if (attendance.getStatus() != null && !attendance.getStatus().isEmpty()) {
                statement.setString(parameterIndex, attendance.getStatus());
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Attendance resultAttendance = new Attendance();
                resultAttendance.setAttendanceId(resultSet.getInt("attendance_id"));
                resultAttendance.setRollNo(resultSet.getInt("roll_no"));
                resultAttendance.setDate(resultSet.getString("date"));
                resultAttendance.setStatus(resultSet.getString("status"));

                attendanceList.add(resultAttendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }



    @Override
    public StatusCount getAttendanceCountByStatus(Attendance attendance) {
        StatusCount statusCount = new StatusCount();

        try (Connection connection = db.getConnection()) {
            String query = "SELECT status, COUNT(*) as count FROM attendance WHERE";
            boolean conditionsAdded = false;

            if (attendance.getDate() != null && !attendance.getDate().isEmpty()) {
                query += " date = ?";
                conditionsAdded = true;
            }

            if (attendance.getRollNo() > 0) {
                if (conditionsAdded) {
                    query += " AND";
                }
                query += " roll_no = ?";
            }

            query += " GROUP BY status";
            PreparedStatement statement = connection.prepareStatement(query);

            int parameterIndex = 1;
            if (attendance.getDate() != null && !attendance.getDate().isEmpty()) {
                statement.setString(parameterIndex++, attendance.getDate());
            }

            if (attendance.getRollNo() > 0) {
                statement.setInt(parameterIndex, attendance.getRollNo());
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String status = resultSet.getString("status");
                int count = resultSet.getInt("count");

                switch (status) {
                    case "present":
                        statusCount.setPresent(count);
                        break;
                    case "absent":
                        statusCount.setAbsent(count);
                        break;
                    case "late":
                        statusCount.setLate(count);
                        break;
                    default:
                        // Handle unknown status
                        break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statusCount;
    }
    @Override
    public List<StatusCountWithClass> getStatusCountByDateRange(String startDate, String endDate) {
        List<StatusCountWithClass> result = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            String query = "SELECT s.class, " +
                    "SUM(CASE WHEN a.status = 'present' THEN 1 ELSE 0 END) as present, " +
                    "SUM(CASE WHEN a.status = 'absent' THEN 1 ELSE 0 END) as absent, " +
                    "SUM(CASE WHEN a.status = 'late' THEN 1 ELSE 0 END) as late " +
                    "FROM students s " +
                    "JOIN attendance a ON s.roll_no = a.roll_no " +
                    "WHERE a.date BETWEEN ? AND ? " +
                    "GROUP BY s.class";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, startDate);
            statement.setString(2, endDate);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                StatusCountWithClass statusCountWithClass = new StatusCountWithClass();
                statusCountWithClass.setClassName(resultSet.getString("class"));

                StatusCount statusCount = new StatusCount();
                statusCount.setPresent(resultSet.getInt("present"));
                statusCount.setAbsent(resultSet.getInt("absent"));
                statusCount.setLate(resultSet.getInt("late"));

                statusCountWithClass.setStatusCount(statusCount);
                result.add(statusCountWithClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
