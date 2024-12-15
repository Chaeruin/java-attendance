package attendance.utils;

import attendance.enums.ErrorMessage;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputValidator {
    // 메뉴 입력 문자가 아닌 경우
    public static boolean isMenuInput(String input) {
        if (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
        return true;
    }

    // 유효하지 않은 시간 입력 예외
    public static boolean isValidHour(String input) {
        String[] hourMinute = input.split(":");
        int hour = Integer.parseInt(hourMinute[0]);
        int minute = Integer.parseInt(hourMinute[1]);
        if (hour > 24 || hour < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
        if (minute > 59 || minute < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
        return true;
    }

    public static boolean isValidDate(String input) {
        try {
            int inputs = Integer.parseInt(input);
            if (inputs < 1 || inputs > 31) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
        return true;
    }

    public static boolean isFutureDate(String input) {
        LocalDateTime now = DateTimes.now();
        int day = now.getDayOfMonth();
        if (isValidDate(input) && (day < Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FUTURE_DATE.getErrorMessage());
        }
        return true;
    }

    public static boolean isNowWeekEnd(String input) {
        LocalDateTime now = DateTimes.now();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int dayOfWeek = now.getDayOfWeek().getValue();
        if (dayOfWeek == 6) {
            throw new IllegalArgumentException("[ERROR] " + month + "월 " + day + "일 토요일은 등교일이 아닙니다.");
        }
        if (dayOfWeek == 7) {
            throw new IllegalArgumentException("[ERROR] " + month + "월 " + day + "일 일요일은 등교일이 아닙니다.");
        }
        return true;
    }

    public static boolean isModifyThenWeekEnd(String input) {
        int day = 0;
        if (isValidDate(input)) {
            day = Integer.parseInt(input);
        }
        LocalDate now = LocalDate.of(2024, 12, day);
        int dayOfWeek = now.getDayOfWeek().getValue();
        if (dayOfWeek == 6) {
            throw new IllegalArgumentException("[ERROR] 12월 " + day + "일 토요일은 등교일이 아닙니다.");
        }
        if (dayOfWeek == 7) {
            throw new IllegalArgumentException("[ERROR] 12월 " + day + "일 일요일은 등교일이 아닙니다.");
        }
        return true;
    }

    public static boolean isOnCampusTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime inputTime = LocalDateTime.parse(input, formatter);
        LocalDateTime campusStartTime = LocalDateTime.parse("08:00", formatter);
        LocalDateTime campusEndTime = LocalDateTime.parse("23:00", formatter);
        // 확인 필요
        if ((inputTime.isEqual(campusStartTime) || inputTime.isAfter(campusStartTime)) && (inputTime.isEqual(
                campusEndTime)) || inputTime.isBefore(campusEndTime)) {
            return true;
        } else {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TIME_CAMPUS.getErrorMessage());
        }
    }

}
