package sokoban.Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by smoen on 17.05.2016.
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
        SokobanParserTest.class,
        SolvePuzzleTest.class,
        TileTest.class,
        WallBreakerTest.class
})
public class MainTestSuite {
}
