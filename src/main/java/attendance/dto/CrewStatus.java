package attendance.dto;

import attendance.domain.Attendance;
import attendance.domain.Crew;
import attendance.enums.AttendanceSubject;

public record CrewStatus(
        String name,
        AttendanceSubject subject,
        Attendance attendance
) {

    public static CrewStatus of(final Crew crew) {
        return new CrewStatus(
                crew.getName(),
                crew.getSubject(),
                crew.getAttendance()
        );
    }

}
