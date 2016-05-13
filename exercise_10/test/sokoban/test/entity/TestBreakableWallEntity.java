package sokoban.test.entity;

import org.junit.Before;
import org.junit.Test;
import sokoban.entity.BreakableWallEntity;
import sokoban.entity.Entity;
import sokoban.entity.EntityVisitor;
import sokoban.game.Point;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestBreakableWallEntity {
    private BreakableWallEntity breakableWallEntity;

    @Before
    public void setUp() {
        breakableWallEntity = new BreakableWallEntity();
    }

    @Test
    public void testAccept() {
        EntityVisitor visitor = mock(EntityVisitor.class);
        breakableWallEntity.accept(visitor);
        verify(visitor).visitBreakableWallEntity(breakableWallEntity);
    }

    @Test
    public void testCollideWith() {
        Entity entity = mock(Entity.class);
        Point p = mock(Point.class);
        breakableWallEntity.collideWith(entity, p);
        verify(entity).collideWithBreakableWallEntity(breakableWallEntity, p);
    }

    @Test
    public void testToString() {
        assertEquals("aBreakableWall", breakableWallEntity.toString());

    }
}
