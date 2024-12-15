package attendance.enums;

public enum Attend {
    출석(5),
    지각(30),
    결석(Integer.MAX_VALUE);

    private final int minute;

    Attend(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }
}
