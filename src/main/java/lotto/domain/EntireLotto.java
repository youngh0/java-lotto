package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class EntireLotto {
    private final List<Lotto> entireLotto;

    public EntireLotto(int lottoCount, LottoGenerator lottoGenerator) {
        entireLotto = new ArrayList<>();
        while (lottoCount-- > 0) {
            entireLotto.add(new Lotto(lottoGenerator.createLotto()));
        }
    }

    public LottoResult calculateTotalRanking(WinningNumbers winningNumbers, LottoResult lottoResult) {
        for (Lotto lotto : entireLotto) {
            lottoResult.applyLottoRanking(winningNumbers.calculateRanking(lotto));
        }
        return lottoResult;
    }

    public StringJoiner getEntireLottoInfo() {
        StringJoiner entireLottoInfo = new StringJoiner("\n");
        for (Lotto lotto : entireLotto) {
            entireLottoInfo.add(lotto.toString());
        }
        return entireLottoInfo;
    }

    public int getSize() {
        return entireLotto.size();
    }
}
