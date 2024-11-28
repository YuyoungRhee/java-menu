package menu.domain;

import static menu.common.constants.MenuConstants.MENU_REQUEST_DAYS;
import static menu.common.error.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {

    @DisplayName("메뉴 추천을 요청한다 - 원하는 일수만큼 메뉴가 만들어진다.")
    @Test
    void requestMenuSelect() {
        // given
        List<Menu> noEatMenus = List.of();
        Coach coach = new Coach("코치", noEatMenus, MenuBoard.getInstance());

        // when
        List<Menu> menus = coach.requestMenuSelect(MENU_REQUEST_DAYS);

        // then
        assertThat(menus).hasSize(5);
    }

    @DisplayName("코치 이름이 2글자 미만이면 예외가 발생한다.")
    @Test
    void validate_Name_MIN() {
        // given
        List<Menu> noEatMenus = List.of();

        //when && then
        assertThatThrownBy(() -> {
            Coach coach = new Coach("코", noEatMenus, MenuBoard.getInstance());
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_COACH_NAME_LENGTH.getMessage());
    }

    @DisplayName("코치 이름이 4글자 초과면 예외가 발생한다.")
    @Test
    void validate_Name_MAX() {
        // given
        List<Menu> noEatMenus = List.of();

        //when && then
        assertThatThrownBy(() -> {
            Coach coach = new Coach("코치코치코", noEatMenus, MenuBoard.getInstance());
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_COACH_NAME_LENGTH.getMessage());
    }

    @DisplayName("못 먹는 메뉴 2개 초과 시 예외가 발생한다.")
    @Test
    void validate_noEatSize() {
        // given
        List<Menu> noEatMenus = List.of(Menu.from("라멘"),Menu.from("김치찌개"), Menu.from("파스타"));

        //when && then
        assertThatThrownBy(() -> {
            Coach coach = new Coach("코치", noEatMenus, MenuBoard.getInstance());
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NO_EAT_MENUS_SIZE.getMessage());
    }


}