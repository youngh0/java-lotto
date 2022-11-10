package lotto;

import lotto.utils.ExceptionMessages;
import java.util.List;

public class Lotto {
    private final int CORRECT_LOTTO_NUMBER_COUNT = 6;
    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    private void validate() {
        isCorrectLottoNumberCount();
        isUniqueLottoNumbers();
        isSatisfiedLottoNumberRange();
    }

    private void isCorrectLottoNumberCount() {
        if (numbers.size() != CORRECT_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_ONLY_SIX_SIZE);
        }
    }

    private void isUniqueLottoNumbers() {
        if (numbers.stream()
                .distinct()
                .count() != CORRECT_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_ONLY_UNIQUE_NUMBERS);
        }
    }

    private void isSatisfiedLottoNumberRange() {
        boolean isOutOfLottoNumberRange = numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER);
        if (isOutOfLottoNumberRange) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_OUT_OF_RANGE);
        }
    }
}
