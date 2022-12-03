package lotto.controller;

import lotto.domain.EntireLotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.dto.PurchaseAmountDTO;
import lotto.utils.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        EntireLotto entireLotto = new EntireLotto(
                new PurchaseAmountDTO(inputView.inputMoney()).getMoney() / 1000,
                new LottoGenerator());
        outputView.showEntireLottoInfo(entireLotto);
        WinningNumbers winningNumbers = new WinningNumbers(
                inputView.inputWinningNumber(),
                Integer.parseInt(inputView.inputBonusNumber()));
        LottoResult lottoResult = entireLotto.calculateTotalRanking(winningNumbers, new LottoResult());
        BigDecimal bigDecimal = lottoResult.calculateYield(entireLotto.getSize() * 1000);
        outputView.showRankingResult(lottoResult, bigDecimal);
    }
}
