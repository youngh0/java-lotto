package lotto.view;

import lotto.domain.EntireLotto;
import lotto.domain.LottoResult;
import lotto.utils.Ranking;

public class OutputView {
    public void showEntireLottoInfo(EntireLotto entireLotto) {
        System.out.println(entireLotto.getSize() + "개를 구매했습니다.");
        System.out.println(entireLotto.getEntireLottoInfo());
    }

    public void showRankingResult(LottoResult lottoResult) {
        StringBuffer rankingResult = new StringBuffer();
        for (Ranking value : Ranking.values()) {
            if (value == Ranking.EMPTY) {
                continue;
            }
            rankingResult.append(value.getMessage(lottoResult.getWinningRankingCount(value))).append("\n");
        }
        System.out.println(rankingResult);
    }
}
