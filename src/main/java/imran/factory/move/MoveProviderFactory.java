package imran.factory.move;

import imran.context.ApplicationContext;
import imran.model.player.PlayerType;

import java.util.Map;

public class MoveProviderFactory {

    private Map<PlayerType, MoveProvider> moveProviderMap;

    public MoveProvider getMoveProvider(PlayerType playerType) {
        return moveProviderMap.get(playerType);
    }

    @SuppressWarnings("unchecked")
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.moveProviderMap = (Map<PlayerType, MoveProvider>) applicationContext.getBean(Map.class);
    }
}
