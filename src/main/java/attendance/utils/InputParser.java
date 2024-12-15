package attendance.utils;

import attendance.domain.Crew;
import attendance.enums.ErrorMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InputParser {

    public static String parseMenu(String input) {
        if (InputValidator.isMenuInput(input)) {
            return input;
        }
        return null;
    }

    public static Crew parseCrew(List<Crew> crews, String input) {
        if (Finder.findCrewByName(crews, input) != null) {
            return Finder.findCrewByName(crews, input);
        } else {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NICKNAME.getErrorMessage());
        }
    }

    public static LocalDateTime parseDateTime(String input) {
        if (InputValidator.isNowWeekEnd(input) && InputValidator.isOnCampusTime(input) && InputValidator.isValidHour(
                input)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalDateTime inputTime = LocalDateTime.parse(input, formatter);
            return inputTime;
        }
        return null;
    }

    public static int parseDate(String input) {
        if (InputValidator.isModifyThenWeekEnd(input) && InputValidator.isFutureDate(input)) {
            return Integer.parseInt(input);
        }
        return 0;
    }


}
