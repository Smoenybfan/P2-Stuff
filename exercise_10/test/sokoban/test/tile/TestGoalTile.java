package sokoban.test.tile;

import org.junit.Before;
import org.junit.Test;
import sokoban.game.Game;
import sokoban.game.GameVisitor;
import sokoban.game.Point;
import sokoban.tile.GoalTile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestGoalTile {
    private Game game;
    private Point position;
    private GoalTile goalTile;

    @Before
    public void setUp() {
        game = mock(Game.class);
        position = new Point(1, 1);
        goalTile = new GoalTile(position);
    }

    @Test
    public void testConstructor() {
        assertEquals(position, goalTile.getPosition());
    }

    @Test
    public void testAccept() {
        GameVisitor visitor = mock(GameVisitor.class);
        goalTile.accept(visitor);
        verify(visitor).visitGoalTile(goalTile);
    }

    @Test
    public void testCanBeOccupied() {
        assertTrue(goalTile.canBeOccupied());
    }

    @Test
    public void testIsGoalTile() {
        assertTrue(goalTile.isGoalTile());
    }
}
