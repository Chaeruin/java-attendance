package attendance.domain;

import attendance.enums.Attend;
import attendance.enums.DayOfWeek;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

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
        if (minutesBetween < 5 && minutesBetween > -5) {
            result = Attend.출석;
        } else if ((minutesBetween >= 5 && minutesBetween <= 30) || (minutesBetween <= -5 && minutesBetween >= -30)) {
            result = Attend.지각;
        }
        if (inputTime.getHour() == 0 && inputTime.getMinute() == 0 || minutesBetween > 30 || minutesBetween < -30) {
            result = Attend.결석;
        }
        this.attendanceBook.put(localDateTime, result);
        return result;
    }

    public void deleteKeyByDate(int date) {
        LocalDateTime key = null;
        for (Entry<LocalDateTime, Attend> att : attendanceBook.entrySet()) {
            if (att.getKey().getDayOfMonth() == date) {
                key = att.getKey();
            }
        }
        if (key != null) {
            attendanceBook.remove(key);
        }
    }

    public LocalDateTime findByKeyByDate(int date) {
        for (Entry<LocalDateTime, Attend> ab : this.attendanceBook.entrySet()) {
            if (ab.getKey().getDayOfMonth() == date) {
                return ab.getKey();
            }
        }
        return null;
    }

    public void setAttendByKeyDate(LocalDateTime date) {
        this.attendanceBook.put(date, this.addToAttendBook(date));
    }

    public void sortAttend() {
        this.attendanceBook = new TreeMap<>(this.attendanceBook);
    }

    public int attendCount() {
        int attend = 0;
        for (Entry<LocalDateTime, Attend> ab : this.attendanceBook.entrySet()) {
            if (ab.getValue() == Attend.출석) {
                attend++;
            }
        }
        return attend;
    }

    public int absentCount() {
        int absent = 0;
        for (Entry<LocalDateTime, Attend> ab : this.attendanceBook.entrySet()) {
            if (ab.getValue() == Attend.결석) {
                absent++;
            }
        }
        return absent;
    }

    public int lateCount() {
        int late = 0;
        for (Entry<LocalDateTime, Attend> ab : this.attendanceBook.entrySet()) {
            if (ab.getValue() == Attend.지각) {
                late++;
            }
        }
        return late;
    }
}