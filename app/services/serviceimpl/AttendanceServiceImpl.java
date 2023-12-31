package services.serviceimpl;

import daos.AttendanceDao;
import models.attendance.Attendance;
import models.specialModels.AttendanceDetail;
import models.specialModels.StatusCount;
import models.specialModels.StatusCountWithClass;
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
    @Override
    public List<Attendance> getAttendanceByFilter(Attendance attendance) {
        return attendanceDao.getAttendanceByFilter(attendance);
    }

    @Override
    public List<Attendance> getAllAttendance(Attendance attendance) {
        return attendanceDao.getAllAttendance(attendance);
    }
    @Override
    public StatusCount getAttendanceCountByStatus(Attendance attendance) {
        return attendanceDao.getAttendanceCountByStatus(attendance);
    }
    @Override
    public List<StatusCountWithClass> getStatusCountByDateRange(String startDate, String endDate) {
        return attendanceDao.getStatusCountByDateRange(startDate, endDate);
    }
    @Override
    public List<AttendanceDetail> getAttendanceDetails(String startDate, String endDate,String className) {
        return attendanceDao.getAttendanceDetails(startDate, endDate,className);
    }


}
