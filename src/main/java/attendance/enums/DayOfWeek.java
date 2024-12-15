package attendance.enums;

public enum DayOfWeek {
    월(1),
    화(2),
    수(3),
    목(4),
    금(5),
    토(6),
    일(7);

    private final int dayOfWeek;

    DayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public static DayOfWeek getDayOfWeek(int dayOfWeek) {
        if (dayOfWeek == 1) {
            return DayOfWeek.월;
        } else if (dayOfWeek == 2) {
            return DayOfWeek.화;
        } else if (dayOfWeek == 3) {
            return DayOfWeek.수;
        } else if (dayOfWeek == 4) {
            return DayOfWeek.목;
        } else if (dayOfWeek == 5) {
            return DayOfWeek.금;
        } else if (dayOfWeek == 6) {
            return DayOfWeek.토;
        } else if (dayOfWeek == 7) {
            return DayOfWeek.일;
        }
        return null;
    }
}
