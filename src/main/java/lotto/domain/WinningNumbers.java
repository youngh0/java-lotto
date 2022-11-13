package lotto.domain;

import lotto.utils.Constant;
import lotto.utils.ExceptionMessages;
import lotto.utils.LottoNumberRange;

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
        validateBonusNumberDuplicate(this.bonusNumber);
    }

    public boolean contains(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean hasBonusNumber(int lottoNumber) {
        return bonusNumber == lottoNumber;
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
        winningNumbers.forEach(LottoNumberRange::validateLottoNumberRage);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        LottoNumberRange.validateLottoNumberRage(bonusNumber);
    }

    private int validateBonusNumberHasCharacter(String bonusNumber) {
        if (!bonusNumber.matches(BONUS_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.BONUS_NUMBER_HAS_ONLY_NUMBER);
        }
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumberDuplicate(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessages.BONUS_NUMBER_DUPLICATE);
        }
    }
}
