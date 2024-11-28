package menu.common.error;

public enum ErrorMessage {
    NO_CATEGORY_OPTION("해당하는 카테고리가 존재하지 않습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}