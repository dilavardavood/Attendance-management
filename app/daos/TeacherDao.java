package daos;

import com.google.inject.ImplementedBy;
import daos.daoimpl.TeacherDaoImpl;
import models.teachers.Teacher;

import java.util.List;

@ImplementedBy(TeacherDaoImpl.class)
public interface TeacherDao {
    void addTeacher(Teacher teacher);
    Teacher getTeacherById(int teacherId);
    List<Teacher> getAllTeachers();
}
