Feature: Waste an Hour Having Fun
  As a frequent games player,
  I would like to play rock, paper, scissors
  so that I can spend an hour of my day having fun

  Scenario: Can I play Player vs Computer?
      Given rock, paper, scissors game app is running
      When I choose to play as a Player against the Computer
      And when I make the following moves:
          |  Rock         |
          |  Paper        |
          |  Scissors     |
          |  Rock         |
          |  Paper        |
          |  Scissors     |
          |  Rock         |
          |  Paper        |
          |  Scissors     |
      And when Computer makes the following moves against my moves:
          |  Rock         |
          |  Rock         |
          |  Rock         |
          |  Paper        |
          |  Paper        |
          |  Paper        |
          |  Scissors     |
          |  Scissors     |
          |  Scissors     |
      Then the outcome of Player vs Computer game is:
          |  Player played ROCK. Computer played ROCK. Player ties.                            |
          |  Player played PAPER. Computer played ROCK. Paper beats Rock. Player wins.         |
          |  Player played SCISSORS. Computer played ROCK. Rock beats Scissors. Player loses.  |
          |  Player played ROCK. Computer played PAPER. Paper beats Rock. Player loses.        |
          |  Player played PAPER. Computer played PAPER. Player ties.                          |
          |  Player played SCISSORS. Computer played PAPER. Scissors beat Paper. Player wins.  |
          |  Player played ROCK. Computer played SCISSORS. Rock beats Scissors. Player wins.   |
          |  Player played PAPER. Computer played SCISSORS. Scissors beat Paper. Player loses. |
          |  Player played SCISSORS. Computer played SCISSORS. Player ties.                    |

  Scenario: Can I play Computer vs Computer?
      Given rock, paper, scissors game app is running
      When I choose to play Computer against the Computer
      And when Computer-1 makes the following moves:
          |  Rock         |
          |  Paper        |
          |  Scissors     |
          |  Rock         |
          |  Paper        |
          |  Scissors     |
          |  Rock         |
          |  Paper        |
          |  Scissors     |
      And when Computer-2 makes the following moves against Computer-1 moves:
          |  Rock         |
          |  Rock         |
          |  Rock         |
          |  Paper        |
          |  Paper        |
          |  Paper        |
          |  Scissors     |
          |  Scissors     |
          |  Scissors     |
      Then the outcome of Computer-1 vs Computer-2 game is:
          |  Computer-1 played ROCK. Computer-2 played ROCK. Computer-1 ties.                            |
          |  Computer-1 played PAPER. Computer-2 played ROCK. Paper beats Rock. Computer-1 wins.         |
          |  Computer-1 played SCISSORS. Computer-2 played ROCK. Rock beats Scissors. Computer-1 loses.  |
          |  Computer-1 played ROCK. Computer-2 played PAPER. Paper beats Rock. Computer-1 loses.        |
          |  Computer-1 played PAPER. Computer-2 played PAPER. Computer-1 ties.                          |
          |  Computer-1 played SCISSORS. Computer-2 played PAPER. Scissors beat Paper. Computer-1 wins.  |
          |  Computer-1 played ROCK. Computer-2 played SCISSORS. Rock beats Scissors. Computer-1 wins.   |
          |  Computer-1 played PAPER. Computer-2 played SCISSORS. Scissors beat Paper. Computer-1 loses. |
          |  Computer-1 played SCISSORS. Computer-2 played SCISSORS. Computer-1 ties.                    |

  Scenario: Invalid game mode
         Given rock, paper, scissors game app is running
         When I choose option "3" as game mode
         Then I see the error message "Invalid game mode option 3" for selected game mode

  Scenario: Invalid player move
           Given rock, paper, scissors game app is running
           When I choose to play as a Player against the Computer
           And I choose option "4" as a move
           Then I see the error message "Invalid move option 4" for selected move