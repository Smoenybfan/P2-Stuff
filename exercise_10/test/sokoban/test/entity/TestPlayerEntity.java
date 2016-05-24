package sokoban.test.entity;

import org.junit.Before;
import org.junit.Test;
import sokoban.entity.*;
import sokoban.game.Game;
import sokoban.game.Point;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestPlayerEntity {
    private Game game;
    private PlayerEntity player;

    @Before
    public void setUp() {
        game = mock(Game.class);
        player = new PlayerEntity(game);
    }

    @Test
    public void testMoveRight() {
        player.moveRight();
        verify(game).attemptMoveEntity(player, new Point(1, 0));
    }

    @Test
    public void testMoveDown() {
        player.moveDown();
        verify(game).attemptMoveEntity(player, new Point(0, 1));
    }
    @Test
    public void testMoveUp() {
        player.moveUp();
        verify(game).attemptMoveEntity(player, new Point(0, -1));
    }
    @Test
    public void testMoveLeft() {
        player.moveLeft();
        verify(game).attemptMoveEntity(player, new Point(-1, 0));
    }

    @Test
    public void testMoveBy() {
        Point delta = mock(Point.class);
        player.moveBy(delta);
        verify(game).attemptMoveEntity(player, delta);
    }

    @Test
    public void testAccept() {
        EntityVisitor visitor = mock(EntityVisitor.class);
        player.accept(visitor);
        verify(visitor).visitPlayerEntity(player);
    }

    @Test
    public void testCollideWith() {
        Entity entity = mock(Entity.class);
        Point p = mock(Point.class);
        player.collideWith(entity, p);
        verify(entity).collideWithPlayerEntity(player, p);
    }

    @Test
    public void testCollideWithExplosiveEntity() {
        ExplosiveEntity explosive = mock(ExplosiveEntity.class);
        Point delta = mock(Point.class);
        player.collideWithExplosiveEntity(explosive, delta);
        verify(game).attemptMoveEntity(explosive, delta);
    }

    @Test
    public void testCollideWithBoxEntity() {
        BoxEntity box = mock(BoxEntity.class);
        Point delta = mock(Point.class);
        player.collideWithBoxEntity(box, delta);
        verify(game).attemptMoveEntity(box, delta);
    }

    @Test
    public void testToString() {
        assertEquals("aPlayer", player.toString());
    }
}
