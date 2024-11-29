package menu;

import menu.controller.InputHandler;
import menu.controller.MenuController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputHandler inputHandler = new InputHandler(inputView);
        OutputView outputView = new OutputView();

        MenuController controller = new MenuController(inputHandler, outputView);
        controller.run();
    }
}
