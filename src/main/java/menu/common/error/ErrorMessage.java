package menu.common.error;

public enum ErrorMessage {
    NO_CATEGORY_OPTION("해당하는 카테고리가 존재하지 않습니다."),
    ERROR_COACH_NAME_LENGTH("코치 이름은 최소 2글자, 최대 4글자 이어야 합니다."),
    ERROR_NO_EAT_MENUS_SIZE("못 먹는 메뉴의 개수는 최소 0개, 최대 2개 이어야 합니다."),
    ERROR_NOT_IN_MENUBOARD("해당 메뉴는 없는 메뉴입니다. 다시 입력해주세요."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}