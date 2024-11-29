package menu.domain;

import java.util.List;
import menu.util.Util;

public class CategorySelector {
    public static Category selectCategory(List<Category> currentCategories) {
        while (true) {
            int randomNumber = Util.generateRandomNumber();

            Category selectedCategory = Category.findByNumber(randomNumber);

            long categoryCount = currentCategories.stream()
                    .filter(category -> category.equals(selectedCategory))
                    .count();

            if(categoryCount < 2) {
                return selectedCategory;
            }
        }
    }
}
