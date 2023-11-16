package bowling;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BowlingStepDefinitions {
    private Game game;

    @Given("^a new bowling game$")
    public void givenANewBowlingGame() {
        game = new Game();
    }

    @When("^all of my balls land in the gutter$")
    public void all_of_my_balls_land_in_the_gutter() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
    }

    @When("^all of my balls are srikes$")
    public void all_of_my_balls_are_strikes() {
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
    }

    @When("^I roll the following series:(.*)$")
    public void I_roll_the_following_series(String series) {
        Arrays.asList(series.trim().split(","))
            .forEach(e -> game.roll(Integer.valueOf(e)));
    }

    @Then("^my total score should be (\\d+)$")
    public void my_total_score_should_be(int score) {
        Assertions.assertEquals(score, game.score());
    }

}
