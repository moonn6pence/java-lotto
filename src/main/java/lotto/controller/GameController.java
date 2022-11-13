package lotto.controller;

import lotto.domain.ingame.Lotto;
import lotto.domain.ingame.LottoFactory;
import lotto.domain.ingame.LuckyNumbers;
import lotto.domain.ingame.Payment;
import lotto.domain.result.Statistic;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {

        final Payment payment = makePayment();
        final List<Lotto> userLotto = issueLotto(Payment.getTicket());
        outputView.showLotto(userLotto);

        final LuckyNumbers luckyNumbers = makeLuckyNumbers();
        final Statistic statistic = makeStatistic(userLotto,luckyNumbers);
        outputView.showStatistic(statistic);
    }


    private Payment makePayment() {
        return new Payment.createPayment(inputView.inputPayment());
    }

    private LuckyNumbers makeLuckyNumbers() {
        return LottoFactory.createLuckyNumbers(inputView.inputLuckyNumbers(), inputView.inputBonus());
    }

    private List<Lotto> issueLotto(int tickets) {
        return new LottoFactory.createLotto(tickets);
    }

    private Statistic makeStatistic(List<Lotto> userLotto, LuckyNumbers luckyNumbers) {
        return new Statistic(userLotto,luckyNumbers);
    }


}
