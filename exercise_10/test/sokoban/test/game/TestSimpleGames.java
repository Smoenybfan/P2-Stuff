package sokoban.test.game;

import org.junit.Test;
import sokoban.game.Game;
import sokoban.io.input.InputHandler;
import sokoban.io.input.ScriptedInputHandler;
import sokoban.io.output.NullRenderer;
import sokoban.io.output.Renderer;
import sokoban.test.TestHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class TestSimpleGames extends TestHelper {
    private Renderer renderer = new NullRenderer();
    private Game game;

    private void initGame(String filename) {
        InputHandler inputHandler = new ScriptedInputHandler(DOWN);
        game = parseFromFile(filename, renderer, inputHandler);
    }

    @Test
    public void moveIntoWall() {
        initGame("more_goals_than_boxes.sok");
        game.run();
        assertPlayerAt(2);
        assertTrue(game.isOver());
    }

    @Override
    protected Path levelPrefix() {
        return Paths.get("test/levels/simple_games/");
    }

    @Override
    protected Game getGame() {
        return game;
    }
}
