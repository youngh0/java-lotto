package lotto;

public class BuyLottoController {
    public EntireLotto BuyLotto(PaymentLottoMoney paymentLottoMoney, EntireLotto entireLotto) {
        int lottoCount = paymentLottoMoney.calculateNumberOfLotto();
        entireLotto.generateEntireLotto(lottoCount);
        return entireLotto;
    }
}
