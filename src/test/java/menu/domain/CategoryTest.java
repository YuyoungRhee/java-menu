package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @DisplayName("카테고리를 고른다")
    @Test
    void selectCategory() {
        // when
        Category selectedCategory = Category.selectCategory(List.of());

        // then
        System.out.println("selectedCategory = " + selectedCategory);
        assertThat(selectedCategory).isNotNull();
    }

    @DisplayName("카테고리는 최대 2회까지 선택 가능하다. - 카테고리 고르는 것을 10번 반복하면 모든 카테고리를 2회씩 고르게된다.")
    @Test
    void selectCategory_notInCurrentCategorys() {
        //givne
        List<Category> selectedCategorys = new ArrayList<>();

        // when
        for (int i = 0; i < 10; i++) {
            Category selectedCategory = Category.selectCategory(selectedCategorys);
            selectedCategorys.add(selectedCategory);
        }

        // then
        Map<String, List<Category>> collect = selectedCategorys.stream()
                .collect(Collectors.groupingBy(Category::getName));

        assertThat(collect.get(Category.JAPANESE.getName())).hasSize(2);
        assertThat(collect.get(Category.KOREAN.getName())).hasSize(2);
        assertThat(collect.get(Category.CHINESE.getName())).hasSize(2);
        assertThat(collect.get(Category.CHINESE.getName())).hasSize(2);
        assertThat(collect.get(Category.WESTERN.getName())).hasSize(2);
    }

}