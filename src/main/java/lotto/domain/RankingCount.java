package lotto.domain;

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
        for (String rank : rankingCount.keySet()) {
            System.out.println(Ranking.valueOf(rank).getPrintFormat() + " - " + rankingCount.get(rank) + "개");
        }
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
