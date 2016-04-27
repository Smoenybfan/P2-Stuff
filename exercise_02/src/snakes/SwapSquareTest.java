package snakes;

import ch.unibe.jexample.Given;
    import ch.unibe.jexample.JExample;
    import org.junit.Test;
    import org.junit.runner.RunWith;

    import static org.junit.Assert.assertEquals;
    import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(JExample.class)
    public class SwapSquareTest {
        private Player jack;
        private Player jill;
        private Player roby;
        private Game spyGame;

    @Test
    public SwapSquare newGame() {
        jack = mock(Player.class);
        jill = mock(Player.class);
        roby = mock(Player.class);
        Player[] args = { jack, jill, roby};

        Game game = new Game(12, args);
        spyGame =spy(game);
        SwapSquare swapSquare = new SwapSquare(spyGame, 6);
        when(jack.position()).thenReturn(3);
        when(jill.position()).thenReturn(5);
        return swapSquare;
    }

    @Given("newGame")
    public SwapSquare initialStrings(SwapSquare swapSquare) {
        Square square = mock(Square.class);
        when(square.squareLabel()).thenReturn("6");
        assertEquals("[6 (Swap)]",swapSquare.toString());
        return swapSquare;
    }

    @Given("newGame")
    public SwapSquare destination(SwapSquare swapSquare){
        when(spyGame.currentPlayer()).thenReturn(jack);
        int dest = jack.position();
        ISquare square = mock(Square.class);
        when(spyGame.getSquare(dest)).thenReturn(square);
        assertEquals(swapSquare.destination(),square);
        return swapSquare;
    }


}
