package lotto.domain;

import lotto.utils.Ranking;

import java.math.BigDecimal;
import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<Ranking, Integer> lottoResult = new EnumMap<>(Ranking.class);
    private BigDecimal totalYield = new BigDecimal(0);

    public void applyLottoRanking(Ranking ranking) {
        lottoResult.put(ranking, lottoResult.getOrDefault(ranking, 0) + 1);
    }

    public BigDecimal calculateYield(int money) {
        for (Ranking ranking : lottoResult.keySet()) {
            totalYield = totalYield.add(BigDecimal.valueOf(ranking.getPrice() / (double) money * 100));
        }
        return totalYield;
    }

    public int getWinningRankingCount(Ranking ranking) {
        return lottoResult.getOrDefault(ranking, 0);
    }
}
