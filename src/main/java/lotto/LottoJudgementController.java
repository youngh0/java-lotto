package lotto;

import lotto.domain.EntireLotto;
import lotto.domain.RankingCount;
import lotto.domain.WinningNumbers;
import lotto.view.inputView.BonusNumberInputView;
import lotto.view.inputView.WinningNumberInputView;

public class LottoJudgementController {
    private WinningNumbers winningNumbers;
    private int paymentMoney;

    public LottoJudgementController(int paymentMoney) {
        this.paymentMoney = paymentMoney;
        String inputWinningNumbers = WinningNumberInputView.inputWinningNumbers();
        String inputBonusNumber = BonusNumberInputView.inputBonusNumber();
        this.winningNumbers = new WinningNumbers(inputWinningNumbers, inputBonusNumber);
    }

    public void calculateEntireLottoRanking(EntireLotto entireLotto, RankingCount rankingCount) {
        entireLotto.judgementEntireLottoWinning(winningNumbers, rankingCount);
        rankingCount.showRankingCount();
        double yield = rankingCount.calculateYield(paymentMoney);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
