package attendance.view;

import attendance.domain.Crew;
import attendance.enums.Attend;
import attendance.enums.DayOfWeek;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map.Entry;

public class OutputView {

    public void printCheckingAttend(LocalDateTime goTime, Crew crew, LocalDateTime key) {
        LocalDateTime now = DateTimes.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println(now.getMonthValue() + "월 " + now.getDayOfMonth() + "일 " + DayOfWeek.getDayOfWeek(
                now.getDayOfWeek().getValue()) + "요일 " + goTime.format(formatter) + " (" + crew.getAttendance()
                .getAttendanceBook().get(key).name() + ")");
    }

    // 이전 상태 불러오기 실패
    public void printModifyingAttend(LocalDateTime modifyTime, Crew crew, LocalDateTime key) {
        LocalDateTime now = modifyTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println(now.getMonthValue() + "월 " + now.getDayOfMonth() + "일 " + DayOfWeek.getDayOfWeek(
                now.getDayOfWeek().getValue()) + "요일 " + modifyTime.format(formatter) + " (" + crew.getAttendance()
                .getAttendanceBook().get(key).name() + ") -> " + modifyTime.format(formatter) + " ("
                + crew.getAttendance().getAttendanceBook().get(key).name() + ") 수정 완료!");
    }

    public void printAttendCheck(Crew crew) {
        System.out.println("이번달 " + crew.getName() + "의 출석 기록입니다.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월 dd일");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        for (Entry<LocalDateTime, Attend> cb : crew.getAttendance().getAttendanceBook().entrySet()) {
            System.out.print(cb.getKey().format(formatter) + " " + DayOfWeek.getDayOfWeek(
                    cb.getKey().getDayOfWeek().getValue()) + "요일 ");
            if (cb.getKey().getHour() == 0 && cb.getKey().getMinute() == 0) {
                System.out.println("--:--" + " (" + cb.getValue() + ")");
            } else {
                System.out.println(cb.getKey().format(formatter2) + " (" + cb.getValue() + ")");
            }

        }
    }
}
