public class TennisGame7 implements TennisGame {

    private final Score score1;
    private final Score score2;

    public TennisGame7(String player1Name, String player2Name) {
        this.score1 = new Score(player1Name);
        this.score2 = new Score(player2Name);
    }

    @Override
    public void wonPoint(String playerName) {
        getScore(playerName).increment();
    }

    @Override
    public String getScore() {
        if(score1.isSameScoreAs(score2)) return score1.equalityLabel();
        if(score1.hasWon(score2)) return score1.winLabel();
        if(score2.hasWon(score1)) return score2.winLabel();
        if(score1.hasAdvantage(score2)) return score1.advantageLabel();
        if(score2.hasAdvantage(score1)) return score2.advantageLabel();

        return score1.label() + "-" + score2.label();
    }

    private Score getScore(String playerName) {
        if(score1.getPlayerName().equals(playerName)) return score1;
        return score2;
    }
}
