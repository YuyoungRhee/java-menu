package menu.domain;

import static menu.common.error.ErrorMessage.ERROR_NOT_IN_MENUBOARD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.util.Util;

public class MenuBoard {
    private static final Map<Category, List<Menu>> menuBoard = MenuBoardInitializer.initialize();
    ;
    private static final MenuBoard INSTANCE = new MenuBoard();

    public static MenuBoard getInstance() {
        return INSTANCE;
    }

    public static List<Menu> toMenus(String input) {
        List<String> parsed = Util.parseInputByCommaCanNull(input);

        List<Menu> menus = parsed.stream()
                .map(Menu::from)
                .collect(Collectors.toList());

        validateMenus(menus);

        return menus;
    }

    private static void validateMenus(List<Menu> menus) {
        List<String> allMenus = menuBoard.values().stream()
                .flatMap(List::stream)
                .map(Menu::getName)
                .collect(Collectors.toList());

        for (Menu menu : menus) {
            if (!allMenus.contains(menu.getName())) {
                throw new IllegalArgumentException(ERROR_NOT_IN_MENUBOARD.getMessage());
            }
        }

    }

    public Menu menuSelector(List<Menu> beforeMenus, List<Menu> noEatMenus, Category category) {
        List<Menu> menus = getMenusBy(category);

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

    private List<Menu> getMenusBy(Category category) {
        return menuBoard.get(category);
    }

}
