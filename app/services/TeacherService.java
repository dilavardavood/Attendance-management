package services;

import com.google.inject.ImplementedBy;
import models.teachers.Teacher;
import services.serviceimpl.TeacherServiceImpl;

import java.util.List;

@ImplementedBy(TeacherServiceImpl.class)
public interface TeacherService {
    void addTeacher(Teacher teacher);
    Teacher getTeacherById(int teacherId);
    List<Teacher> getAllTeachers();
}
