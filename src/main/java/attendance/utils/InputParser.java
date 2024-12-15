package attendance.utils;

import attendance.domain.Crew;
import attendance.enums.ErrorMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

public class InputParser {


    public static Crew parseCrew(List<Crew> crews, String input) {
        if (Finder.findCrewByName(crews, input) != null) {
            return Finder.findCrewByName(crews, input);
        } else {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NICKNAME.getErrorMessage());
        }
    }

    public static LocalDateTime parseDateTime(LocalDateTime then, String input) {
        try {
            if (InputValidator.isValidHour(input) && InputValidator.isOnCampusTime(
                    input)) {
                int day = then.getDayOfMonth();
                int hour = Integer.parseInt(input.split(":")[0]);
                int minute = Integer.parseInt(input.split(":")[1]);
                LocalDateTime inputTime = LocalDateTime.of(2024, 12, day, hour, minute);
                return inputTime;
            }
        } catch (DateTimeParseException | NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
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
