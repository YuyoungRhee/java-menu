package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static final String NULL_OR_BLANK_INPUT = "[ERROR] 입력값은 비어있거나 공백일 수 없습니다.";

    public static List<String> parseInputByComma(String input) {
        validateNullOrBlank(input);
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> parseInputByCommaCanNull(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateNullOrBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_BLANK_INPUT);
        }
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }


}
