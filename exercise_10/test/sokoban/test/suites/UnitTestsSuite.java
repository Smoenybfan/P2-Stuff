package sokoban.test.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sokoban.test.entity.*;
import sokoban.test.game.TestPoint;
import sokoban.test.io.output.TestPlaintextRenderer;
import sokoban.test.parser.TestPlaintextParser;
import sokoban.test.tile.TestFloorTile;
import sokoban.test.tile.TestGoalTile;
import sokoban.test.tile.TestWallTile;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestBoxEntity.class,
        TestBreakableWallEntity.class,
        TestEntity.class,
        TestExplosiveEntity.class,
        TestPlayerEntity.class,
        TestPoint.class,
        TestPlaintextParser.class,
        TestFloorTile.class,
        TestGoalTile.class,
        TestWallTile.class,
        TestPlaintextRenderer.class
})

public class UnitTestsSuite {
}
