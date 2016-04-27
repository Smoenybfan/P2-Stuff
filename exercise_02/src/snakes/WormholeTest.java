package snakes;

import ch.unibe.jexample.Given;
    import ch.unibe.jexample.JExample;
    import org.junit.Test;
    import org.junit.runner.RunWith;

    import static org.junit.Assert.assertEquals;
    import static org.junit.Assert.assertTrue;
    import static org.junit.Assert.fail;

    import static org.mockito.Mockito.*;

    @RunWith(JExample.class)
    public class WormholeTest {
        private Player jack;
        private Player jill;
        private Game spyGame;
        private WormholeEntrance wormholeEntrance;
        private WormholeExit wormholeExit1;
        private WormholeExit wormholeExit2;
        private WormholeExit wormholeExit3;

        @Test
        public Game newGame() {
            jack = new Player("Jack");
            jill = new Player("Jill");
            Player[] args = {jack, jill};
            Game game = new Game(12,args);
            spyGame = spy(game);

            wormholeEntrance = new WormholeEntrance(spyGame,4);
            wormholeExit1 = new WormholeExit(spyGame, 5);
            wormholeExit2 = new WormholeExit(spyGame, 8);
            wormholeExit3 = new WormholeExit(spyGame, 10);

            WormholeEntrance we = spy(wormholeEntrance);

            when(we.destination()).thenReturn(wormholeExit1);
            assertEquals(wormholeExit1,we.landHereOrGoHome());

            when(we.destination()).thenReturn(wormholeExit3);
            assertEquals(wormholeExit3,we.landHereOrGoHome());

            when(we.destination()).thenReturn(wormholeExit2);
            assertEquals(wormholeExit2,we.landHereOrGoHome());

            return game;
        }

        @Given("newGame")
        public Game initialStrings(Game game) {
            Square square = mock(Square.class);
            when(square.squareLabel()).thenReturn("4");
            return game;
        }


    }


