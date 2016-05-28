package sokoban.test.parser;

import org.junit.Test;
import sokoban.entity.BoxEntity;
import sokoban.entity.BreakableWallEntity;
import sokoban.entity.ExplosiveEntity;
import sokoban.entity.PlayerEntity;
import sokoban.game.Game;
import sokoban.game.Point;
import sokoban.io.input.InputHandler;
import sokoban.io.output.Renderer;
import sokoban.parser.PlaintextParser;
import sokoban.tile.FloorTile;
import sokoban.tile.WallTile;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class TestPlaintextParser {

    private Game parse(String level) {
        Renderer renderer = mock(Renderer.class);
        InputHandler inputHandler = mock(InputHandler.class);
        return new PlaintextParser().makeGameFromText(level);
    }

    @Test
    public void testParseFloorTile() {
        Game game = parse("4 1\n PGB");
        assertThat(game.tileAt(new Point(1, 1)), instanceOf(FloorTile.class));
    }

    @Test
    public void testParseWallTile() {
        Game game = parse("4 1\n#PGB");
        assertThat(game.tileAt(new Point(1, 1)), instanceOf(WallTile.class));
    }

    @Test
    public void testParsePlayerEntity() {
        Game game = parse("3 1\nPGB");
        assertThat(game.entityAt(new Point(1, 1)), instanceOf(PlayerEntity.class));
    }

    @Test
    public void testParseBoxEntity() {
        Game game = parse("3 1\nBPG");
        assertThat(game.entityAt(new Point(1, 1)), instanceOf(BoxEntity.class));
    }

    @Test
    public void testParseExplosiveEntity() {
        Game game = parse("4 1\nOPGB");
        assertThat(game.entityAt(new Point(1, 1)), instanceOf(ExplosiveEntity.class));
    }

    @Test
    public void testParseBreakableWallEntity() {
        Game game = parse("4 1\nXPGB");
        assertThat(game.entityAt(new Point(1, 1)), instanceOf(BreakableWallEntity.class));
    }
}
