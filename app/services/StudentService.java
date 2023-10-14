// app/services/StudentService.java
package services;

import models.students.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
}
