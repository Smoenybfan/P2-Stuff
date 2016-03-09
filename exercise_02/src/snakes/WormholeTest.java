package snakes;

import ch.unibe.jexample.Given;
    import ch.unibe.jexample.JExample;
    import org.junit.Test;
    import org.junit.runner.RunWith;

    import static org.junit.Assert.assertEquals;
    import static org.junit.Assert.assertTrue;
    import static org.junit.Assert.fail;

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
            Game game = new Game(20, args);

            game.setSquareToWormholeEntrance(4);
            game.setSquareToWormholeExit(5);
            game.setSquareToWormholeExit(8);
            game.setSquareToWormholeExit(10);


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
            assertTrue(jack.position() > 4);
            assertEquals(1, jill.position());
            assertEquals(1, roby.position());
            assertTrue("The game should not be over when Jack moves to WormholeEntrance", game.notOver());
            return game;
        }

        @Given("newGame")
        public Game moveJillOnToWormholeEntrance(Game game) {
            game.movePlayer(2);
            game.movePlayer(3);
            assertEquals(3, jack.position());
            assertTrue(jill.position() > 4);
            assertEquals(1, roby.position());
            assertTrue("The game should not be over when Jill moves to WormholeEntrance", game.notOver());
            return game;
        }
    }


