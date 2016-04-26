package sokoban.Tests;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import sokoban.Game.Game;
import sokoban.Game.Parser;
import sokoban.GameObjects.Box;
import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JExample.class)
public class BoxMovementTest {
    private Game game;
    private Parser parser;
    private Tile[][] expectedBoard;

    @Test
    public void setUp() throws Exception{
        game = new Game("levels/basic2.sok");
        parser = new Parser();
        expectedBoard = parser.parse("levels/basic2.sok");
    }

    @Given("setUp")
    public void movePlayerIntoBox()throws Exception{
        game.run("left,left,left");
        Player player = (Player) expectedBoard[2][6];
        Box box = (Box) expectedBoard[2][3];
        Tile PlayerFloor = player.getFloor();
        Tile BoxFloor = box.getFloor();
        player.setFloor(BoxFloor);
        box.setFloor(expectedBoard[2][2]);
        box.position[1] = 2;
        expectedBoard[2][2] = box;
        player.position[1] = 3;
        expectedBoard[2][3] = player;
        expectedBoard[2][6] = PlayerFloor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Given("movePlayerIntoBox")
    public void moveBoxIntoWall()throws Exception{
        game.run("left,left,left,left");
        Player player = (Player) expectedBoard[2][3];
        Box box = (Box) expectedBoard[2][2];
        Tile PlayerFloor = player.getFloor();
        Tile BoxFloor = box.getFloor();
        player.setFloor(BoxFloor);
        box.setFloor(expectedBoard[2][1]);
        box.position[1] = 1;
        expectedBoard[2][1] = box;
        player.position[1] = 2;
        expectedBoard[2][2] = player;
        expectedBoard[2][3] = PlayerFloor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }
}
