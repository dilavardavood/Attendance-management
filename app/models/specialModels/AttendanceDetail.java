package models.specialModels;


import java.util.ArrayList;
import java.util.List;

public class AttendanceDetail {
    private int rollNo;
    private String firstName;

    public void addAttendanceRecord(AttendanceRecord record) {
        if (attendance == null) {
            attendance = new ArrayList<>();
        }
        attendance.add(record);
    }
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<AttendanceRecord> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<AttendanceRecord> attendance) {
        this.attendance = attendance;
    }

    private String className;
    private List<AttendanceRecord> attendance;

    // Add getters and setters
}
