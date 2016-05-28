package sokoban.test.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sokoban.test.game.FullGameTest;
import sokoban.test.game.TestSimpleGames;
import sokoban.test.interactions.TestBoxInteractions;
import sokoban.test.interactions.TestExplosiveInteractions;
import sokoban.test.interactions.TestPlayerInteractions;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestPlayerInteractions.class,
        TestBoxInteractions.class,
        TestExplosiveInteractions.class,
        FullGameTest.class,
        TestSimpleGames.class,
})

public class IntegrationTestsSuite {
}
