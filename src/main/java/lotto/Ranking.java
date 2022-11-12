package lotto;

public enum Ranking {
    _5TH(3, false, 2_000_000_000, "3개 일치 (5, 000)"),
    _4TH(4, false, 30_000_000, "4개 일치 (50, 000)"),
    _3RD(5, false, 1_500_000, "5개 일치 (1, 500, 000)"),
    _2ND(5, true, 50_000, "5개 일치, 보너스 볼 일치 (30, 000, 000)"),
    _1ST(6, false, 5_000, "6개 일치 (2, 000, 000, 000)");
    /**
     * 3개 일치 (5, 000) - n개
     * 4개 일치 (50, 000) - n개
     * 5개 일치 (1, 500, 000) - n개
     * 5개 일치, 보너스 볼 일치 (30, 000, 000) - n개
     * 6개 일치 (2, 000, 000, 000) - n개
     */

    private int correctNumberCount;
    private boolean isBonus;
    private int price;
    private String printFormat;

    Ranking(int correctNumberCount, boolean isBonus, int price, String printFormat) {
        this.correctNumberCount = correctNumberCount;
        this.isBonus = isBonus;
        this.price = price;
        this.printFormat = printFormat;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public String getPrintFormat() {
        return printFormat;
    }
}
