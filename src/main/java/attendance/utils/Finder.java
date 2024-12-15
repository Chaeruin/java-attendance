package attendance.utils;

import attendance.domain.Crew;
import attendance.dto.CrewStatus;
import java.util.List;

public class Finder {
    public static Crew findCrewByName(List<Crew> crews, String name) {
        for (Crew crew : crews) {
            if (CrewStatus.of(crew).name().equals(name)) {
                return crew;
            }
        }
        return null;
    }

}
