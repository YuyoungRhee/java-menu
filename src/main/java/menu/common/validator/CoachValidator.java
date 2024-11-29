package menu.common.validator;

import static menu.common.constants.MenuConstants.MAX_COACH_NAME_LENGTH;
import static menu.common.constants.MenuConstants.MAX_NO_EAT_MENUS_SIZE;
import static menu.common.constants.MenuConstants.MIN_COACH_NAME_LENGTH;
import static menu.common.error.ErrorMessage.ERROR_COACH_NAME_LENGTH;
import static menu.common.error.ErrorMessage.ERROR_NO_EAT_MENUS_SIZE;

import java.util.List;
import menu.domain.Menu;

public class CoachValidator {

    public static void validateName(String name) {
        if(name.length() < MIN_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH.getMessage());
        }

        if(name.length() > MAX_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH.getMessage());
        }
    }

    public static void validateNoEatMenus(List<Menu> noEatMenus) {
        if(noEatMenus.size() > MAX_NO_EAT_MENUS_SIZE) {
            throw new IllegalArgumentException(ERROR_NO_EAT_MENUS_SIZE.getMessage());
        }
    }
}
