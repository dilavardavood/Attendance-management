
package daos;

import com.google.inject.ImplementedBy;
import daos.daoimpl.StudentDaoImpl;
import models.students.Student;

import java.util.List;

@ImplementedBy(StudentDaoImpl.class)
public interface StudentDao {
    List<Student> getAllStudents(Student student);
    Student getStudentById(Student student);
    void addStudent(Student student);
    List<String> getAllClassNames();

}
