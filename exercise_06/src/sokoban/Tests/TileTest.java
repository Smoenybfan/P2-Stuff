package sokoban.Tests;
import org.junit.Before;
import org.junit.Test;
import sokoban.Game.Game;
import sokoban.GameObjects.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class TileTest {
    private Tile tile;

    @Before
    public void setUp(){
        tile = new Tile(4,6);
        Game game = mock(Game.class);
    }

    @Test
    public void notEqualsIsNull(){
        assertFalse(tile.equals(null));
    }

    @Test
    public void notEqualsOtherClass(){
        assertFalse(tile.equals(new Object()));
    }

    @Test
    public void notEqualsTileWithOtherYPosition(){
        assertFalse(tile.equals(new Tile(5,6)));
    }

    @Test
    public void notEqualsTileWithOtherXPosition(){
        assertFalse(tile.equals(new Tile(4,7)));

    }

    @Test
    public void EqualsTileWithSamePosition(){
        assertTrue(tile.equals(new Tile(4,6)));
    }
}
