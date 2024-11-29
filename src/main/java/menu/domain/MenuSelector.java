package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class MenuSelector {
    private final MenuBoard menuBoard;

    public MenuSelector(MenuBoard menuBoard) {
        this.menuBoard = menuBoard;
    }

    public Menu selectMenu(List<Menu> beforeMenus, List<Menu> noEatMenus, Category category) {
        List<Menu> menus = menuBoard.getMenusBy(category);

        while (true) {
            List<String> menuNames = menus.stream()
                    .map(Menu::getName)
                    .collect(Collectors.toList());

            String menuName =  Randoms.shuffle(menuNames).get(0);
            Menu menu = Menu.from(menuName);

            if (!beforeMenus.contains(menu) && !noEatMenus.contains(menu)) {
                return menu;
            }
        }

    }
}
