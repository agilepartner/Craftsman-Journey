import java.util.Objects;

public class Score {
    private int score = 0;

    private final String playerName;

    public Score(String playerName) {
        this.playerName = playerName;
    }

    public void increment() {
        score ++;
    }

    public boolean isInDeuceRange() {
        return score >= 3;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String label() {
        return switch(score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalArgumentException("Cannot convert " + score + "to label");
        };
    }

    public boolean isSameScoreAs(Score other) {
        return score == other.score;
    }

    public boolean hasAdvantage(Score other) {
        if(!isInDeuceRange()) return false;
        if(!other.isInDeuceRange()) return false;
        return score == other.score + 1;
    }

    public boolean hasWon(Score other) {
        if(score < 4) return false;
        return score >= other.score + 2;
    }

    public String advantageLabel() {
        return "Advantage " + getPlayerName();
    }

    public String winLabel() {
        return "Win for " + getPlayerName();
    }

    public String equalityLabel() {
        if(isInDeuceRange()) return "Deuce";
        return label() + "-All";
    }
}
