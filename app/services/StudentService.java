
package services;

import com.google.inject.ImplementedBy;
import models.students.Student;
import services.serviceimpl.StudentServiceImpl;

import java.util.List;

@ImplementedBy(StudentServiceImpl.class)
public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Student student);
    void addStudent(Student student);
}
