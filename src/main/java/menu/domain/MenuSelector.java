package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.dto.MenuForCoachDto;

public class MenuSelector {
    private final int wantDays;
    private final List<Coach> coaches;
    private final List<Category> selectedCategories = new ArrayList<>();

    public MenuSelector(int days, List<Coach> coaches) {
        this.wantDays = days;
        this.coaches = coaches;
    }

    public List<MenuForCoachDto> selectMenus() {
        proceedSelectMenus();

        List<MenuForCoachDto> dtos = new ArrayList<>();
        for (Coach coach : coaches) {
            MenuForCoachDto menuForCoachDto = makeSingleResult(coach);
            dtos.add(menuForCoachDto);
        }
        return dtos;
    }

    private void proceedSelectMenus() {
        for (int day = 0; day < wantDays; day++) {
            Category selectedCategory = Category.selectCategory(selectedCategories);

            for (Coach coach : coaches) {
                coach.requestMenuSelect(day, selectedCategory);
            }
        }
    }

    private MenuForCoachDto makeSingleResult(Coach coach) {
        List<Menu> selectedMenus = coach.getSelectedMenus();

        return new MenuForCoachDto(coach.getName(), selectedMenus);
    }




}
