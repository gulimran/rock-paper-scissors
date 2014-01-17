package imran.context;

import imran.factory.mode.GameModeProvider;
import imran.factory.move.InteractiveMoveProvider;
import imran.factory.move.MoveProvider;
import imran.factory.move.MoveProviderFactory;
import imran.factory.move.RandomizedMoveProvider;
import imran.model.rules.*;
import imran.validator.GameModeValidator;
import imran.model.player.PlayerType;
import imran.service.Game;
import imran.service.RockPaperScissorsGame;
import imran.view.InteractiveConsole;
import imran.util.RandomNumberGenerator;
import imran.validator.MoveValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to inject dependency in absence of any third-party
 * inversion of control libraries such as Spring or Guice.
 *
 * Note: This class is not unit tested.
 */
public class ApplicationContext {

    public Object getBean(Class clazz) {
        return beans.get(clazz);
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    private static ApplicationContext instance;
    private static Map<Class, Object> beans;

    static {
        beans = new HashMap<Class, Object>();
        initialize();
    }

    private static void initialize() {
        beans.put(MoveValidator.class, new MoveValidator());
        beans.put(InteractiveConsole.class, new InteractiveConsole());
        beans.put(InteractiveMoveProvider.class, new InteractiveMoveProvider());
        beans.put(RandomNumberGenerator.class, new RandomNumberGenerator());
        beans.put(RandomizedMoveProvider.class, new RandomizedMoveProvider());
        beans.put(GameModeValidator.class, new GameModeValidator());
        beans.put(GameModeProvider.class, new GameModeProvider());
        beans.put(Map.class, getMoveProviderMap());
        beans.put(MoveProviderFactory.class, new MoveProviderFactory());
        beans.put(List.class, getStrategies());
        beans.put(Rules.class,new RockPaperScissorsRules());
        beans.put(Game.class, new RockPaperScissorsGame());
    }

    public void setInteractiveConsole(InteractiveConsole interactiveConsole) {
        beans.put(InteractiveConsole.class, interactiveConsole);
    }

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        beans.put(RandomNumberGenerator.class, randomNumberGenerator);
    }

    public static Map<PlayerType, MoveProvider> getMoveProviderMap() {
        Map<PlayerType, MoveProvider> moveProviderMap = new HashMap<PlayerType, MoveProvider>();
        moveProviderMap.put(PlayerType.PERSON, (InteractiveMoveProvider) beans.get(InteractiveMoveProvider.class));
        moveProviderMap.put(PlayerType.COMPUTER, (RandomizedMoveProvider) beans.get(RandomizedMoveProvider.class));
        return moveProviderMap;
    }

    public static List<Rule> getStrategies() {
        List<Rule> strategies = new ArrayList<Rule>();
        strategies.add(new RockBeatsScissorsRule());
        strategies.add(new ScissorsBeatPaperRule());
        strategies.add(new PaperBeatsRockRule());
        return strategies;
    }
}
