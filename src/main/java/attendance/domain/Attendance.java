package attendance.domain;

import attendance.enums.Attend;
import attendance.enums.DayOfWeek;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class Attendance {
    private Map<LocalDateTime, Attend> attendanceBook;

    public Attendance(Map<LocalDateTime, Attend> attendanceBook) {
        this.attendanceBook = attendanceBook;
    }

    public Map<LocalDateTime, Attend> getAttendanceBook() {
        return this.attendanceBook;
    }

    public Attend addToAttendBook(LocalDateTime localDateTime) {
        LocalTime inputTime = LocalTime.of(localDateTime.getHour(), localDateTime.getMinute());
        LocalTime standardTime = null;
        if (DateTimes.now().getDayOfWeek().getValue() == DayOfWeek.월.getDayOfWeek()) {
            standardTime = LocalTime.of(13, 0);
        } else {
            standardTime = LocalTime.of(10, 0);
        }
        long minutesBetween = ChronoUnit.MINUTES.between(inputTime, standardTime) % 60;
        Attend result = null;
        if (minutesBetween < 5) {
            result = Attend.출석;
        } else if (minutesBetween >= 5 && minutesBetween <= 30) {
            result = Attend.지각;
        } else {
            result = Attend.결석;
        }
        this.attendanceBook.put(localDateTime, result);
        return result;
    }
}
