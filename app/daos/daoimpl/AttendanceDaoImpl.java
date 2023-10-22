package daos.daoimpl;

import daos.AttendanceDao;
import models.attendance.Attendance;
import models.specialModels.AttendanceDetail;
import models.specialModels.AttendanceRecord;
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
            String query = "INSERT INTO attendance (roll_no, date, status,class) VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, attendance.getRollNo());
            statement.setString(2, attendance.getDate());
            statement.setString(3, attendance.getStatus());
            statement.setString(4,attendance.getClassName());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addBulkAttendance(List<Attendance> attendanceList) {
        try (Connection connection = db.getConnection()) {
            String query = "INSERT INTO attendance (roll_no, date, status,class) VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            for (Attendance attendance : attendanceList) {
                statement.setInt(1, attendance.getRollNo());
                statement.setString(2, attendance.getDate());
                statement.setString(3, attendance.getStatus());
                statement.setString(4,attendance.getClassName());
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
            String query = "SELECT * FROM attendance WHERE roll_no = ? AND class = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, attendance.getRollNo());
            statement.setString(2,attendance.getClassName());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Attendance attendance1 = new Attendance();
                attendance1.setAttendanceId(resultSet.getInt("attendance_id"));
                attendance1.setRollNo(resultSet.getInt("roll_no"));
                attendance1.setDate(resultSet.getString("date"));
                attendance1.setStatus(resultSet.getString("status"));
                attendance1.setClassName(resultSet.getString("class"));
                attendanceList.add(attendance1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }

    @Override
    public List<Attendance> getAllAttendance(Attendance attendance) {
        List<Attendance> attendanceList = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            String query = "SELECT * FROM attendance WHERE class = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,attendance.getClassName());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Attendance attendance1 = new Attendance();
                attendance1.setAttendanceId(resultSet.getInt("attendance_id"));
                attendance1.setRollNo(resultSet.getInt("roll_no"));
                attendance1.setDate(resultSet.getString("date"));
                attendance1.setStatus(resultSet.getString("status"));
                attendance1.setClassName(resultSet.getString("class"));

                attendanceList.add(attendance1);
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

            if (attendance.getClassName() != null && !attendance.getClassName().isEmpty()) {
                if (conditionsAdded) {
                    query += " AND";
                }
                query += " class = ?";
            }

            PreparedStatement statement = connection.prepareStatement(query);

            int parameterIndex = 1;
            if (attendance.getRollNo() > 0) {
                statement.setInt(parameterIndex++, attendance.getRollNo());
            }

            if (attendance.getDate() != null && !attendance.getDate().isEmpty()) {
                statement.setString(parameterIndex++, attendance.getDate());
            }

            if (attendance.getClassName() != null && !attendance.getClassName().isEmpty()) {
                statement.setString(parameterIndex, attendance.getClassName());
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Attendance resultAttendance = new Attendance();
                resultAttendance.setAttendanceId(resultSet.getInt("attendance_id"));
                resultAttendance.setRollNo(resultSet.getInt("roll_no"));
                resultAttendance.setDate(resultSet.getString("date"));
                resultAttendance.setStatus(resultSet.getString("status"));
                resultAttendance.setClassName(resultSet.getString("class"));
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
            String query = "SELECT status, COUNT(*) as count FROM attendance WHERE class = ? AND";
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
            statement.setString(1,attendance.getClassName());
            int parameterIndex = 2;
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

//    @Override
//    public List<AttendanceDetail> getAttendanceDetails(String startDate, String endDate, String className) {
//        List<AttendanceDetail> attendanceDetails = new ArrayList<>();
//        System.out.println("input >> " + startDate + "  " + endDate + "  " + className);
//
//        try (Connection connection = db.getConnection()) {
//            String query = "SELECT a.roll_no, s.first_name, s.class, a.date, a.status " +
//                    "FROM attendance a " +
//                    "JOIN students s ON a.roll_no = s.roll_no " +
//                    "WHERE s.class = ? " +
//                    "AND a.date BETWEEN ? AND ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, className);
//            statement.setString(2, startDate);
//            statement.setString(3, endDate);
//            System.out.println("Statement " + statement);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                System.out.println(resultSet);
//
//                int rollNo = resultSet.getInt("roll_no");
//                String firstName = resultSet.getString("first_name");
//                String classNameResult = resultSet.getString("class");
//
//                AttendanceDetail attendanceDetail = null;
//
//                for (AttendanceDetail detail : attendanceDetails) {
//                    if (detail.getRollNo() == rollNo) {
//                        attendanceDetail = detail;
//                        break;
//                    }
//                }
//
//                if (attendanceDetail == null) {
//                    attendanceDetail = new AttendanceDetail();
//                    attendanceDetail.setRollNo(rollNo);
//                    attendanceDetail.setFirstName(firstName);
//                    attendanceDetail.setClassName(classNameResult);
//                    attendanceDetail.setAttendance(new ArrayList<>());
//                    attendanceDetails.add(attendanceDetail);
//                }
//
//                AttendanceRecord attendanceRecord = new AttendanceRecord();
//                attendanceRecord.setDate(resultSet.getString("date"));
//                attendanceRecord.setStatus(resultSet.getString("status"));
//
//                attendanceDetail.addAttendanceRecord(attendanceRecord);
//            }
//
//            System.out.println(attendanceDetails);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return attendanceDetails;
//    }
@Override
public List<AttendanceDetail> getAttendanceDetails(String startDate, String endDate, String className) {
    List<AttendanceDetail> attendanceDetails = new ArrayList<>();

    try (Connection connection = db.getConnection()) {
        // Step 1: Get all students for the specified class
        String studentQuery = "SELECT * FROM students WHERE class = ?";
        PreparedStatement studentStatement = connection.prepareStatement(studentQuery);
        studentStatement.setString(1, className);
        ResultSet studentResultSet = studentStatement.executeQuery();

        while (studentResultSet.next()) {
            int rollNo = studentResultSet.getInt("roll_no");
            String firstName = studentResultSet.getString("first_name");
            String classNameResult = studentResultSet.getString("class");

            AttendanceDetail attendanceDetail = new AttendanceDetail();
            attendanceDetail.setRollNo(rollNo);
            attendanceDetail.setFirstName(firstName);
            attendanceDetail.setClassName(classNameResult);
            attendanceDetail.setAttendance(new ArrayList<>());

            attendanceDetails.add(attendanceDetail);
        }

        // Step 2: Get attendance records for each student within the specified date range
        String attendanceQuery = "SELECT a.roll_no, a.date, a.status " +
                "FROM attendance a " +
                "JOIN students s ON a.roll_no = s.roll_no " +
                "WHERE s.class = ? " +
                "AND a.date BETWEEN ? AND ?";
        PreparedStatement attendanceStatement = connection.prepareStatement(attendanceQuery);
        attendanceStatement.setString(1, className);
        attendanceStatement.setString(2, startDate);
        attendanceStatement.setString(3, endDate);
        ResultSet attendanceResultSet = attendanceStatement.executeQuery();

        while (attendanceResultSet.next()) {
            int rollNo = attendanceResultSet.getInt("roll_no");
            String date = attendanceResultSet.getString("date");
            String status = attendanceResultSet.getString("status");

            for (AttendanceDetail detail : attendanceDetails) {
                if (detail.getRollNo() == rollNo) {
                    AttendanceRecord attendanceRecord = new AttendanceRecord();
                    attendanceRecord.setDate(date);
                    attendanceRecord.setStatus(status);

                    detail.addAttendanceRecord(attendanceRecord);
                    break;
                }
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return attendanceDetails;
}


}
