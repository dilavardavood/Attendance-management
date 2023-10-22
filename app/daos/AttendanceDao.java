package daos;

import com.google.inject.ImplementedBy;
import daos.daoimpl.AttendanceDaoImpl;
import models.attendance.Attendance;
import models.specialModels.AttendanceDetail;
import models.specialModels.StatusCount;
import models.specialModels.StatusCountWithClass;

import java.util.List;

@ImplementedBy(AttendanceDaoImpl.class)
public interface AttendanceDao {
    void addAttendance(Attendance attendance);
    void addBulkAttendance(List<Attendance> attendanceList);
    List<Attendance> getAllAttendance(Attendance attendance);
    List<Attendance> getAttendanceByRollNo(Attendance attendance);
    List<Attendance> getAttendanceByFilter(Attendance attendance);
    StatusCount getAttendanceCountByStatus(Attendance attendance);
    List<StatusCountWithClass> getStatusCountByDateRange(String startDate, String endDate);
    List<AttendanceDetail> getAttendanceDetails(String startDate, String endDate, String className);

}
