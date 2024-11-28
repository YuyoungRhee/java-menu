package menu.domain;

import static menu.common.constants.MenuConstants.*;
import static menu.common.error.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<Menu> noEatMenus;
    private final MenuBoard menuBoard;

    public Coach(String name, List<Menu> noEatMenus, MenuBoard menuBoard) {
        this.name = name;
        validateName(name);
        this.noEatMenus = noEatMenus;
        validateNoEatMenus(noEatMenus);
        this.menuBoard = menuBoard;
    }

    private void validateName(String name) {
        if(name.length() < MIN_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH.getMessage());
        }

        if(name.length() > MAX_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH.getMessage());
        }
    }

    private void validateNoEatMenus(List<Menu> noEatMenus) {
        if(noEatMenus.size() > MAX_NO_EAT_MENUS_SIZE) {
            throw new IllegalArgumentException(ERROR_NO_EAT_MENUS_SIZE.getMessage());
        }
    }

    public List<Menu> requestMenuSelect(int days) {
        List<Menu> selectedMenus = new ArrayList<>();
        List<Category> selectedCategories = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            Category selectedCategory = Category.selectCategory(selectedCategories);
            Menu menu = menuBoard.menuSelector(selectedMenus, noEatMenus, selectedCategory);

            selectedMenus.add(menu);
            selectedCategories.add(selectedCategory);
        }
        return selectedMenus;
    }

}
