package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public int countCorrectLottoNumber(Lotto playerLotto) {
        int correctNumber = 0;
        for (Integer number : playerLotto.numbers) {
            if (this.numbers.contains(number)) {
                correctNumber++;
            }
        }
        return correctNumber;
    }

    public boolean isMatchBonusNumber(int playerBonusNumber) {
        return this.numbers.contains(playerBonusNumber);
    }

    private void validate(List<Integer> numbers) {
        validateLottoDuplicate(numbers);
    }

    private void validateLottoDuplicate(List<Integer> numbers) {
        long uniqueNumberCount = numbers.stream()
                .distinct()
                .count();
        if (uniqueNumberCount != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
