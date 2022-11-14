package lotto.controller;

import lotto.domain.EntireLotto;
import lotto.domain.PaymentLottoMoney;
import lotto.view.inputView.MoneyInputView;

public class BuyLottoController {

    public int calculatePossibleBuyLottoNumber() {
        String paymentMoney = MoneyInputView.inputMoney();
        return new PaymentLottoMoney(paymentMoney).calculateNumberOfLotto();
    }

    public EntireLotto buyLotto(int lottoCount, EntireLotto entireLotto) {
        entireLotto.generateEntireLotto(lottoCount);
        return entireLotto;
    }
}
