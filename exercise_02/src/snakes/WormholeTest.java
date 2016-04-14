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
        private Player roby;

        @Test
        public Game newGame() {
            jack = new Player("Jack");
            jill = new Player("Jill");
            roby = new Player("Roby");
            Player[] args = {jack, jill, roby};
            Game game = new Game(20,args);
            WormholeEntrance we = mock(WormholeEntrance.class);
            when(we.toString()).thenReturn("[4 (WEn)]");

            WormholeExit e1 = new WormholeExit(game, 5);
            WormholeExit e2 = new WormholeExit(game, 8);
            WormholeExit e3 = new WormholeExit(game, 10);

            when(we.landHereOrGoHome()).thenReturn(e1);

            game.setSquare(4,we);
            game.setSquare(5,e1);
            game.setSquare(8,e2);
            game.setSquare(10,e3);

            assertTrue(game.notOver());
            assertTrue(game.firstSquare().isOccupied());
            assertEquals(1, jack.position());
            assertEquals(1, jill.position());
            assertEquals(1, roby.position());
            assertEquals(jack, game.currentPlayer());
            return game;
        }

        @Given("newGame")
        public Game initialStrings(Game game) {
            assertEquals("Jack", jack.toString());
            assertEquals("Jill", jill.toString());
            assertEquals("Roby", roby.toString());
            assertEquals("[1<Jack><Jill><Roby>]", game.firstSquare().toString());
            assertEquals("[4 (WEn)]", game.getSquare(4).toString());
            assertEquals("[5 (WEx)]", game.getSquare(5).toString());
            assertEquals("[8 (WEx)]", game.getSquare(8).toString());
            assertEquals("[15]", game.getSquare(15).toString());
            return game;
        }

        @Given("newGame")
        public Game moveJackOnToWormholeEntrance(Game game) {
            game.movePlayer(3);
            assertEquals(5, jack.position());
            assertEquals(1, jill.position());
            assertEquals(1, roby.position());
            assertTrue("The game should not be over when Jack moves to WormholeEntrance", game.notOver());
            return game;
        }

        @Given("newGame")
        public Game moveJillOnToWormholeEntrance(Game game) {
            WormholeEntrance we = (WormholeEntrance) game.getSquare(4);
            when(we.landHereOrGoHome()).thenReturn(game.getSquare(8));

            game.movePlayer(2);
            game.movePlayer(3);
            assertEquals(3, jack.position());
            assertEquals(8,jill.position());
            assertEquals(1, roby.position());
            assertTrue("The game should not be over when Jill moves to WormholeEntrance", game.notOver());
            return game;
        }
    }


