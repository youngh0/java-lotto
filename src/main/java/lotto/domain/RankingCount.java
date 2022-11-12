package lotto.domain;

import lotto.view.outputView.LottoRankingOutputView;

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
                    .append("개");
        }
        LottoRankingOutputView.showLottoRankingInfo(rankingInfo);
    }

    public double calculateYield(int paymentMoney) {
        int totalPrice = calculateTotalPrice();
        double per = totalPrice / (paymentMoney * 0.01);
        return Math.round(per * 10) * 0.1;
    }

    private int calculateTotalPrice() {
        int total = 0;
        for (String rank : rankingCount.keySet()) {
            total += Ranking.valueOf(rank).getPrice() * rankingCount.get(rank);
        }
        return total;
    }
}
