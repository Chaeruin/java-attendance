package attendance.service;

import attendance.domain.Crew;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;

public class AttendanceService {
    public LocalDateTime checkingAttend(Crew crew, LocalDateTime inputTime) {
        LocalDateTime now = DateTimes.now();
        int date = now.getDayOfMonth();
        LocalDateTime newAttend = LocalDateTime.of(2024, 12, date, inputTime.getHour(), inputTime.getMinute());
        crew.getAttendance().addToAttendBook(newAttend);
        return newAttend;
    }

    public LocalDateTime modifyingAttend(Crew crew, int date, LocalDateTime inputTime) {
        LocalDateTime newAttend = LocalDateTime.of(2024, 12, date, inputTime.getHour(), inputTime.getMinute());
        crew.getAttendance().deleteKeyByDate(date);
        crew.getAttendance().addToAttendBook(newAttend);
        crew.getAttendance().setAttendByKeyDate(newAttend);
        crew.setAttendCount();
        crew.setAttendanceSubject();
        return newAttend;
    }
}
