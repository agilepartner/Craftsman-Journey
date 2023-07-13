
public class TennisGame1 implements TennisGame {

    private int score1 = 0;
    private int score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        checkPlayerName(player1Name);
        checkPlayerName(player2Name);
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private void checkPlayerName(String playerName) {
        if (playerName == null || playerName.isEmpty())
            throw new IllegalArgumentException("playerName cannot be null or empty");
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            score1 += 1;
        else if (player2Name.equals(playerName))
            score2 += 1;
        else
            throw new UnsupportedOperationException("player does not play in this game");
    }

    public String getScore() {
        if (equality())
            return equalityScore();
        if (advantage())
            return advantageScore();

        return defaultScore();
    }

    private boolean equality() {
        return score1 == score2;
    }

    private String equalityScore() {
        return switch (score1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private boolean advantage() {
        return score1 >= 4 || score2 >= 4;
    }

    private String advantageScore() {
        int difference = score1 - score2;

        if (difference == 1)
            return  "Advantage player1";
        else if (difference == -1)
            return  "Advantage player2";
        else if (difference >= 2)
            return  "Win for player1";
        else
            return  "Win for player2";
    }

    private String defaultScore() {
        return  getScore(score1) + "-" + getScore(score2);
    }

    private String getScore(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new UnsupportedOperationException("Cannot score");
        };
    }
}
