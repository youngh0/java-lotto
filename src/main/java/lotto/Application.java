package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLottoController buyLottoController = new BuyLottoController(new EntireLotto());
        EntireLotto entireLotto = buyLottoController.BuyLotto();
        entireLotto.showEntireLottoInfo();
    }
}
