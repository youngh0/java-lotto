package lotto.domain;

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

    public void ranking(WinningNumbers winningNumbers, RankingCount rankingCount) {
        for (Lotto lotto : entireLotto) {
            int count = 0;
            boolean isBonus = false;
            for (int index = 0; index < 6; index++) {
                int lottoNumber = lotto.getIndexLottoNumber(index);
                if (winningNumbers.contains(lottoNumber)) {
                    count += 1;
                }
                if (winningNumbers.hasBonusNumber(lottoNumber)) {
                    isBonus = true;
                }
            }

            for (Ranking value : Ranking.values()) {
                if (value.getCorrectNumberCount() == count && value.isBonus() == isBonus) {
                    rankingCount.plusRankingCount(value.name());
                }
            }
        }
    }
}
