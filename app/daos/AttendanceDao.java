package daos;

import com.google.inject.ImplementedBy;
import daos.daoimpl.AttendanceDaoImpl;
import models.attendance.Attendance;

import java.util.List;

@ImplementedBy(AttendanceDaoImpl.class)
public interface AttendanceDao {
    void addAttendance(Attendance attendance);
    void addBulkAttendance(List<Attendance> attendanceList);

    List<Attendance> getAttendanceByRollNo(Attendance attendance);
}
