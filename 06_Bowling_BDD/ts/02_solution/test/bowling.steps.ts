import { DefineStepFunction, defineFeature, loadFeature } from "jest-cucumber";
import { Game } from "../src/bowling";

const feature = loadFeature("features/bowling.feature");

defineFeature(feature, (test) => {
  let game: Game;

  const givenANewGame = (given: DefineStepFunction) => {
    given("a new bowling game", () => {
      game = new Game();
    });
  };

  const thenMyScoreShouldBe = (then: DefineStepFunction) => {
    then(/^my total score should be (\d+)$/, (score) => {
      expect(game.score()).toBe(parseInt(score));
    });
  };

  const whenIRollTheFollowingSeries = (when: DefineStepFunction) => {
    when(/^I roll the following series: (.*)$/, (param) => {
      const pins = (param as string).trim().split(",");
      pins.map((p) => game.roll(parseInt(p)));
    });
  };

  test("Gutter game", ({ given, when, then }) => {
    givenANewGame(given);

    when("all of my balls land in the gutter", () => {
      for (let i = 0; i < 20; i++) {
        game.roll(0);
      }
    });

    thenMyScoreShouldBe(then);
  });

  test("Perfect game", ({ given, when, then }) => {
    givenANewGame(given);

    when("all of my balls are srikes", () => {
      for (let i = 0; i < 12; i++) {
        game.roll(10);
      }
    });

    thenMyScoreShouldBe(then);
  });

  test("All nines", ({ given, when, then }) => {
    givenANewGame(given);
    whenIRollTheFollowingSeries(when);
    thenMyScoreShouldBe(then);
  });

  test("All spares", ({ given, when, then }) => {
    givenANewGame(given);
    whenIRollTheFollowingSeries(when);
    thenMyScoreShouldBe(then);
  });

  test("Normal game", ({ given, when, then }) => {
    givenANewGame(given);
    whenIRollTheFollowingSeries(when);
    thenMyScoreShouldBe(then);
  });
});
