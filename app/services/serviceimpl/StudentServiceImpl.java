// app/services/StudentServiceImpl.java
package services.serviceimpl;

import daos.StudentDao;
import models.students.Student;
import services.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }
}
