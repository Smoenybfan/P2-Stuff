package sokoban.Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A Suite that runs all tests.
 * The InteractiveGameTest is not used because there is nothing that this class tests.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        BombTest.class,
        BoxMovementTest.class,
        BoxTest.class,
        GameTest.class,
        //InteractiveGameTest.class,
        PlayerMovementTest.class,
        PlayerTest.class,
        RendererTest.class,
        ParserTest.class,
        SolvePuzzleTest.class,
        TileTest.class,
        WallBreakerTest.class
})
public class MainTestSuite {
}
