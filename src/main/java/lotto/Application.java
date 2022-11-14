package lotto;

import lotto.controller.BuyLottoController;
import lotto.controller.LottoJudgementController;
import lotto.domain.EntireLotto;
import lotto.domain.RankingCount;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BuyLottoController buyLottoController = new BuyLottoController();
            int lottoCount = buyLottoController.calculatePossibleBuyLottoNumber();
            EntireLotto entireLotto = buyLottoController.buyLotto(lottoCount, new EntireLotto());
            entireLotto.showEntireLottoInfo();

            LottoJudgementController lottoJudgementController = new LottoJudgementController();
            lottoJudgementController.calculateTotalResult(entireLotto, new RankingCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
