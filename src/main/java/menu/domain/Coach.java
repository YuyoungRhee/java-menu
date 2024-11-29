package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.common.validator.CoachValidator;

public class Coach {
    private final String name;
    private final List<Menu> noEatMenus;
    private List<Menu> selectedMenus;
    private final MenuBoard menuBoard = MenuBoard.getInstance();

    private Coach(String name, List<Menu> noEatMenus) {
        this.name = name;
        this.noEatMenus = noEatMenus;
    }

    public static Coach of(String name, List<Menu> noEatMenus) {
        CoachValidator.validateName(name);
        CoachValidator.validateNoEatMenus(noEatMenus);
        return new Coach(name, noEatMenus);
    }

    public Menu requestMenuSelect(int days, Category category, MenuSelector menuSelector) {
        if(days == 0) {
            selectedMenus = new ArrayList<>();
        }

        Menu menu = menuSelector.selectMenu(selectedMenus, noEatMenus, category);
        selectedMenus.add(menu);

        return menu;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getSelectedMenus() {
        return new ArrayList<>(selectedMenus);
    }
}
