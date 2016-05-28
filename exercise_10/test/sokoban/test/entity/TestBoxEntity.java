package sokoban.test.entity;

import org.junit.Before;
import org.junit.Test;
import sokoban.entity.BoxEntity;
import sokoban.entity.Entity;
import sokoban.entity.EntityVisitor;
import sokoban.game.Game;
import sokoban.game.Point;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestBoxEntity {
    private Game game;
    private BoxEntity boxEntity;

    @Before
    public void setUp() {
        game = mock(Game.class);
        boxEntity = new BoxEntity();
    }

    @Test
    public void testAccept() {
        EntityVisitor visitor = mock(EntityVisitor.class);
        boxEntity.accept(visitor);
        verify(visitor).visitBoxEntity(boxEntity);
    }

    @Test
    public void testToString() {
        assertEquals("aBox", boxEntity.toString());
    }

    @Test
    public void testCollideWith() {
        Entity entity = mock(Entity.class);
        Point p = mock(Point.class);
        boxEntity.collideWith(entity, p);
        verify(entity).collideWithBoxEntity(boxEntity, p);
    }
}
