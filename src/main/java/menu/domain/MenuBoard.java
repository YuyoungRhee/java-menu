package menu.domain;

import static menu.common.error.ErrorMessage.ERROR_NOT_IN_MENUBOARD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collection;
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
        List<String> parsed = Util.parseInputByComma(input);

        List<Menu> menus = parsed.stream()
                .map(Menu::from)
                .collect(Collectors.toList());

        validateMenus(menus);

        return menus;
    }

    private static void validateMenus(List<Menu> menus) {
        long count = menus.stream()
                .filter(menu -> menu.isEqualTo(menu))
                .count();

        if (count == 0) {
            throw new IllegalArgumentException(ERROR_NOT_IN_MENUBOARD.getMessage());
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
                System.out.println("selector 메뉴 반환: " + menuName);
                return menu;
            }
        }

    }

    private List<Menu> getMenusBy(Category category) {
        return menuBoard.get(category);
    }

}
