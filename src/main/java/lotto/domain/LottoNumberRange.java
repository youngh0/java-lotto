package lotto.domain;

import lotto.utils.ExceptionMessages;

public enum LottoNumberRange {
    MIN(1),
    MAX(45);

    private final int range;

    LottoNumberRange(int range) {
        this.range = range;
    }

    public static void validateLottoNumberRage(int lottoNumber) {
        if (lottoNumber < MIN.range || lottoNumber > MAX.range) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_OUT_OF_RANGE);
        }
    }
}
