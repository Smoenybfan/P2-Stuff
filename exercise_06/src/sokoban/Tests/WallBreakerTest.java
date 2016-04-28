package sokoban.Tests;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import sokoban.Game.Game;
import sokoban.Game.Parser;
import sokoban.GameObjects.*;
import org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

@RunWith(JExample.class)
public class WallBreakerTest {
    private Game game;
    private Parser parser;
    private Tile[][] expectedBoard;

    @Test
    public void setUp() throws Exception{
        game = new Game("levels/extended1.sok");
        parser = new Parser();
        expectedBoard = parser.parse("levels/extended1.sok");
    }

    @Given("setUp")
    public void movePlayerIntoBomb() throws Exception{
        game.run("right,right,right,right,,right,down,down,down,right,down,left,left,left,up,left");
        game.run("down");
        Player player = (Player) expectedBoard[2][1];
        Bomb bomb = (Bomb) expectedBoard[6][2];
        Tile playerFloor = player.getFloor();
        Tile bombFloor = bomb.getFloor();
        player.setFloor(bombFloor);
        expectedBoard[7][2]= new Floor(8,3);
        assertArrayEquals(expectedBoard, game.getBoard());

    }
}
