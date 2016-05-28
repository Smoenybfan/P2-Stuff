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
import static org.junit.Assert.assertTrue;

public class TestPlayerInteractions extends TestHelper {
    private Renderer renderer = new NullRenderer();
    private Game game;

    private void initGame(String filename) {
        InputHandler inputHandler = new ScriptedInputHandler(DOWN);
        game = parseFromFile(filename, renderer, inputHandler);
    }

    @Test
    public void moveIntoWall() {
        initGame("collision_player_wall.sok");
        game.run();
        assertPlayerAt(1);
        assertFalse(game.isOver());
    }

    @Test
    public void moveIntoBreakableWall() {
        initGame("collision_player_breakable_wall.sok");
        game.run();
        assertPlayerAt(1);
        assertFalse(game.isOver());
    }

    @Test
    public void moveToFloorTile() {
        initGame("collision_player_floor.sok");
        assertPlayerAt(1);
        game.run();
        assertPlayerAt(2);
        assertFalse(game.isOver());
    }

    @Test
    public void moveToGoalTile() {
        initGame("collision_player_goal.sok");
        assertPlayerAt(1);
        game.run();
        assertPlayerAt(2);
        assertFalse(game.isOver());
    }

    @Test
    public void moveIntoBox() {
        initGame("collision_player_box.sok");
        assertPlayerAt(1);
        assertBoxAt(2);
        game.run();
        assertPlayerAt(2);
        assertBoxAt(3);
        assertTrue(game.isOver());
    }


    @Test
    public void moveIntoExplosive() {
    }

    @Override
    protected Path levelPrefix() {
        return Paths.get("test/levels/collisions/player/");
    }

    @Override
    protected Game getGame() {
        return game;
    }
}
