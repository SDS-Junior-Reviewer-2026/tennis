package tenniskata;

class TennisGame {

    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};

    private int score1 = 0;
    private int score2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            score1++;
        } else {
            score2++;
        }
    }

    public String getScore() {
        if (isDeuce()) {
            return "Deuce";
        }
        if (isAllScore()) {
            return SCORE_NAMES[score1] + "-All";
        }
        if (isAdvantageOrWin()) {
            return getAdvantageOrWinScore();
        }
        return SCORE_NAMES[score1] + "-" + SCORE_NAMES[score2];
    }

    private boolean isAllScore() {
        return score1 == score2;
    }

    private boolean isDeuce() {
        return score1 == score2 && (score1 >= 3 || score2 >= 3);
    }

    private boolean isAdvantageOrWin() {
        return score1 >= 4 || score2 >= 4;
    }

    private String getAdvantageOrWinScore() {
        int diff = score1 - score2;

        if (diff == 1) return "Advantage " + player1Name;
        if (diff == -1) return "Advantage " + player2Name;
        if (diff >= 2)  return "Win for " + player1Name;
        return "Win for " + player2Name;
    }
}