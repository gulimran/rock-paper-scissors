package imran.model.rules;

import imran.context.ApplicationContext;
import imran.model.player.Player;
import imran.representation.result.Result;

import java.util.List;

public class RockPaperScissorsRules implements Rules {

    private List<Rule> ruleList;

    @Override
    public Result getResult(Player firstPlayer, Player secondPlayer) {
        Result result = null;

        for (Rule rule : ruleList) {
            result = rule.apply(firstPlayer, secondPlayer);
            if (result != null) {
                break;
            }
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.ruleList = (List<Rule>) applicationContext.getBean(List.class);
    }
}
