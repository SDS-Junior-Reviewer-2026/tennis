package tenniskata;

class TennisGame {
    private static final String[] scoreSinglePlayer = { "Love", "Fifteen", "Thirty", "Forty" };
    private int mScore1 = 0;
    private int mScore2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            ++mScore1;
        } else {
            ++mScore2;
        }
    }

    public String getScore() {
        if (mScore1 == mScore2) {
            return getScoreTie();
        }
        if (mScore1 >= 4 || mScore2 >= 4) {
            return getScoreWinOrAdvantage();
        }

        return getScoreUnderFour();
    }

    private String getScoreTie() {
        if (mScore1 < 3) {
            return getScoreSinglePlayer(mScore1) + "-All";
        }

        return "Deuce";
    }

    private String getScoreWinOrAdvantage() {
        int mScoreDiff = mScore1 - mScore2;

        if (mScoreDiff == 1) {
            return "Advantage player1";
        }
        if (mScoreDiff == -1) {
            return "Advantage player2";
        }
        if (mScoreDiff >= 2) {
            return "Win for player1";
        }

        return "Win for player2";
    }

    private String getScoreUnderFour() {
        return getScoreSinglePlayer(mScore1) +
                '-' +
                getScoreSinglePlayer(mScore2);
    }

    private String getScoreSinglePlayer(int mScore) {
        if (mScore > -1 && mScore < 4) {
            return scoreSinglePlayer[mScore];
        }

        throw new IllegalArgumentException("invalid_m_score");
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
            for(int p1Cnt = 0 ; p1Cnt < (Integer)testCase[i][0]; p1Cnt ++) {
                tennisGame.wonPoint("player1");
            }
            for(int p2Cnt = 0 ; p2Cnt < (Integer)testCase[i][1]; p2Cnt ++) {
                tennisGame.wonPoint("player2");
            }
            String result = tennisGame.getScore();
            if (result.equals(testCase[i][2])) {
                System.out.println("PASS");
            }
            else {
                System.out.println("result 가 " + result + "입니다." + testCase[i][2] + "여야 합니다");
                System.out.println("FAIL");
            }
        }
    }
}
