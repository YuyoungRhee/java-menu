package menu.domain;

import static menu.common.error.ErrorMessage.NO_CATEGORY_OPTION;

import java.util.Arrays;
import java.util.List;
import menu.util.Util;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5),
    ;

    private final String name;
    private final int number;

    Category(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static Category selectCategory(List<Category> currentCategories) {
        while (true) {
            int randomNumber = Util.generateRandomNumber();

            Category selectedCategory = findByNumber(randomNumber);

            long categoryCount = currentCategories.stream()
                    .filter(category -> category.equals(selectedCategory))
                    .count();

            if(categoryCount < 2) {
                return selectedCategory;
            }
        }
    }

    public static Category findByNumber(int requestNumber) {
        return Arrays.stream(Category.values())
                .filter(category -> category.number == requestNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_CATEGORY_OPTION.getMessage()));
    }

    public String getName() {
        return name;
    }
}
