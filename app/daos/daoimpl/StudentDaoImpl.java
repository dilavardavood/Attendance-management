// app/dao/StudentDaoImpl.java
package daos.daoimpl;

import daos.StudentDao;
import models.students.Student;
import play.api.db.Database;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final Database db;

    @Inject
    public StudentDaoImpl(Database db) {
        this.db = db;

    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            String query = "SELECT * FROM students";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setRollNo(resultSet.getInt("roll_no"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                student.setDob(resultSet.getString("dob"));
                student.setImageUrl(resultSet.getString("image_url"));
                student.setMobileNo(resultSet.getString("mobile_no"));
                student.setGuardian(resultSet.getString("guardian"));
                student.setGuardianNumber(resultSet.getString("guardian_number"));
                student.setClassName(resultSet.getString("class_name"));
                student.setUpdatedBy(resultSet.getString("updated_by"));
                student.setUpdatedOn(resultSet.getString("updated_on"));

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public void addStudent(Student student) {
        try (Connection connection = db.getConnection()) {
            String query = "INSERT INTO students (roll_no, first_name, last_name, email, dob, image_url, mobile_no, guardian, guardian_number, class_name, updated_by) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, student.getRollNo());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getDob());
            statement.setString(6, student.getImageUrl());
            statement.setString(7, student.getMobileNo());
            statement.setString(8, student.getGuardian());
            statement.setString(9, student.getGuardianNumber());
            statement.setString(10, student.getClassName());
            statement.setString(11, student.getUpdatedBy());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
