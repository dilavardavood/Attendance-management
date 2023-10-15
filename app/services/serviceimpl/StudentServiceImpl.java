
package services.serviceimpl;

import daos.StudentDao;
import models.students.Student;
import services.StudentService;

import javax.inject.Inject;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Inject
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentById(Student student) {
        return studentDao.getStudentById(student);
    }
    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }
}
