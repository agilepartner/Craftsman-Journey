Feature: Score Calculation
  In order to know my performance
  As a player
  I want the system to calculate my total score

Scenario: Gutter game
  Given a new bowling game
  When all of my balls are landing in the gutter
  Then my total score should be 0

