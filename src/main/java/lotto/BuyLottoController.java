package lotto;

import lotto.view.inputView.MoneyInputView;

public class BuyLottoController {
    PaymentLottoMoney paymentLottoMoney;
    EntireLotto entireLotto;

    public BuyLottoController(EntireLotto entireLotto) {
        String money = MoneyInputView.inputMoney();
        paymentLottoMoney = new PaymentLottoMoney(money);
        this.entireLotto = entireLotto;
    }

    public EntireLotto BuyLotto() {
        int lottoCount = paymentLottoMoney.calculateNumberOfLotto();
        entireLotto.generateEntireLotto(lottoCount);
        return entireLotto;
    }
}
