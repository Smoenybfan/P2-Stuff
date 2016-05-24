package sokoban.test.interactions;

import org.junit.Test;
import sokoban.game.Game;
import sokoban.io.input.InputHandler;
import sokoban.io.input.ScriptedInputHandler;
import sokoban.io.output.NullRenderer;
import sokoban.io.output.Renderer;
import sokoban.test.TestHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;

public class TestExplosiveInteractions extends TestHelper {
    private Renderer renderer = new NullRenderer();
    private Game game;

    private void initGame(String filename) {
        InputHandler inputHandler = new ScriptedInputHandler(DOWN);
        game = parseFromFile(filename, renderer, inputHandler);
    }

    @Test
    public void pushExplosiveIntoBox() {
        initGame("collision_explosive_box.sok");
        game.run();
        assertPlayerAt(1);
        assertExplosiveAt(2);
        assertBoxAt(3);
        assertFalse(game.isOver());
    }

    @Test
    public void pushExplosiveToEmptyTile() {
        initGame("collision_explosive_floor_tile.sok");
        game.run();
        assertPlayerAt(2);
        assertExplosiveAt(3);
    }

    @Test
    public void pushExplosiveToGoalTile() {
        initGame("collision_explosive_goal_tile.sok");
        game.run();
        assertPlayerAt(2);
        assertExplosiveAt(3);
        assertFalse(game.isOver());
    }

    @Test
    public void pushExplosiveIntoExplosive() {
        initGame("collision_explosive_explosive.sok");
        game.run();
        assertPlayerAt(1);
        assertExplosiveAt(2);
        assertExplosiveAt(3);
        assertFalse(game.isOver());
    }

    @Test
    public void pushExplosiveIntoBreakableWall() {
        initGame("collision_explosive_breakable_wall.sok");
        assertPlayerAt(1);
        assertExplosiveAt(2);
        assertBreakableAt(3);
        game.run();
        assertPlayerAt(2);
        assertNoEntityAt(3);
        assertFalse(game.isOver());
    }

    @Override
    protected Path levelPrefix() {
        return Paths.get("test/levels/collisions/explosive/");
    }

    @Override
    protected Game getGame() {
        return game;
    }
}
