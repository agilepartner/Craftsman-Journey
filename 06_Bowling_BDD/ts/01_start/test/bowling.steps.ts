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

  test("Gutter game", ({ given, when, then }) => {
    givenANewGame(given);

    when("all of my balls land in the gutter", () => {
      // TODO: implement this
    });

    then(/^my total score should be (\d+)$/, (score: number) => {
      expect(game.score()).toBe(score);
    });
  });
});
