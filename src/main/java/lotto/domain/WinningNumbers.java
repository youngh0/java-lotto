package lotto.domain;

import lotto.utils.Ranking;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;

    public WinningNumbers(String winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(convertWinningNumber(winningNumbers));
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Ranking calculateRanking(Lotto lotto) {
        int correctLottoNumber = winningNumbers.countCorrectLottoNumber(lotto);
        boolean matchBonusNumber = winningNumbers.isMatchBonusNumber(bonusNumber);
        return Ranking.findRanking(correctLottoNumber, matchBonusNumber);
    }

    private List<Integer> convertWinningNumber(String winningNumber) {
        List<Integer> result = new ArrayList<>();
        for (String number : winningNumber.split(",")) {
            result.add(convertOneWinningNumber(number));
        }
        return result;
    }

    private Integer convertOneWinningNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
