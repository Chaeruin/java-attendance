package attendance.domain;

import attendance.enums.Attend;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Attendance {
    private List<Map<LocalDateTime, Attend>> attendanceBook;
}
