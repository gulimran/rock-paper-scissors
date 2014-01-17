package imran.factory.move;

import imran.context.ApplicationContext;
import imran.model.player.PlayerType;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MoveProviderFactoryTest {

    private MoveProviderFactory moveProviderFactory;
    ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = ApplicationContext.getInstance();
        getMoveProviderMap();
        moveProviderFactory = new MoveProviderFactory();
        moveProviderFactory.setApplicationContext(applicationContext);
    }

    @Test
    public void shouldReturnConsoleMoveProvider_forInteractivePlayer() {
        // given
        PlayerType playerType = PlayerType.PERSON;

        // when
        MoveProvider moveProvider = moveProviderFactory.getMoveProvider(playerType);

        // then
        assertTrue(moveProvider instanceof InteractiveMoveProvider);
    }

    @Test
    public void shouldReturnRandomizedMoveProvider_forComputerPlayer() {
        // given
        PlayerType playerType = PlayerType.COMPUTER;

        // when
        MoveProvider moveProvider = moveProviderFactory.getMoveProvider(playerType);

        // then
        assertTrue(moveProvider instanceof RandomizedMoveProvider);
    }

    public static Map<PlayerType, MoveProvider> getMoveProviderMap() {
//        ApplicationContext applicationContext = ApplicationContext.getInstance();
//        return applicationContext.getMoveProviderMap();
        return ApplicationContext.getMoveProviderMap();
    }

    @SuppressWarnings("unchecked")
    public static MoveProviderFactory build(MoveProvider moveProvider) {
        ApplicationContext applicationContext1 = ApplicationContext.getInstance();
        Map<PlayerType, MoveProvider> moveProviderMap = (Map<PlayerType, MoveProvider>) applicationContext1.getBean(Map.class);
        moveProviderMap.put(PlayerType.PERSON, moveProvider);
        moveProviderMap.put(PlayerType.COMPUTER, moveProvider);

        MoveProviderFactory moveProviderFactory = new MoveProviderFactory();
        moveProviderFactory.setApplicationContext(applicationContext1);
        return moveProviderFactory;
    }
}
