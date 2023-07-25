
public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score2 += 1;
    }

    public String getScore() {

        if (scoresAreEqual())
            return equalityLabel();

        if (anyScoreIsInAdvantageRange())
            return advantageRangeLabel();

        return smallScoreLabel(player1Score) + "-" + smallScoreLabel(player2Score2);
    }

    private boolean scoresAreEqual() {
        return player1Score == player2Score2;
    }

    private boolean anyScoreIsInAdvantageRange() {
        return player1Score >= 4 || player2Score2 >= 4;
    }

    private boolean anyScoreIsInDeuceRange() {
        return player1Score >= 3 || player2Score2 >= 3;
    }

    private String equalityLabel() {
        if(anyScoreIsInDeuceRange()) return "Deuce";
        return smallScoreLabel(player1Score) + "-All";
    }

    private String advantageLabel(String name) {
        return "Advantage " + name;
    }

    private String winLabel(String name) {
        return "Win for " + name;
    }

    private String smallScoreLabel(int score) {
        return switch(score)
        {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalArgumentException("Score " + score + " is not small");
        };
    }

    private String advantageRangeLabel() {
        int scoreDiff = player1Score - player2Score2;
        if (scoreDiff == 1) return advantageLabel(player1Name);
        else if (scoreDiff == -1) return advantageLabel(player2Name);
        else if (scoreDiff >= 2) return winLabel(player1Name);
        return winLabel(player2Name);
    }
}
