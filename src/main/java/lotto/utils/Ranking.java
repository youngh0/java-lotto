package lotto.utils;


import java.util.stream.Stream;

//3개 일치 (5,000원) - 1개
//        4개 일치 (50,000원) - 0개
//        5개 일치 (1,500,000원) - 0개
//        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//        6개 일치 (2,000,000,000원) - 0개
public enum Ranking {
    RANKING_ONE(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    RANKING_TWO(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RANKING_THREE(5, false, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    RANKING_FOUR(4, false, 50_000, "4개 일치 (50,000원) - %d개"),
    RANKING_FIVE(3, false, 5_000, "3개 일치 (5,000원) - %d개"),
    EMPTY(0, false, 0, "");

    private final int correctNumber;
    private final boolean correctBonusNumber;
    private final int price;
    private final String message;

    Ranking(int correctNumber, boolean correctBonusNumber, int price, String message) {
        this.correctNumber = correctNumber;
        this.correctBonusNumber = correctBonusNumber;
        this.price = price;
        this.message = message;
    }

    public String getMessage(int count) {
        return String.format(message, count);
    }

    public int getPrice() {
        return price;
    }

    public static Ranking findRanking(int correctNumberCount, boolean isBonusMatching) {
        if (correctNumberCount == 5) {
            return Stream.of(values())
                    .filter(ranking -> ranking.correctNumber == correctNumberCount && ranking.correctBonusNumber == isBonusMatching)
                    .findFirst()
                    .orElse(EMPTY);
        }
        return Stream.of(values())
                .filter(ranking -> ranking.correctNumber == correctNumberCount)
                .findFirst()
                .orElse(EMPTY);
    }
}
