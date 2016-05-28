package sokoban.test.interactions;

import org.junit.Test;
import sokoban.game.Game;
import sokoban.game.SokobanObjectProvider;
import sokoban.game.TestObjectProvider;
import sokoban.io.input.InputHandler;
import sokoban.io.input.ScriptedInputHandler;
import sokoban.io.output.NullRenderer;
import sokoban.io.output.Renderer;
import sokoban.test.TestHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestBoxInteractions extends TestHelper {
    private Game game;
    private Renderer renderer = new NullRenderer();

    private void initGame(String filename) {
        InputHandler inputHandler = new ScriptedInputHandler(DOWN);
        SokobanObjectProvider.setProvider(new TestObjectProvider(inputHandler));
        game = parseFromFile(filename, renderer, inputHandler);
    }


    @Test
    public void pushTwoBoxesIntoEachOther() {
        initGame("collision_box_box.sok");
        game.run();
        assertPlayerAt(1);
        assertBoxAt(2);
        assertBoxAt(3);
        assertFalse(game.isOver());
    }

    @Test
    public void pushBoxIntoWall() {
        initGame("collision_box_wall.sok");
        game.run();
        assertPlayerAt(1);
        assertBoxAt(2);
        assertFalse(game.isOver());
    }

    @Test
    public void pushBoxToFloorTile() {
        initGame("collision_box_floor_tile.sok");
        game.run();
        assertNoEntityAt(1);
        assertPlayerAt(2);
        assertBoxAt(3);
        assertFalse(game.isOver());
    }

    @Test
    public void pushBoxToGoalTile() {
        initGame("collision_box_goal_tile.sok");
        game.run();
        assertNoEntityAt(1);
        assertPlayerAt(2);
        assertBoxAt(3);
        assertTrue(game.isOver());
    }

    @Test
    public void pushBoxIntoExplosive() {
        initGame("collision_box_explosive.sok");
        game.run();
        assertPlayerAt(1);
        assertBoxAt(2);
        assertExplosiveAt(3);
        assertFalse(game.isOver());
    }

    @Test
    public void pushBoxIntoBreakableWall() {
        initGame("collision_box_breakable_wall.sok");
        game.run();
        assertPlayerAt(1);
        assertBoxAt(2);
        assertBreakableAt(3);
        assertFalse(game.isOver());
    }


    @Override
    protected Path levelPrefix() {
        return Paths.get("test/levels/collisions/box/");
    }

    @Override
    protected Game getGame() {
        return game;
    }
}
