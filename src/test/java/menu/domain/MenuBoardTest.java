package menu.domain;

import static menu.common.error.ErrorMessage.ERROR_NOT_IN_MENUBOARD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuBoardTest {

    @DisplayName("메뉴판에 존재하지 않는 경우 예외를 발생시킨다. ")
    @Test
    void validateMenus_Exception() {
        assertThatThrownBy(() -> {
            List<Menu> menus = MenuBoard.toMenus("없음");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_IN_MENUBOARD.getMessage());
    }

    @DisplayName("메뉴판에 존재하는 경우 예외를 발생시키지 않는다.")
    @Test
    void validateMenus() {
        List<Menu> menus = MenuBoard.toMenus("김밥");

        assertThat(menus).hasSize(1);
    }

}