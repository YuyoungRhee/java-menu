package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int generate() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
