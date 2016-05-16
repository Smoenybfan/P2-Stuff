package sokoban.Tests;


import com.sun.org.apache.regexp.internal.RE;
import org.junit.Before;
import org.junit.Test;
import sokoban.Exceptions.RenderException;
import sokoban.Game.Game;
import sokoban.GameObjects.Tile;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class GameTest {
    Game game;

    @Before
    public void setUp(){
        game = new Game("levels/basic1.sok");
    }

    @Test
    public void notInitialized(){
        game = new Game("levels/basic5");
        assertFalse(game.isInitialized());
    }

    @Test
    public void NotOver(){
        assertTrue(game.notOver());
        assertTrue(game.isInitialized());
    }

    /**
     * This is an integration Test
     * I don't know how to test the run() method else than in an integration test
     */
    @Test(expected = RenderException.class)
    public void throwRenderException() throws RenderException{
        Tile tile = mock(Tile.class);
        game.getBoard()[2][1] = tile;
        when(tile.toString()).thenReturn("Y");
        game.run("down");
    }

    /**
     * This is an integration Test
     */
    @Test
    public void NotOverAfterMove() throws RenderException{
        game.run("down,up,up,right");
        assertTrue(game.notOver());
    }
}
