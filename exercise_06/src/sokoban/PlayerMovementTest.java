package sokoban;


import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JExample.class)
public class PlayerMovementTest {
    private Game game;
    private Parser parser;
    private Tile[][] expectedBoard;

    @Test
    public void setUp() throws Exception{
        game = new Game("levels/basic1.sok");
        parser = new Parser();
        expectedBoard = parser.parse("levels/basic1.sok");
    }

    @Given("setUp")
    public void movePlayerUp()throws Exception {
        game.run("up");
        Player player = (Player) expectedBoard[2][1];
        Tile floor = player.getFloor();
        player.setFloor(expectedBoard[1][1]);
        player.position[0] = 1;
        expectedBoard[1][1] = player;
        expectedBoard[2][1] = floor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Given("movePlayerUp")
    public void movePlayerRight() throws Exception{
        game.run("right");
        Player player = (Player) expectedBoard[1][1];
        Tile floor = player.getFloor();
        player.setFloor(expectedBoard[1][2]);
        player.position[1] = 2;
        expectedBoard[1][2] = player;
        expectedBoard[1][1] = floor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Given("movePlayerRight")
    public void movePlayerDown() throws Exception{
        game.run("down");
        Player player = (Player) expectedBoard[1][2];
        Tile floor = player.getFloor();
        player.setFloor(expectedBoard[2][2]);
        player.position[0] = 2;
        expectedBoard[2][2] = player;
        expectedBoard[1][2] = floor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Given("movePlayerDown")
    public void movePlayerLeft() throws Exception{
        game.run("left");
        Player player = (Player) expectedBoard[2][2];
        Tile floor = player.getFloor();
        player.setFloor(expectedBoard[2][1]);
        player.position[1] = 1;
        expectedBoard[2][1] = player;
        expectedBoard[2][2] = floor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Given("movePlayerLeft")
    public void movePlayerIntoWall() throws Exception{
        game.run("left");
        assertArrayEquals(expectedBoard, game.getBoard());
    }
}
