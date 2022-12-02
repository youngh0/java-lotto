package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class EntireLotto {
    private final List<Lotto> entireLotto;

    public EntireLotto(int lottoCount, LottoGenerator lottoGenerator) {
        entireLotto = new ArrayList<>();
        while (lottoCount-- > 0) {
            entireLotto.add(new Lotto(lottoGenerator.createLotto()));
        }
    }

    public int getSize() {
        return entireLotto.size();
    }
}
