package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;

public class MenuBoard {
    private final Map<Category, List<Menu>> menuBoard;

    public MenuBoard() {
        this.menuBoard = MenuBoardInitializer.initialize();
    }

    public Menu menuSelector(List<Menu> beforeMenus, List<Menu> noEatMenus, Category category) {
        List<Menu> menus = getMenusBy(category);

        while(true) {
            Menu menu = Randoms.shuffle(menus).get(0);

            if(!beforeMenus.contains(menu) && !noEatMenus.contains(menu) ) {
                return menu;
            }
        }

    }

    private List<Menu> getMenusBy(Category category) {
        return menuBoard.get(category);
    }

}
