package imran.service;

import imran.context.ApplicationContext;
import imran.model.player.Player;
import imran.representation.result.Result;
import imran.model.rules.Rules;

public class RockPaperScissorsGame implements Game {

    private Rules rockPaperScissorsRules;

    @Override
    public Result play(Player firstPlayer, Player secondPlayer) {
        return rockPaperScissorsRules.getResult(firstPlayer, secondPlayer);
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.rockPaperScissorsRules = (Rules) applicationContext.getBean(Rules.class);
    }
}
