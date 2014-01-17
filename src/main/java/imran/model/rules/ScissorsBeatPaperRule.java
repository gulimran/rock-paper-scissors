package imran.model.rules;

import imran.model.player.Player;
import imran.representation.result.Result;
import imran.representation.result.RockPaperScissorsResult;

import static imran.representation.move.Move.*;
import static imran.representation.result.Outcome.*;
import static imran.representation.result.Reason.*;

public class ScissorsBeatPaperRule implements Rule {

    public Result apply(Player firstPlayer, Player secondPlayer) {
        if (SCISSORS == firstPlayer.getMove()  && PAPER == secondPlayer.getMove()) {
            return new RockPaperScissorsResult(firstPlayer, secondPlayer, SCISSORS_BEAT_PAPER, WIN);
        }
        else if (SCISSORS == secondPlayer.getMove() && PAPER == firstPlayer.getMove()) {
            return new RockPaperScissorsResult(firstPlayer, secondPlayer, SCISSORS_BEAT_PAPER, LOSE);
        }
        else if (firstPlayer.getMove() == secondPlayer.getMove()) {
            return new RockPaperScissorsResult(firstPlayer, secondPlayer, TIED, TIE);
        }

        return null;
    }
}
