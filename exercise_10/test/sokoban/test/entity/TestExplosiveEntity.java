package sokoban.test.entity;

import org.junit.Before;
import org.junit.Test;
import sokoban.entity.BreakableWallEntity;
import sokoban.entity.Entity;
import sokoban.entity.EntityVisitor;
import sokoban.entity.ExplosiveEntity;
import sokoban.game.Game;
import sokoban.game.Point;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestExplosiveEntity {
    private Game game;
    private ExplosiveEntity explosiveEntity;

    @Before
    public void setUp() {
        game = mock(Game.class);
        explosiveEntity = new ExplosiveEntity(game);
    }

    @Test
    public void testAccept() {
        EntityVisitor visitor = mock(EntityVisitor.class);
        explosiveEntity.accept(visitor);
        verify(visitor).visitExplosiveEntity(explosiveEntity);
    }

    @Test
    public void testCollideWith() {
        Entity entity = mock(Entity.class);
        Point p = mock(Point.class);
        explosiveEntity.collideWith(entity, p);
        verify(entity).collideWithExplosiveEntity(explosiveEntity, p);
    }

    @Test
    public void testCollideWithBreakableWallEntity() {
        BreakableWallEntity wall = mock(BreakableWallEntity.class);
        Point delta = mock(Point.class);

        explosiveEntity.collideWithBreakableWallEntity(wall, delta);

        verify(game).removeEntity(wall);
        verify(game).removeEntity(explosiveEntity);
    }

    @Test
    public void testToString() {
        assertEquals("anExplosive", explosiveEntity.toString());
    }
}
