package sokoban.Tests;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import sokoban.Exceptions.RenderException;
import sokoban.Game.Game;
import sokoban.Game.SokobanParser;
import sokoban.GameObjects.Box;
import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JExample.class)
public class BoxMovementTest {
    private Game game;
    private SokobanParser sokobanParser;
    private Tile[][] expectedBoard;

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Test
    public void setUp() throws Exception{
        game = new Game("levels/basic2.sok");
        sokobanParser = new SokobanParser();
        expectedBoard = sokobanParser.parse("levels/basic2.sok");
    }

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Given("setUp")
    public void movePlayerIntoBox()throws RenderException{
        game.run("left,left,left", new Renderer());
        Player player = (Player) expectedBoard[2][6];
        Box box = (Box) expectedBoard[2][3];
        Tile PlayerFloor = player.getFloor();
        Tile BoxFloor = box.getFloor();
        player.setFloor(BoxFloor);
        box.setFloor(expectedBoard[2][2]);
        box.setX(2);
        expectedBoard[2][2] = box;
        player.setX(3);
        expectedBoard[2][3] = player;
        expectedBoard[2][6] = PlayerFloor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Given("movePlayerIntoBox")
    public void moveBoxIntoWall()throws RenderException{
        game.run("left,left,left,left", new Renderer());
        Player player = (Player) expectedBoard[2][3];
        Box box = (Box) expectedBoard[2][2];
        Tile PlayerFloor = player.getFloor();
        Tile BoxFloor = box.getFloor();
        player.setFloor(BoxFloor);
        box.setFloor(expectedBoard[2][1]);
        box.setX(1);
        expectedBoard[2][1] = box;
        player.setX(2);
        expectedBoard[2][2] = player;
        expectedBoard[2][3] = PlayerFloor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }
}
