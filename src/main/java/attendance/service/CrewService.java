package attendance.service;

import attendance.domain.Crew;
import attendance.enums.Attend;
import attendance.utils.FileRead;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CrewService {

    public List<Crew> settingCrewsAbsent() {
        List<Crew> crews = FileRead.fileReadToAttendance();

        int day = 2;
        for (Crew crew : crews) {
            Map<LocalDateTime, Attend> crewBook = new TreeMap<>(crew.getAttendance().getAttendanceBook());
            List<LocalDateTime> tmp = new ArrayList<>();
            for (Entry<LocalDateTime, Attend> crb : crewBook.entrySet()) {
                while (day != crb.getKey().getDayOfMonth()) {
                    LocalDateTime dateTime = LocalDateTime.of(2024, 12, day, 0, 0);
                    tmp.add(dateTime);
                    day++;
                }
                if (day == DateTimes.now().getDayOfMonth()) {
                    break;
                }
            }
            for (LocalDateTime t : tmp) {
                crew.getAttendance().addToAttendBook(t);
            }
            crew.getAttendance().sortAttend();
            day = 2;
        }

        return crews;
    }
}
