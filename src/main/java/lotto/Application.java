package lotto;

import lotto.view.inputView.BonusNumberInputView;
import lotto.view.inputView.MoneyInputView;
import lotto.view.inputView.WinningNumberInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLottoController buyLottoController = new BuyLottoController();
        String paymentMoney = MoneyInputView.inputMoney();
        EntireLotto entireLotto = buyLottoController.BuyLotto(new PaymentLottoMoney(paymentMoney), new EntireLotto());
        entireLotto.showEntireLottoInfo();

        String inputWinningNumbers = WinningNumberInputView.inputWinningNumbers();
        String inputBonusNumber = BonusNumberInputView.inputBonusNumber();

        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, inputBonusNumber);
        RankingCount rankingCount = new RankingCount();
        entireLotto.ranking(winningNumbers, rankingCount);
        rankingCount.showRankingCount();
    }
}
