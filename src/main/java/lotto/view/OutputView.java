package lotto.view;

import lotto.domain.ingame.Lotto;
import lotto.domain.result.Rank;
import lotto.domain.result.Statistic;

import java.util.List;

public class OutputView {

    private static final String PAYMENT_MESSAGE = System.lineSeparator() + "%d개를 구매했습니다." + System.lineSeparator();
    private static final String STAT_MESSAGE = System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---";
    private static final String RANK_MESSAGE = "%d개 일치%s(%d원) - %d개" + System.lineSeparator();
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.2f입니다."+System.lineSeparator();
    private static final String ERROR_MESSAGE = "[ERROR]+%s" + System.lineSeparator();

    public static void showLotto(List<Lotto> userLotto) {

        int ticketCount = userLotto.size();
        System.out.printf(PAYMENT_MESSAGE,ticketCount);

        for (Lotto lotto : userLotto) {

            String format = List.of(lotto).toString();
            System.out.println(format);
        }


    }

    public static void showStatistic(Statistic stat) {
        System.out.println(STAT_MESSAGE);
        for (Rank rank : Rank.getAllRank()) {
            System.out.printf(RANK_MESSAGE, rank.getMatch, isSecond(rank), rank.getPrize, stat.getRankCount(rank));
        }
        System.out.printf(PROFIT_MESSAGE, stat.getProfit());
    }

    private static String isSecond(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return BONUS_MESSAGE;
        }
        return " ";
    }

    public static void showError(Exception exception) {
        System.out.printf(ERROR_MESSAGE,exception.getMessage());
    }
}
