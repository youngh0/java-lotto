package lotto.dto;

public class PurchaseAmountDTO {
    private final int money;
    private final int MIN_MONEY = 1000;

    public PurchaseAmountDTO(String money) {
        isDigit(money);
        validateMoneyMinRange(money);
        validateMoneyUnit(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    private void isDigit(String money) {
        String moneyRegex = "^[1-9][0-9]*$";
        if (money.matches(moneyRegex)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private void validateMoneyMinRange(String money) {
        if (Integer.parseInt(money) < MIN_MONEY) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoneyUnit(String money) {
        if (Integer.parseInt(money) % MIN_MONEY != 0) {
            throw new IllegalArgumentException();
        }
    }
}
