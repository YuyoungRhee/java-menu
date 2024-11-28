package menu.domain;

public class Menu {
    private final String name;

    public Menu(String name) {
        this.name = name;
    }

    public static Menu from(String name) {
        return new Menu(name);
    }

    public String getName() {
        return name;
    }
}
