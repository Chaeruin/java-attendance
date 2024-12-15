package attendance.view;

import attendance.enums.DayOfWeek;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;

public class InputView {
    public String getMenu() {
        LocalDateTime now = DateTimes.now();
        System.out.println("오늘은 " + now.getMonthValue() + "월 " + now.getDayOfMonth() + "일 "
                + DayOfWeek.getDayOfWeek(now.getDayOfWeek().getValue()).name() + "요일 입니다."
                + "기능을 선택해 주세요.");
        System.out.println("1. 출석 확인\n"
                + "2. 출석 수정\n"
                + "3. 크루별 출석 기록 확인\n"
                + "4. 제적 위험자 확인\n"
                + "Q. 종료");
        return Console.readLine();
    }

    public String getNickName() {
        System.out.println("닉네임을 입력해 주세요.");
        return Console.readLine();
    }

    public String getTime() {
        System.out.println("등교 시간을 입력해 주세요.");
        return Console.readLine();
    }

    public String getModifyNickName() {
        System.out.println("출석을 수정하려는 크루의 닉네임을 입력해 주세요.");
        return Console.readLine();
    }

    public String getModifyDate() {
        System.out.println("수정하려는 날짜(일)를 입력해 주세요.");
        return Console.readLine();
    }

    public String getModifyTime() {
        System.out.println("언제로 변경하겠습니까?");
        return Console.readLine();
    }
}
