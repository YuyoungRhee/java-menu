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

    @DisplayName("메뉴를 고른다.")
    @Test
    void menuSelector() {
        // given
        MenuBoard menuBoard = MenuBoard.getInstance();

        // when
        List<Menu> beforeMenus = List.of();
        List<Menu> noEatMenus = List.of();
        Category category = Category.JAPANESE;
        Menu menu = menuBoard.menuSelector(beforeMenus, noEatMenus, category);

        // then
        assertThat(menu).isNotNull();
    }

    @DisplayName("메뉴를 고른다. - 중복메뉴는 고르지 않는다")
    @Test
    void menuSelector_noDuplicate() {
        // given
        MenuBoard menuBoard = MenuBoard.getInstance();
        List<Menu> selected = new ArrayList<>();

        // when
        List<Menu> beforeMenus = List.of(Menu.from("라멘"));
        List<Menu> noEatMenus = List.of();
        Category category = Category.JAPANESE;
        for (int i = 0; i < 100; i++) {
            Menu menu = menuBoard.menuSelector(beforeMenus, noEatMenus, category);
            selected.add(menu);
        }

        // then
        assertThat(!selected.contains(Menu.from("라멘"))).isTrue();
    }

    @DisplayName("메뉴를 고른다. - 못 먹는 메뉴는 고르지 않는다")
    @Test
    void menuSelector_noEat() {
        // given
        MenuBoard menuBoard = MenuBoard.getInstance();
        List<Menu> selected = new ArrayList<>();

        // when
        List<Menu> beforeMenus = List.of();
        List<Menu> noEatMenus = List.of(Menu.from("라멘"));
        Category category = Category.JAPANESE;
        for (int i = 0; i < 100; i++) {
            Menu menu = menuBoard.menuSelector(beforeMenus, noEatMenus, category);
            selected.add(menu);
        }

        // then
        assertThat(!selected.contains(Menu.from("라멘"))).isTrue();
    }

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