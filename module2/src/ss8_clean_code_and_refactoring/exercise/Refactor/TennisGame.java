package ss8_clean_code_and_refactoring.exercise.Refactor;


public class TennisGame {

    static final int LOVE = 0;
    static final int FIFTEEN = 1;
    static final int THIRTY = 2;
    static final int FORTY = 3;

    static final String LOVE_ALL = "Love-All";
    static final String FIFTEEN_ALL = "Fifteen-All";
    static final String THIRTY_ALL = "Thirty-All";
    static final String FORTY_ALL = "Forty-All";
    static final String DEUCE = "Deuce";

    public static String getScore(String player1Name, String player2Name, int score1, int score2) {
        boolean isScoreEqual = score1 == score2;
        boolean isScore1GreaterThan4 = score1 >= 4;
        boolean isScore2GreaterThan4 = score2 >= 4;

        if (isScoreEqual) {
            return displayScoreEqual(score1);
        }

        if (isScore1GreaterThan4 || isScore2GreaterThan4) {
            return displayScoreGreaterThan4(player1Name, player2Name, score1, score2);
        }

        return displayScoreElse(score1, score2);
    }

    private static String displayScoreElse(int score1, int score2) {
        String displayScoreBuilder = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = score1;
            } else {
                displayScoreBuilder += "-";
                tempScore = score2;
            }
            switch (tempScore) {
                case LOVE:
                    displayScoreBuilder += "Love";
                    break;
                case FIFTEEN:
                    displayScoreBuilder += "Fifteen";
                    break;
                case THIRTY:
                    displayScoreBuilder += "Thirty";
                    break;
                case FORTY:
                    displayScoreBuilder += "Forty";
                    break;
            }
        }
        return displayScoreBuilder;
    }

    private static String displayScoreGreaterThan4(String player1Name, String player2Name, int score1, int score2) {
        int minusResult = score1 - score2;

        if (minusResult == 1) {
            return "Advantage " + player1Name;
        }
        if (minusResult == -1) {
            return "Advantage " + player2Name;
        }
        if (minusResult >= 2) {
            return "Win for " + player1Name;
        }
        return "Win for " + player2Name;
    }

    private static String displayScoreEqual(int score) {
        switch (score) {
            case LOVE:
                return LOVE_ALL;
            case FIFTEEN:
                return FIFTEEN_ALL;
            case THIRTY:
                return THIRTY_ALL;
            case FORTY:
                return FORTY_ALL;
            default:
                return DEUCE;

        }
    }
}
