package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.util.Util;

public class MenuBoardInitializer {

    public static Map<Category, List<Menu>> initialize() {
        Map<Category, List<Menu>> menuBoard = new HashMap<>();

        menuBoard.put(Category.JAPANESE, convertToMenus("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"));
        menuBoard.put(Category.KOREAN, convertToMenus("김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"));
        menuBoard.put(Category.CHINESE, convertToMenus("깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"));
        menuBoard.put(Category.ASIAN, convertToMenus("팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"));
        menuBoard.put(Category.WESTERN, convertToMenus("라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"));

        return menuBoard;
    }

    private static List<Menu> convertToMenus(String input) {
        List<String> parsed = Util.parseInputByComma(input);

        return parsed.stream()
                .map(Menu::new)
                .collect(Collectors.toList());
    }
}
