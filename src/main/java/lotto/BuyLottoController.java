package lotto;

import lotto.domain.EntireLotto;
import lotto.domain.PaymentLottoMoney;

public class BuyLottoController {
    public EntireLotto BuyLotto(PaymentLottoMoney paymentLottoMoney, EntireLotto entireLotto) {
        int lottoCount = paymentLottoMoney.calculateNumberOfLotto();
        entireLotto.generateEntireLotto(lottoCount);
        return entireLotto;
    }
}
