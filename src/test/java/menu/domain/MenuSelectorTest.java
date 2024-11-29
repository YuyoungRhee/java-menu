package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuSelectorTest {

    @DisplayName("메뉴를 고른다.")
    @Test
    void menuSelector() {
        // given
        MenuSelector menuSelector = new MenuSelector(MenuBoard.getInstance());


        // when
        List<Menu> beforeMenus = List.of();
        List<Menu> noEatMenus = List.of();
        Category category = Category.JAPANESE;
        Menu menu = menuSelector.selectMenu(beforeMenus, noEatMenus, category);

        // then
        assertThat(menu).isNotNull();
    }

    @DisplayName("메뉴를 고른다. - 중복메뉴는 고르지 않는다")
    @Test
    void menuSelector_noDuplicate() {
        // given
        MenuSelector menuSelector = new MenuSelector(MenuBoard.getInstance());
        List<Menu> selected = new ArrayList<>();

        // when
        List<Menu> beforeMenus = List.of(Menu.from("라멘"));
        List<Menu> noEatMenus = List.of();
        Category category = Category.JAPANESE;
        for (int i = 0; i < 100; i++) {
            Menu menu = menuSelector.selectMenu(beforeMenus, noEatMenus, category);
            selected.add(menu);
        }

        // then
        assertThat(!selected.contains(Menu.from("라멘"))).isTrue();
    }

    @DisplayName("메뉴를 고른다. - 못 먹는 메뉴는 고르지 않는다")
    @Test
    void menuSelector_noEat() {
        // given
        MenuSelector menuSelector = new MenuSelector(MenuBoard.getInstance());
        List<Menu> selected = new ArrayList<>();

        // when
        List<Menu> beforeMenus = List.of();
        List<Menu> noEatMenus = List.of(Menu.from("라멘"));
        Category category = Category.JAPANESE;
        for (int i = 0; i < 100; i++) {
            Menu menu = menuSelector.selectMenu(beforeMenus, noEatMenus, category);
            selected.add(menu);
        }

        // then
        assertThat(!selected.contains(Menu.from("라멘"))).isTrue();
    }

}