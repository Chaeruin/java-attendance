package attendance.domain;

import attendance.enums.Attend;
import attendance.enums.AttendanceSubject;
import java.util.HashMap;
import java.util.Map;

public class Crew implements Comparable<Crew> {

    private final String name;
    private AttendanceSubject subject;

    private Map<Attend, Integer> attendCount;
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

    public Map<Attend, Integer> getAttendCount() {
        return attendCount;
    }

    public void setSubject(AttendanceSubject subject) {
        this.subject = subject;
    }

    public void setAttendCount() {
        this.attendCount = new HashMap<>();
        this.attendCount.put(Attend.출석, this.attendance.attendCount());
        this.attendCount.put(Attend.지각, this.attendance.lateCount());
        this.attendCount.put(Attend.결석, this.attendance.absentCount());
    }

    public void setAttendanceSubject() {
        int absent = this.attendCount.get(Attend.결석);
        int late = this.attendCount.get(Attend.지각);

        absent += late / 3;

        if (absent == AttendanceSubject.경고.getWarning()) {
            this.subject = AttendanceSubject.경고;
        } else if (absent >= AttendanceSubject.면담.getWarning() && absent < AttendanceSubject.제적.getWarning()) {
            this.subject = AttendanceSubject.면담;
        } else if (absent >= AttendanceSubject.제적.getWarning()) {
            this.subject = AttendanceSubject.제적;
        }
    }

    @Override
    public int compareTo(Crew otherCrew) {
        return otherCrew.getSubject().getWarning() - this.subject.getWarning();
    }

}
