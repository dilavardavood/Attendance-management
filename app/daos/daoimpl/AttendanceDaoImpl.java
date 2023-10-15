package daos.daoimpl;

import daos.AttendanceDao;
import models.attendance.Attendance;
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
}
