Feature: Score Calculation
  In order to know who wins the game
  As a bowling player
  I want to know my score

Scenario: Gutter game
  Given a new bowling game
  When all of my balls land in the gutter
  Then my total score should be 0

Scenario: Perfect game
  Given a new bowling game
  When all of my balls are srikes
  Then my total score should be 300

Scenario: All nines
  Given a new bowling game
  When I roll the following series: 9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0 
  Then my total score should be 90

Scenario: All spares
  Given a new bowling game
  When I roll the following series: 5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5 
  Then my total score should be 150

Scenario: Normal game
  Given a new bowling game
  When I roll the following series: 10,7,3,9,0,10,0,8,8,2,0,6,10,10,10,8,1 
  Then my total score should be 167

Scenario: A game not yet finished with strike last and no bonus yet
  Given a new bowling game
  When I roll the following series: 7,2,9,0,10
  Then my total score should be 28

Scenario: A game not yet finished with strike plus bonus last
  Given a new bowling game
  When I roll the following series: 7,2,9,0,10,5,2
  Then my total score should be 42
