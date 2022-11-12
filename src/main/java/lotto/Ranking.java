package lotto;

public enum Ranking {
    _5TH(3, false, 2_000_000_000),
    _4TH(4, false, 30_000_000),
    _3RD(5, false, 1_500_000),
    _2ND(5, true, 50_000),
    _1ST(6, false, 5_000);

    private int correctNumberCount;
    private boolean isBonus;
    private int price;

    Ranking(int correctNumberCount, boolean isBonus, int price) {
        this.correctNumberCount = correctNumberCount;
        this.isBonus = isBonus;
        this.price = price;
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
}
