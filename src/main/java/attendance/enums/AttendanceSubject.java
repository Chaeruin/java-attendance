package attendance.enums;

public enum AttendanceSubject {
    제적(5),
    면담(3),
    경고(2);

    private final int warning;

    AttendanceSubject(int warning) {
        this.warning = warning;
    }

    public int getWarning() {
        return this.warning;
    }
}
