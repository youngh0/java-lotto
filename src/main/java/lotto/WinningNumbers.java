package lotto;

import lotto.utils.Constant;
import lotto.utils.ExceptionMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final String IS_DIGIT_REGEX = "^[0-9]*$";
    private final String BONUS_NUMBER_REGEX = "^[0-9]{1,2}";
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(String winningNumbers, String bonusNumber) {
        this.winningNumbers = validateWinningNumberOnlyNumber(validateWinningNumberSixElement(winningNumbers));
        validateNumberRange(this.winningNumbers);

        this.bonusNumber = validateBonusNumberHasCharacter(bonusNumber);
        validateBonusNumberRange(this.bonusNumber);
    }

    private List<String> validateWinningNumberSixElement(String winningNumbers) {
        List<String> separateNumbers = Arrays.asList(winningNumbers.split(","));
        if (separateNumbers.size() != Constant.CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessages.WINNING_NUMBER_HAS_SIX_ELEMENT);
        }
        return separateNumbers;
    }

    private List<Integer> validateWinningNumberOnlyNumber(List<String> winningNumbers) {
        boolean havingNotNumber = winningNumbers.stream()
                .anyMatch(number -> !number.matches(IS_DIGIT_REGEX));
        if (havingNotNumber) {
            throw new IllegalArgumentException(ExceptionMessages.WINNING_NUMBER_HAS_ONLY_NUMBER);
        }
        return convertWinningNumbersToInteger(winningNumbers);
    }

    private List<Integer> convertWinningNumbersToInteger(List<String> winningNumbers) {
        return winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateNumberRange(List<Integer> winningNumbers) {
        boolean outOfRangeCount = winningNumbers.stream()
                .anyMatch(number -> number < Constant.LOTTO_NUMBER_MIN_VALUE || number > Constant.LOTTO_NUMBER_MAX_VALUE);
        if (outOfRangeCount) {
            throw new IllegalArgumentException(ExceptionMessages.WINNING_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber >= Constant.LOTTO_NUMBER_MIN_VALUE && bonusNumber <= Constant.LOTTO_NUMBER_MAX_VALUE) {
            return;
        }
        throw new IllegalArgumentException(ExceptionMessages.BONUS_NUMBER_OUT_OF_RANGE);
    }

    private int validateBonusNumberHasCharacter(String bonusNumber) {
        if (!bonusNumber.matches(BONUS_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.BONUS_NUMBER_HAS_ONLY_NUMBER);
        }
        return Integer.parseInt(bonusNumber);
    }
}
