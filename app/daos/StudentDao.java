// app/dao/StudentDao.java
package daos;

import models.students.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
    void addStudent(Student student);
}
