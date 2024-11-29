package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.dto.MenuForCoachDto;

public class OutputView {

    public void displayStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void displayResult(List<MenuForCoachDto> dtos) {
        System.out.println("메뉴 추천 결과입니다.");

        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.printf("[ 카테고리 | %s | %s | %s | %s | %s ]%n",
                Category.KOREAN.getName(), Category.WESTERN.getName(), Category.JAPANESE.getName(), Category.CHINESE.getName(), Category.ASIAN.getName()
        );
        for (MenuForCoachDto dto : dtos) {
            System.out.printf("[ %s | %s | %s | %s | %s | %s ]%n",
                    dto.getCoachName(), dto.getMenuNames().get(0), dto.getMenuNames().get(1), dto.getMenuNames().get(2), dto.getMenuNames().get(3), dto.getMenuNames().get(4));
        }

        System.out.println("추천을 완료했습니다.");
    }
}
