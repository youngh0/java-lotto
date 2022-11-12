package lotto;

import lotto.domain.EntireLotto;
import lotto.domain.PaymentLottoMoney;
import lotto.domain.RankingCount;
import lotto.view.inputView.MoneyInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLottoController buyLottoController = new BuyLottoController();
        String paymentMoney = MoneyInputView.inputMoney();
        EntireLotto entireLotto = buyLottoController.BuyLotto(new PaymentLottoMoney(paymentMoney), new EntireLotto());
        entireLotto.showEntireLottoInfo();

        LottoJudgementController lottoJudgementController = new LottoJudgementController();
        lottoJudgementController.calculateTotalResult(entireLotto, new RankingCount());

    }
}
