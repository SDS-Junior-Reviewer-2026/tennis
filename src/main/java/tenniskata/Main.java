package tenniskata;

class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String[] score_names = { "Love", "Fifteen", "Thirty", "Forty" };

        if (m_score1 == m_score2) {
            if (m_score1 < 3) {
                return score_names[m_score1] + "-All";
            }
            else {
                return "Deuce";
            }
        }

        if (m_score1 < 4 && m_score2 < 4) {
            return score_names[m_score1] + "-" + score_names[m_score2];
        }

        String result = "";

        if (Math.abs(m_score1 - m_score2) == 1) {
            result += "Advantage ";
        }
        else {
            result += "Win for ";
        }

        if (m_score1 > m_score2)
            result += player1Name;
        else
            result += player2Name;

        return result;
    }
}

public class Main {
    static Object[][] testCase = {
            {0, 0, "Love-All"},
            {1, 1, "Fifteen-All"},
            {2, 2, "Thirty-All"},
            {3, 3, "Deuce"},
            {4, 4, "Deuce"},
            {1, 0, "Fifteen-Love"},
            {0, 1, "Love-Fifteen"},
            {2, 0, "Thirty-Love"},
            {0, 2, "Love-Thirty"},
            {3, 0, "Forty-Love"},
            {0, 3, "Love-Forty"},
            {4, 0, "Win for player1"},
            {0, 4, "Win for player2"},
            {2, 1, "Thirty-Fifteen"},
            {1, 2, "Fifteen-Thirty"},
            {3, 1, "Forty-Fifteen"},
            {1, 3, "Fifteen-Forty"},
            {4, 1, "Win for player1"},
            {1, 4, "Win for player2"},
            {3, 2, "Forty-Thirty"},
            {2, 3, "Thirty-Forty"},
            {4, 2, "Win for player1"},
            {2, 4, "Win for player2"},
            {4, 3, "Advantage player1"},
            {3, 4, "Advantage player2"},
            {5, 4, "Advantage player1"},
            {4, 5, "Advantage player2"},
            {15, 14, "Advantage player1"},
            {14, 15, "Advantage player2"},
            {6, 4, "Win for player1"},
            {4, 6, "Win for player2"},
            {16, 14, "Win for player1"},
            {14, 16, "Win for player2"},
    };

    public static void main(String[] args) {
        for (int i = 0; i < 33; i++) {
            TennisGame tennisGame = new TennisGame("player1", "player2");
            for (int p1Cnt = 0; p1Cnt < (Integer) testCase[i][0]; p1Cnt++) {
                tennisGame.wonPoint("player1");
            }
            for (int p2Cnt = 0; p2Cnt < (Integer) testCase[i][1]; p2Cnt++) {
                tennisGame.wonPoint("player2");
            }
            String result = tennisGame.getScore();
            if (result.equals(testCase[i][2])) {
                System.out.println("PASS");
            } else {
                System.out.println("result 가 " + result + "입니다." + (String) (testCase[i][2]) + "여야 합니다");
                System.out.println("FAIL");
            }
        }
    }
}
