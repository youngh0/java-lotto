package lotto;

import lotto.controller.BuyLottoController;
import lotto.controller.LottoJudgementController;
import lotto.domain.EntireLotto;
import lotto.domain.RankingCount;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLottoController buyLottoController = new BuyLottoController();
        int lottoCount = buyLottoController.calculatePossibleBuyLottoNumber();
        EntireLotto entireLotto = buyLottoController.BuyLotto(lottoCount, new EntireLotto());
        entireLotto.showEntireLottoInfo();

        LottoJudgementController lottoJudgementController = new LottoJudgementController();
        lottoJudgementController.calculateTotalResult(entireLotto, new RankingCount());

    }
}
