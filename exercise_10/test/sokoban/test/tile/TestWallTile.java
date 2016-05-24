package sokoban.test.tile;

import org.junit.Before;
import org.junit.Test;
import sokoban.game.GameVisitor;
import sokoban.game.Point;
import sokoban.tile.WallTile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestWallTile {
    private Point position;
    private WallTile wallTile;

    @Before
    public void setUp() {
        position = new Point(1, 1);
        wallTile = new WallTile(position);
    }

    @Test
    public void testConstructor() {
        assertEquals(position, wallTile.getPosition());
    }

    @Test
    public void testAccept() {
        GameVisitor visitor = mock(GameVisitor.class);
        wallTile.accept(visitor);
        verify(visitor).visitWallTile(wallTile);
    }

    @Test
    public void testCanBeOccupied() {
        assertFalse(wallTile.canBeOccupied());
    }

    @Test
    public void testIsGoalTile() {
        assertFalse(wallTile.isGoalTile());
    }
}
