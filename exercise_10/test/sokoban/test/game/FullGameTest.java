package sokoban.test.game;

import org.junit.Before;
import org.junit.Test;
import sokoban.game.Game;
import sokoban.game.SokobanObjectProvider;
import sokoban.game.TestObjectProvider;
import sokoban.io.input.InputHandler;
import sokoban.io.input.ScriptedInputHandler;
import sokoban.io.output.NullRenderer;
import sokoban.test.TestHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class FullGameTest extends TestHelper {
    private Game game;

    private TestObjectProvider provider = new TestObjectProvider(new ScriptedInputHandler());

    @Before
    public void setUpProvider() {
        SokobanObjectProvider.setProvider(provider);
    }

    @Override
    protected Path levelPrefix() {
        return Paths.get("levels/");
    }

    @Override
    protected Game getGame() {
        return game;
    }

    @Test
    public void basic1() {
        InputHandler inputHandler = new ScriptedInputHandler(
                RIGHT, RIGHT, RIGHT, DOWN, DOWN,
                LEFT, UP, RIGHT, UP, UP, LEFT, LEFT,
                DOWN, RIGHT, RIGHT, UP, RIGHT, DOWN, DOWN
        );
        SokobanObjectProvider.setProvider(new TestObjectProvider(inputHandler));
        game = parseFromFile("basic1.sok", new NullRenderer(), inputHandler);
        game.run();
        assertTrue(game.isOver());
    }

    @Test
    public void basic2() {
        InputHandler inputHandler = new ScriptedInputHandler(
                LEFT, LEFT, LEFT, DOWN, DOWN,
                LEFT, DOWN, RIGHT, RIGHT, RIGHT,
                LEFT, LEFT, UP, UP, UP, UP,
                LEFT, LEFT, DOWN, RIGHT, UP, RIGHT,
                DOWN, DOWN, DOWN, LEFT, DOWN, RIGHT, RIGHT
        );
        SokobanObjectProvider.setProvider(new TestObjectProvider(inputHandler));
        game = parseFromFile("basic2.sok", new NullRenderer(), inputHandler);
        game.run();
        assertTrue(game.isOver());
    }

    @Test
    public void extended1() {
        InputHandler inputHandler = new ScriptedInputHandler(
                DOWN, DOWN,
                RIGHT, RIGHT, RIGHT, RIGHT, RIGHT, RIGHT,
                UP, UP,
                LEFT, LEFT, LEFT, LEFT,
                RIGHT, RIGHT, RIGHT, RIGHT,
                DOWN, DOWN,
                LEFT, LEFT, LEFT, LEFT, LEFT, LEFT,
                UP, UP, UP,
                RIGHT,
                DOWN, DOWN, DOWN, DOWN,
                LEFT, DOWN, RIGHT, UP, RIGHT, DOWN,

                RIGHT, RIGHT, RIGHT, RIGHT,
                UP, UP, UP, UP,
                LEFT,
                DOWN, DOWN, DOWN,
                RIGHT, DOWN, LEFT, LEFT, LEFT,
                UP, LEFT, DOWN, DOWN, DOWN,
                RIGHT, DOWN, LEFT,
                DOWN, LEFT, UP,
                RIGHT, UP, UP, UP, LEFT,
                DOWN, DOWN, DOWN,
                LEFT, DOWN, RIGHT, RIGHT, RIGHT, RIGHT
                );
        SokobanObjectProvider.setProvider(new TestObjectProvider(inputHandler));
        game = parseFromFile("extended1.sok", new NullRenderer(), inputHandler);
        game.run();
        assertTrue(game.isOver());
    }
}