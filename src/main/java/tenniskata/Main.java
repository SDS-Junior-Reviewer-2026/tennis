package tenniskata;

class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String score = "";

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void wonPointOfPlayer1() {
        m_score1++;
    }

    public void wonPointOfPlayer2() {
        m_score2++;
    }

    public String getScore() {

        if (m_score1==m_score2)
        {
            // 동점 or 듀스
            getSameScore();
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            // 어드밴티지 선수 or 승자
            getAdvantageOrWinScore();
        }
        else
        {
            // 그 외의 점수
            getOriginalScore();
        }
        return score;
    }

    private void getSameScore() {
        switch (m_score1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
    }

    private void getAdvantageOrWinScore() {
        int minusResult = m_score1-m_score2;

        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
    }

    private void getOriginalScore() {
        score = changeScoreToName(m_score1) + "-" + changeScoreToName(m_score2);
    }

    private String changeScoreToName(int score) {
        switch(score)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";

        }
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
                tennisGame.wonPointOfPlayer1();
            }
            for(int p2Cnt = 0 ; p2Cnt < (Integer)testCase[i][1]; p2Cnt ++) {
                tennisGame.wonPointOfPlayer2();
            }
            String result = tennisGame.getScore();
            if (result.equals(testCase[i][2])) {
                System.out.println("PASS");
            }
            else {
                System.out.println("result 가 " + result + "입니다." + (String)(testCase[i][2]) + "여야 합니다");
                System.out.println("FAIL");
            }
        }
    }
}
