package sokoban.test.io.output;

import org.junit.Test;
import sokoban.game.Game;
import sokoban.io.output.PlaintextRenderer;
import sokoban.tile.Tile;

import static org.mockito.Mockito.*;

public class TestPlaintextRenderer {
    @Test
    public void testVisitGameChecksAllSquares() {
        Game game = mock(Game.class);
        Tile tile = mock(Tile.class);
        PlaintextRenderer renderer = new PlaintextRenderer();
        when(game.getWidth()).thenReturn(2);
        when(game.getHeight()).thenReturn(3);
        when(game.tileAt(anyObject())).thenReturn(tile);

        renderer.visitGame(game);

        verify(game, times(6)).hasEntityAt(anyObject());
    }
}
