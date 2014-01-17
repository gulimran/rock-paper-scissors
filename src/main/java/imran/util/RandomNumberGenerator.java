package imran.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random RANDOM = new Random();
    private static final int DEFAULT_BOUND = 3;

    public int getMoveChosen() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }


}
