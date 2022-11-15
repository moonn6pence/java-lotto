package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String PAYMENT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LUCKY_BALLS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final Pattern PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private static final String SEPARATOR = ",";

    public static int inputPayment() {
        System.out.println(PAYMENT_MESSAGE);

        String input = Console.readLine();

        validate(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> inputLuckyBalls() {
        System.out.println(LUCKY_BALLS_MESSAGE);

        String input = Console.readLine();

        validateLuckyBalls(input);


        return separate(input);
    }

    public static int inputBonus() {
        System.out.println(BONUS_MESSAGE);

        String input = Console.readLine();

        validate(input);


        return Integer.parseInt(input);
    }


    private static void validate(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 입력입니다.");
        }
    }

    private static void validateLuckyBalls(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 로또 번호 입력 형식입니다.");
        }
    }

    private static List<Integer> separate(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
