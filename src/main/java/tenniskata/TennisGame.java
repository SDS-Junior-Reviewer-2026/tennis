package tenniskata;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Player{
    int score;
    String name;

    public void win() {
        score += 1;
    }
}

public class TennisGame {
    private static final Map<Integer, String> scoreNameMap = Map.of(
                    0, "Love",
                    1, "Fifteen",
                    2, "Thirty",
                    3, "Forty"
            );
    private static final int DEUCE_POINT = 4;
    private static final String DASH = "-";
    private static final String ALL = "-All";
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE = "Advantage ";
    private static final String WIN = "Win for ";

    private Player player1 = new Player();
    private Player player2 = new Player();

    public TennisGame(String player1Name, String player2Name) {
        this.player1.name = player1Name;
        this.player2.name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.player1.name))
            player1.win();
        else if (Objects.equals(playerName, this.player2.name))
            player2.win();
    }

    public String getScore() {
        int m_score1 = player1.score;
        int m_score2 = player2.score;

        if (m_score1 == m_score2) {
            return getSamePointCaseScore(m_score1);
        } else if (m_score1 >= DEUCE_POINT || m_score2 >= DEUCE_POINT) {
            return getDeuceCaseScore(player1, player2);
        } else {
            return getUnder4PointCaseScore(m_score1, m_score2);
        }
    }

    private String getSamePointCaseScore(int score) {
        if (score >= 0 && score <= 2) {
            return scoreNameMap.get(score) + ALL;
        }
        return DEUCE;
    }

    private String getDeuceCaseScore(Player m1, Player m2) {
        int minusResult = m1.score - m2.score;
        if (minusResult == 1) return ADVANTAGE + m1.name;
        else if (minusResult == -1) return ADVANTAGE + m2.name;
        else if (minusResult >= 2) return WIN + m1.name;
        else return WIN + m2.name;
    }

    private String getUnder4PointCaseScore(int m_score1, int m_score2) {
        return scoreNameMap.get(m_score1) +
                DASH +
                scoreNameMap.get(m_score2);
    }
}