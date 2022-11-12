package lotto;

import lotto.domain.EntireLotto;
import lotto.domain.RankingCount;
import lotto.domain.WinningNumbers;
import lotto.view.inputView.BonusNumberInputView;
import lotto.view.inputView.WinningNumberInputView;
import lotto.view.outputView.YieldOutputView;

public class LottoJudgementController {
    private WinningNumbers winningNumbers;

    public LottoJudgementController() {
        String inputWinningNumbers = WinningNumberInputView.inputWinningNumbers();
        String inputBonusNumber = BonusNumberInputView.inputBonusNumber();
        this.winningNumbers = new WinningNumbers(inputWinningNumbers, inputBonusNumber);
    }

    public void calculateTotalResult(EntireLotto entireLotto, RankingCount rankingCount) {
        calculateEntireLottoRanking(entireLotto, rankingCount);
        calculateYield(rankingCount, entireLotto.getLottoCount() * 1000);
    }

    private void calculateEntireLottoRanking(EntireLotto entireLotto, RankingCount rankingCount) {
        entireLotto.judgementEntireLottoWinning(winningNumbers, rankingCount);
        rankingCount.showRankingCount();
    }

    private double calculateYield(RankingCount rankingCount, int paymentMoney) {
        double yield = rankingCount.calculateYield(paymentMoney);
        YieldOutputView.showYield(yield);
        return yield;
    }
}
