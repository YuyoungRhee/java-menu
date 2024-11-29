package menu.controller;

import static menu.common.constants.MenuConstants.MENU_REQUEST_DAYS;

import java.util.List;
import menu.domain.Coach;
import menu.domain.MenuBoard;
import menu.domain.MenuPlanner;
import menu.domain.MenuSelector;
import menu.dto.MenuForCoachDto;
import menu.view.OutputView;

public class MenuController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public MenuController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void run() {
        outputView.displayStartMessage();

        List<Coach> coaches = inputHandler.getCoaches();

        MenuSelector menuSelector = new MenuSelector(MenuBoard.getInstance());
        MenuPlanner menuPlanner = new MenuPlanner(MENU_REQUEST_DAYS, coaches, menuSelector);
        List<MenuForCoachDto> menuForCoachDtos = menuPlanner.selectMenus();

        outputView.displayResult(menuForCoachDtos);

    }

}
