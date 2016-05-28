package sokoban.test.tile;

import org.junit.Before;
import org.junit.Test;
import sokoban.game.Game;
import sokoban.game.GameVisitor;
import sokoban.game.Point;
import sokoban.tile.FloorTile;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestFloorTile {
    private Game game;
    private Point position;
    private FloorTile floorTile;

    @Before
    public void setUp() {
        game = mock(Game.class);
        position = new Point(1, 1);
        floorTile = new FloorTile(position);
    }

    @Test
    public void testConstructor() {
        assertEquals(position, floorTile.getPosition());
    }

    @Test
    public void testAccept() {
        GameVisitor visitor = mock(GameVisitor.class);
        floorTile.accept(visitor);
        verify(visitor).visitFloorTile(floorTile);
    }

    @Test
    public void testCanBeOccupied() {
        assertTrue(floorTile.canBeOccupied());
    }

    @Test
    public void testIsGoalTile() {
        assertFalse(floorTile.isGoalTile());
    }
}
