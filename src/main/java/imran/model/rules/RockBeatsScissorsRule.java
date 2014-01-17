package imran.model.rules;

import imran.model.player.Player;
import imran.representation.result.Result;
import imran.representation.result.RockPaperScissorsResult;

import static imran.representation.result.Outcome.LOSE;
import static imran.representation.result.Outcome.TIE;
import static imran.representation.result.Outcome.WIN;
import static imran.representation.result.Reason.TIED;

import static imran.representation.move.Move.*;
import static imran.representation.result.Reason.ROCK_BEATS_SCISSORS;

public class RockBeatsScissorsRule implements Rule {

    public Result apply(Player firstPlayer, Player secondPlayer) {
        if (ROCK == firstPlayer.getMove()  && SCISSORS == secondPlayer.getMove()) {
            return new RockPaperScissorsResult(firstPlayer, secondPlayer, ROCK_BEATS_SCISSORS, WIN);
        }
        else if (ROCK == secondPlayer.getMove() && SCISSORS == firstPlayer.getMove()) {
            return new RockPaperScissorsResult(firstPlayer, secondPlayer, ROCK_BEATS_SCISSORS, LOSE);
        }
        else if (firstPlayer.getMove() == secondPlayer.getMove()) {
            return new RockPaperScissorsResult(firstPlayer, secondPlayer, TIED, TIE);
        }

        return null;
    }
}
