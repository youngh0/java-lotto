package lotto;

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
}
