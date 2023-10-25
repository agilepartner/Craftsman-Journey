
public class TennisGame1 implements TennisGame {

    public static final String DEUCE = "Deuce";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String ALL = "All";
    public static final String FORMAT = "%s-%s";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";

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
        return getScore(player1.score(), true);
    }

    private boolean advantage() {
        return player1.score() >= 4 || player2.score() >= 4;
    }

    private String advantageScore() {
        int difference = player1.score() - player2.score();

        if (difference == 1)
            return ADVANTAGE_PLAYER_1;
        if (difference == -1)
            return ADVANTAGE_PLAYER_2;
        if (difference >= 2)
            return WIN_FOR_PLAYER_1;

        return WIN_FOR_PLAYER_2;
    }

    private String defaultScore() {
        return  formatScore(getScore(player1.score()), getScore(player2.score()));
    }

    private String getScore(int score) {
        return  getScore(score, false);
    }

    private String getScore(int score, boolean isEqual) {
        String allOrNothing = isEqual ? ALL : null;
        return switch (score) {
            case 0 -> formatScore(LOVE, allOrNothing);
            case 1 -> formatScore(FIFTEEN, allOrNothing);
            case 2 -> formatScore(THIRTY, allOrNothing);
            case 3 -> (isEqual) ? DEUCE : FORTY;
            default -> DEUCE;
        };
    }
    private String formatScore(String score1, String score2){
        if (score2 != null && !score2.isEmpty())
            return  String.format(FORMAT, score1, score2);

        return score1;
    }
}
