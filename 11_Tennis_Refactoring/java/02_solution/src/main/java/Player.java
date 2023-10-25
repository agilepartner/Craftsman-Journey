public class Player {
    private final String name;
    private int score;

    public Player(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("player name cannot be null or empty");
        this.name = name;
    }

    public String name() {
        return name;
    }

    public int score() {
        return  score;
    }

    public void scorePointIfPlayer(String playerName) {
        if (is(playerName))
            score++;
    }

    private boolean is(String playerName) {
        return  name.equals((playerName));
    }



}
