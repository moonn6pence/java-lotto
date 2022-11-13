package lotto.exception;

import lotto.view.OutputView;

public class NumberOutOfRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "로또 번호는 1부터 45 사이여야 합니다.";

    public NumberOutOfRangeException() {
        super(MESSAGE);
    }
}
