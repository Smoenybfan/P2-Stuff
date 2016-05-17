package sokoban.Tests;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import sokoban.Exceptions.RenderException;
import sokoban.Game.Game;
import sokoban.Game.SokobanParser;
import sokoban.GameObjects.*;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JExample.class)
public class WallBreakerTest {
    private Game game;
    private SokobanParser sokobanParser;
    private Tile[][] expectedBoard;

    /**
     * This is an integration Test
     * @throws Exception
     */
    @Test
    public void setUp() throws Exception{
        game = new Game("levels/extended1.sok");
        sokobanParser = new SokobanParser();
        expectedBoard = sokobanParser.parse("levels/extended1.sok");
    }

    /**
     * This is an integration Test
     * @throws RenderException
     */
    @Given("setUp")
    public void movePlayerIntoBomb() throws RenderException{
        game.run("right,right,right,right,right,down,down,down,right,down,left,left,left,up,left");
        game.run("down");
        expectedBoard[2][1] = new Floor(2,1);
        expectedBoard[2][6] = new Floor(2,6);
        expectedBoard[3][6] = new Floor(3,6);
        expectedBoard[6][3] = new Floor(6,3);
        expectedBoard[2][7] = new Bomb(2,7);
        expectedBoard[5][3] = new Player(5,3);
        assertArrayEquals(game.getBoard(),expectedBoard);

    }
}
