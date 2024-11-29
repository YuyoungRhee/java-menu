package menu.dto;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Menu;

public class MenuForCoachDto {
    private final String coachName;
    private final List<Menu> menus;

    public MenuForCoachDto(String coach, List<Menu> menus) {
        this.coachName = coach;
        this.menus = menus;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getMenuNames() {
        return menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
    }
}
