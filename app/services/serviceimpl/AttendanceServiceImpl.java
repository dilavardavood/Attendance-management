package services.serviceimpl;

import daos.AttendanceDao;
import models.attendance.Attendance;
import services.AttendanceService;

import javax.inject.Inject;
import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceDao attendanceDao;

    @Inject
    public AttendanceServiceImpl(AttendanceDao attendanceDao) {
        this.attendanceDao = attendanceDao;
    }

    @Override
    public void addAttendance(Attendance attendance) {
        attendanceDao.addAttendance(attendance);
    }

    @Override
    public void addBulkAttendance(List<Attendance> attendanceList) {
        attendanceDao.addBulkAttendance(attendanceList);
    }

    @Override
    public List<Attendance> getAttendanceByRollNo(Attendance attendance) {
        return attendanceDao.getAttendanceByRollNo(attendance);
    }
}