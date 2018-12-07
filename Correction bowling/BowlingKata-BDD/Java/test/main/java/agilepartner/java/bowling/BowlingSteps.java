package agilepartner.java.bowling;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Arrays;

public class BowlingSteps {

    private Game game;

    @Given("^a new bowling game$")
    public void givenANewBowlingGame() {
        game = new Game();
    }

    @When("^all of my balls are landing in the gutter$")
    public void whenAllOfMyBallsAreLandingInTheGutter() {
        for (int i = 0; i < 20; i++) {
            game.addRoll(0);
        }
    }

    @When("^all of my balls are strike$")
    public void all_of_my_balls_are_strike() throws Throwable {
        for (int i = 0; i < 21; i++) {
            game.addRoll(10);
        }
    }

    @Then("^my total score should be (\\d+)$")
    public void thenMyTotalScoreShouldBe(int score) {
        Assert.assertEquals(score, game.calculateScore());
    }

    @When("^I roll the following series:(.*)$")
    public void whenIRollTheFollowingSeries(String series) {
        Arrays.asList(series.trim().split(",")).forEach(e -> game.addRoll(Integer.valueOf(e)));
    }
}
