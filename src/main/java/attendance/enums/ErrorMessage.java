package attendance.enums;

public enum ErrorMessage {
    INVALID_INPUT("[ERROR] 잘못된 형식을 입력하였습니다."),
    INVALID_NICKNAME("[ERROR] 등록되지 않은 닉네임입니다."),
    //    INVALID_DATE("[ERROR] 은 등교일이 아닙니다."),
    INVALID_FUTURE_DATE("[ERROR] 아직 수정할 수 없습니다."),
    INVALID_TIME_CAMPUS("[ERROR] 캠퍼스 운영 시간에만 출석이 가능합니다."),
    INVALID_ALREADY_ATTEND("[ERROR] 이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
