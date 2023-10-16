package services.serviceimpl;

import daos.TeacherDao;
import models.teachers.Teacher;
import services.TeacherService;

import javax.inject.Inject;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;

    @Inject
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        return teacherDao.getTeacherById(teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }
}
