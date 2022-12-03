package lotto.view;

import lotto.domain.EntireLotto;

public class OutputView {
    public void showEntireLottoInfo(EntireLotto entireLotto) {
        System.out.println(entireLotto.getSize() + "개를 구매했습니다.");
        System.out.println(entireLotto.getEntireLottoInfo());
    }
}
