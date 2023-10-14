// app/controllers/StudentController.java
package controllers;

import models.students.Student;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Content;
import services.StudentService;

import javax.inject.Inject;
import java.util.List;

public class StudentController extends Controller {
    private final StudentService studentService;

    @Inject
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public Result getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ok((Content) students);
    }

    public Result addStudent() {
        Student student = new Student();
        // Set student details
        student.setRollNo(2);
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setEmail("jane.doe@example.com");
        student.setDob("1992-05-20");
        student.setImageUrl("http://example.com/jane.jpg");
        student.setMobileNo("0987654321");
        student.setGuardian("John Doe");
        student.setGuardianNumber("1234567890");
        student.setClassName("Class B");
        student.setUpdatedBy("Admin");

        studentService.addStudent(student);

        return ok("Student added successfully");
    }
}
