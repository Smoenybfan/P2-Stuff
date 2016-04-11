package snakes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by Simon on 11.04.2016.
 */
@RunWith(Suite.class)
@SuiteClasses({
        DieTest.class,
        FirstSquareTest.class,
        LadderTest.class,
        //PlayerTest.class,
        SnakeTest.class,
        SquareTest.class,
        SwapSquareTest.class,
        TikTokSquareTest.class,
        WormholeTest.class
})
public class MainTestSuite {
}
