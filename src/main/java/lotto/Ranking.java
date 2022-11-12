package lotto;

public enum Ranking {
    _1ST(6, false, 5_000, 0),
    _2ND(5, true, 50_000, 0),
    _3RD(5, false, 1_500_000, 0),
    _4TH(4, false, 30_000_000, 0),
    _5TH(3, false, 2_000_000_000, 0);

    private int correctNumberCount;
    private boolean isBonus;
    private int price;
    private int count;

    Ranking(int correctNumberCount, boolean isBonus, int price, int count) {
        this.correctNumberCount = correctNumberCount;
        this.isBonus = isBonus;
        this.price = price;
        this.count = count;
    }

    public void plusRankingCount(String ranking) {
        Ranking.valueOf(ranking).count += 1;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
