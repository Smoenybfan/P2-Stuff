package snakes;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JExample.class)
public class SwapSquareTest {
    private Player jack;
    private Player jill;
    private Player roby;

    @Test
    public Game newGame() {
        jack = new Player("Jack");
        jill = new Player("Jill");
        roby = new Player("Roby");
        Player[] args = { jack, jill, roby};
        Game game = new Game(12, args);

        game.setSquare(4, new SwapSquare(game,4));

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
        assertEquals("[4 (Swap)]", game.getSquare(4).toString());
        assertEquals("[11]", game.getSquare(11).toString());
        return game;
    }

    @Given("newGame")
    public Game moveJackOnToSwapSquare(Game game) {
        game.movePlayer(3);
        assertEquals(1, jack.position());
        assertEquals(4, jill.position());
        assertEquals(1, roby.position());
        assertTrue("The game should not be over when Jack moves to SwapSquare", game.notOver());
        return game;
    }

    @Given("newGame")
    public Game moveJillOnToSwapSquare(Game game) {
        game.movePlayer(6); //move Jack to Square 7
        game.movePlayer(3); //move Jill to 4
        assertEquals(7, jack.position());
        assertEquals(1, jill.position());
        assertEquals(4, roby.position());
        assertTrue("The game should not be over when Jill moves to SwapSquare", game.notOver());
        return game;
    }

    @Given("newGame")
    public Game moveRobyOnToSwapSquare(Game game) {
        game.movePlayer(6); //move Jack to Square 7
        game.movePlayer(5); //move Jill to 6
        game.movePlayer(3);
        assertEquals(4, jack.position());
        assertEquals(6, jill.position());
        assertEquals(7, roby.position());
        assertTrue("The game should not be over when Jill moves to TikTokSquare", game.notOver());
        return game;
    }

}
