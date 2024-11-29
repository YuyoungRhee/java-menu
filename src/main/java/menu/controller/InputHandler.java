package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.common.validator.CoachValidator;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuBoard;
import menu.util.Util;
import menu.view.InputView;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public List<Coach> getCoaches() {
        List<String> coachNames = getCoachNames();
        return createCoaches(coachNames);
    }

    private List<String> getCoachNames() {
        return RetryUtil.inputWithRetry(() -> {
            String namesInput = inputView.readCoachNames();
            List<String> coachNames = Util.parseInputByComma(namesInput);
            for (String name : coachNames) {
                CoachValidator.validateName(name);
            }
            return coachNames;
        });
    }

    private List<Coach> createCoaches(List<String> names) {
        List<Coach> coaches = new ArrayList<>();

        for (String name : names) {
            Coach coach = createSingleCoach(name);
            coaches.add(coach);
        }
        return coaches;
    }

    private Coach createSingleCoach(String name) {
        List<Menu> menus = askNoEatMenusTo(name);
        return Coach.of(name, menus);
    }

    private List<Menu> askNoEatMenusTo(String name) {
        return RetryUtil.inputWithRetry(() -> {
            String input = inputView.readNoEatMenus(name);

            return MenuBoard.toMenus(input);
        });
    }

}
