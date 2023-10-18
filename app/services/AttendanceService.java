package services;

import com.google.inject.ImplementedBy;
import models.attendance.Attendance;
import models.specialModels.StatusCount;
import services.serviceimpl.AttendanceServiceImpl;

import java.util.List;

@ImplementedBy(AttendanceServiceImpl.class)
public interface AttendanceService {
    void addAttendance(Attendance attendance);
    void addBulkAttendance(List<Attendance> attendanceList);

    List<Attendance> getAttendanceByRollNo(Attendance attendance);
    List<Attendance> getAttendanceByFilter(Attendance attendance);

    StatusCount getAttendanceCountByStatus(Attendance attendance);
    List<Attendance> getAllAttendance();
}
