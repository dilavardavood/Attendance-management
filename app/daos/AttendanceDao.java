package daos;

import com.google.inject.ImplementedBy;
import daos.daoimpl.AttendanceDaoImpl;
import models.attendance.Attendance;
import models.specialModels.StatusCount;

import java.util.List;

@ImplementedBy(AttendanceDaoImpl.class)
public interface AttendanceDao {
    void addAttendance(Attendance attendance);
    void addBulkAttendance(List<Attendance> attendanceList);
    List<Attendance> getAllAttendance();
    List<Attendance> getAttendanceByRollNo(Attendance attendance);
    List<Attendance> getAttendanceByFilter(Attendance attendance);
    StatusCount getAttendanceCountByStatus(Attendance attendance);

}
