package attendance.enums;

public enum OperatingTime {
    월(13, 18),
    화(10, 18),
    수(10, 18),
    목(10, 18),
    금(10, 18),
    토(10, 18),

    일(10, 18);

    private final int startHour;
    private final int endHour;

    OperatingTime(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

}
