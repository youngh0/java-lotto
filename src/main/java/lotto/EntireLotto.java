package lotto;

import lotto.utils.LottoGenerator;
import lotto.view.outputView.EntireLottoOutputView;

import java.util.ArrayList;
import java.util.List;

public class EntireLotto {
    private LottoGenerator lottoGenerator;
    private List<Lotto> entireLotto;

    public EntireLotto() {
        lottoGenerator = new LottoGenerator();
        entireLotto = new ArrayList<>();
    }

    public void generateEntireLotto(int entireLottoCount) {
        for (int count = 0; count < entireLottoCount; count++) {
            entireLotto.add(lottoGenerator.generateLotto());
        }
    }

    public void showEntireLottoInfo() {
        StringBuffer lottoInfo = new StringBuffer();
        lottoInfo.append(entireLotto.size()).append("개를 구매했습니다.").append("\n");
        for (Lotto lotto : entireLotto) {
            lottoInfo.append(lotto.toString()).append("\n");
        }
        EntireLottoOutputView.showEntireLottoInfo(lottoInfo);
    }
}
