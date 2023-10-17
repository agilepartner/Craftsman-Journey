package bowling;

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
        // TODO: implement this
    }

    @Then("^my total score should be (\\d+)$")
    public void my_total_score_should_be(int score) {
        Assertions.assertEquals(score, game.score());
    }

}
