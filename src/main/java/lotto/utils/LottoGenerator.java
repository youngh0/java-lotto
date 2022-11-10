package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class LottoGenerator {
    public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}