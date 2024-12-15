package attendance.utils;

import attendance.enums.ErrorMessage;

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

    
}
