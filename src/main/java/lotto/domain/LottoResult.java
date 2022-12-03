package lotto.domain;

import lotto.utils.Ranking;

import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<Ranking, Integer> lottoResult = new EnumMap<>(Ranking.class);

    public void applyLottoRanking(Ranking ranking) {
        lottoResult.put(ranking, lottoResult.getOrDefault(ranking, 0) + 1);
    }

    public void showTotal() {
        for (Ranking ranking : lottoResult.keySet()) {
            System.out.println(ranking.toString());
        }
    }

    public int getWinningRankingCount(Ranking ranking) {
        return lottoResult.getOrDefault(ranking, 0);
    }
}
