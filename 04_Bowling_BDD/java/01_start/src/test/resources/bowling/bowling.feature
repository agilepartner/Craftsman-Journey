Feature: Score Calculation
  In order to know who wins the game
  As a bowling player
  I want to know my score

Scenario: Gutter game
  Given a new bowling game
  When all of my balls land in the gutter
  Then my total score should be 0