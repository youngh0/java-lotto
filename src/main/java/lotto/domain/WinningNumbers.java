package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }
}
