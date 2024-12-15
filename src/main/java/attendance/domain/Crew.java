package attendance.domain;

import attendance.enums.AttendanceSubject;

public class Crew {

    private final String name;
    private AttendanceSubject subject;

    private Attendance attendance;

    public Crew(String name) {
        this.name = name;
    }

    public Crew(String name, Attendance attendance) {
        this.name = name;
        this.attendance = attendance;
    }

    public String getName() {
        return this.name;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public Attendance getAttendance() {
        return this.attendance;
    }

    public AttendanceSubject getSubject() {
        return this.subject;
    }

    public void setSubject(AttendanceSubject subject) {
        this.subject = subject;
    }

}
