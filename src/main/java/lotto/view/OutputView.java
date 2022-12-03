package lotto.view;

import lotto.domain.EntireLotto;
import lotto.domain.LottoResult;
import lotto.utils.Ranking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class OutputView {
    public void showEntireLottoInfo(EntireLotto entireLotto) {
        System.out.println(entireLotto.getSize() + "개를 구매했습니다.");
        System.out.println(entireLotto.getEntireLottoInfo());
    }

    public void showRankingResult(LottoResult lottoResult, BigDecimal yield) {
        StringBuffer rankingResult = new StringBuffer();
        for (Ranking value : Ranking.values()) {
            if (value == Ranking.EMPTY) {
                continue;
            }
            rankingResult.append(value.getMessage(lottoResult.getWinningRankingCount(value))).append("\n");
        }
        BigDecimal finalYield = yield.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat yieldFormat = new DecimalFormat("#,##0.0");
        rankingResult.append("총 수익률은 ").append(yieldFormat.format(finalYield)).append("%입니다.").append("\n");
        System.out.println(rankingResult);
    }
}
