package daos.daoimpl;

import daos.TeacherDao;
import models.teachers.Teacher;
import play.api.db.Database;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    private final Database db;

    @Inject
    public TeacherDaoImpl(Database db) {
        this.db = db;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        try (Connection connection = db.getConnection()) {
            String query = "INSERT INTO teachers (teacher_id, first_name, last_name, designation, dob, mobile_no, email, updated_by, updated_on, class_teacher) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, teacher.getTeacherId());
            statement.setString(2, teacher.getFirstName());
            statement.setString(3, teacher.getLastName());
            statement.setString(4, teacher.getDesignation());
            statement.setString(5, teacher.getDob());
            statement.setString(6, teacher.getMobileNo());
            statement.setString(7, teacher.getEmail());
            statement.setString(8, teacher.getUpdatedBy());
            statement.setString(9, teacher.getUpdatedOn());
            statement.setString(10, teacher.getClassTeacher());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        try (Connection connection = db.getConnection()) {
            String query = "SELECT * FROM teachers WHERE teacher_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, teacherId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt("teacher_id"));
                teacher.setFirstName(resultSet.getString("first_name"));
                teacher.setLastName(resultSet.getString("last_name"));
                teacher.setDesignation(resultSet.getString("designation"));
                teacher.setDob(resultSet.getString("dob"));
                teacher.setMobileNo(resultSet.getString("mobile_no"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setUpdatedBy(resultSet.getString("updated_by"));
                teacher.setUpdatedOn(resultSet.getString("updated_on"));
                teacher.setClassTeacher(resultSet.getString("class_teacher"));

                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            String query = "SELECT * FROM teachers";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt("teacher_id"));
                teacher.setFirstName(resultSet.getString("first_name"));
                teacher.setLastName(resultSet.getString("last_name"));
                teacher.setDesignation(resultSet.getString("designation"));
                teacher.setDob(resultSet.getString("dob"));
                teacher.setMobileNo(resultSet.getString("mobile_no"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setUpdatedBy(resultSet.getString("updated_by"));
                teacher.setUpdatedOn(resultSet.getString("updated_on"));
                teacher.setClassTeacher(resultSet.getString("class_teacher"));

                teacherList.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacherList;
    }
}
