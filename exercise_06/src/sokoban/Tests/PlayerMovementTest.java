package sokoban.Tests;


import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import sokoban.Game.Game;
import sokoban.Game.SokobanParser;
import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;

import static org.junit.Assert.*;


@RunWith(JExample.class)
public class PlayerMovementTest {
    private Game game;
    private SokobanParser sokobanParser;
    private Tile[][] expectedBoard;

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Test
    public void setUp() throws Exception{
        game = new Game("levels/basic1.sok");
        sokobanParser = new SokobanParser();
        expectedBoard = sokobanParser.parse("levels/basic1.sok");
    }

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Given("setUp")
    public void movePlayerUp()throws Exception {
        game.run("up", new Renderer());
        Player player = (Player) expectedBoard[2][1];
        Tile floor = player.getFloor();
        player.setFloor(expectedBoard[1][1]);
        player.setY(1);
        expectedBoard[1][1] = player;
        expectedBoard[2][1] = floor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Given("movePlayerUp")
    public void movePlayerRight() throws Exception{
        game.run("right", new Renderer());
        Player player = (Player) expectedBoard[1][1];
        Tile floor = player.getFloor();
        player.setFloor(expectedBoard[1][2]);
        player.setX(2);
        expectedBoard[1][2] = player;
        expectedBoard[1][1] = floor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Given("movePlayerRight")
    public void movePlayerDown() throws Exception{
        game.run("down", new Renderer());
        Player player = (Player) expectedBoard[1][2];
        Tile floor = player.getFloor();
        player.setFloor(expectedBoard[2][2]);
        player.setY(2);
        expectedBoard[2][2] = player;
        expectedBoard[1][2] = floor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Given("movePlayerDown")
    public void movePlayerLeft() throws Exception{
        game.run("left", new Renderer());
        Player player = (Player) expectedBoard[2][2];
        Tile floor = player.getFloor();
        player.setFloor(expectedBoard[2][1]);
        player.setX(1);
        expectedBoard[2][1] = player;
        expectedBoard[2][2] = floor;
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Given("movePlayerLeft")
    public void movePlayerIntoWall() throws Exception{
        game.run("left", new Renderer());
        assertArrayEquals(expectedBoard, game.getBoard());
    }
}
