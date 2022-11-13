package lotto.domain;

import lotto.view.outputView.LottoRankingOutputView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class RankingCount {
    private Map<String, Integer> rankingCount = new LinkedHashMap<>();

    public RankingCount() {
        for (Ranking ranking : Ranking.values()) {
            rankingCount.put(ranking.name(), 0);
        }
    }

    public void plusRankingCount(String rank) {
        rankingCount.put(rank, rankingCount.get(rank) + 1);
    }

    public void showRankingCount() {
        StringBuffer rankingInfo = new StringBuffer();
        for (String rank : rankingCount.keySet()) {
            rankingInfo.append(Ranking.valueOf(rank).getPrintFormat())
                    .append(" - ")
                    .append(rankingCount.get(rank))
                    .append("개")
                    .append("\n");
        }
        LottoRankingOutputView.showLottoRankingInfo(rankingInfo);
    }

    public double calculateYield(int paymentMoney) {
        int totalPrice = calculateTotalPrice();
        double yield = totalPrice / (paymentMoney * 0.01);
        return new BigDecimal(yield).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private int calculateTotalPrice() {
        int total = 0;
        for (String rank : rankingCount.keySet()) {
            total += Ranking.valueOf(rank).getPrice() * rankingCount.get(rank);
        }
        return total;
    }
}
