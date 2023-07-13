
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        player1.scorePointIfPlayer(playerName);
        player2.scorePointIfPlayer(playerName);
    }

    public String getScore() {
        if (equality())
            return equalityScore();
        if (advantage())
            return advantageScore();

        return defaultScore();
    }

    private boolean equality() {
        return player1.score() == player2.score();
    }

    private String equalityScore() {
        return switch (player1.score()) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private boolean advantage() {
        return player1.score() >= 4 || player2.score() >= 4;
    }

    private String advantageScore() {
        int difference = player1.score() - player2.score();

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
        return  getScore(player1.score()) + "-" + getScore(player2.score());
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
