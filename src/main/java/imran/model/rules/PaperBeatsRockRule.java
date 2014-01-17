package imran.model.rules;

import imran.model.player.Player;
import imran.representation.result.Result;
import imran.representation.result.RockPaperScissorsResult;

import static imran.representation.move.Move.*;
import static imran.representation.result.Outcome.*;
import static imran.representation.result.Reason.*;

public class PaperBeatsRockRule implements Rule {

    public Result apply(Player firstPlayer, Player secondPlayer) {
        if (PAPER == firstPlayer.getMove()  && ROCK == secondPlayer.getMove()) {
            return new RockPaperScissorsResult(firstPlayer, secondPlayer, PAPER_BEATS_ROCK, WIN);
        }
        else if (PAPER == secondPlayer.getMove() && ROCK == firstPlayer.getMove()) {
            return new RockPaperScissorsResult(firstPlayer, secondPlayer, PAPER_BEATS_ROCK, LOSE);
        }
        else if (firstPlayer.getMove() == secondPlayer.getMove()) {
            return new RockPaperScissorsResult(firstPlayer, secondPlayer, TIED, TIE);
        }

        return null;
    }
}
