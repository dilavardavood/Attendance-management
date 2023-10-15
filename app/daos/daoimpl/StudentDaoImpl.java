package daos.daoimpl;

import configs.DatabaseExecutionContext;
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
    private final DatabaseExecutionContext executionContext;
    @Inject
    public StudentDaoImpl(Database db,DatabaseExecutionContext executionContext) {
        this.db = db;
        this.executionContext = executionContext;

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
                student.setClassName(resultSet.getString("class"));
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
    public Student getStudentById(Student student) {
        try (Connection connection = db.getConnection()) {
            String query;
            if(student.getEmail() != null){
                query = "SELECT * FROM students WHERE email = ?";
            }
            else{
                query = "SELECT * FROM students WHERE roll_no = ?";
            }
            PreparedStatement statement = connection.prepareStatement(query);
            if (student.getEmail() != null) {
                statement.setString(1, student.getEmail());
            } else {
                statement.setInt(1, student.getRollNo());
            }
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Student retrievedStudent = new Student();
                retrievedStudent.setRollNo(resultSet.getInt("roll_no"));
                retrievedStudent.setFirstName(resultSet.getString("first_name"));
                retrievedStudent.setLastName(resultSet.getString("last_name"));
                retrievedStudent.setEmail(resultSet.getString("email"));
                retrievedStudent.setDob(resultSet.getString("dob"));
                retrievedStudent.setImageUrl(resultSet.getString("image_url"));
                retrievedStudent.setMobileNo(resultSet.getString("mobile_no"));
                retrievedStudent.setGuardian(resultSet.getString("guardian"));
                retrievedStudent.setGuardianNumber(resultSet.getString("guardian_number"));
                retrievedStudent.setClassName(resultSet.getString("class"));
                retrievedStudent.setUpdatedBy(resultSet.getString("updated_by"));
                retrievedStudent.setUpdatedOn(resultSet.getString("updated_on"));

                return (retrievedStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if no student found with the given id
    }


    @Override
    public void addStudent(Student student) {
        try (Connection connection = db.getConnection()) {
            System.out.println(student.getEmail());
            String query = "INSERT INTO students (roll_no, first_name, last_name, email, dob, image_url, mobile_no, guardian, guardian_number, class, updated_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
