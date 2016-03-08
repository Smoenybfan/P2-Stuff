package snakes;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(JExample.class)
public class TikTokSquareTest {
	private Player jack;
	private Player jill;

	@Test
	public Game newGame() {
		jack = new Player("Jack");
		jill = new Player("Jill");
		Player[] args = { jack, jill };
		Game game = new Game(12, args);

		game.setSquare(4, new TikTokSquare(game, 4, 5, 6));
		
		assertTrue(game.notOver());
		assertTrue(game.firstSquare().isOccupied());
		assertEquals(1, jack.position());
		assertEquals(1, jill.position());
		assertEquals(jack, game.currentPlayer());
		return game;
	}

	@Given("newGame")
	public Game initialStrings(Game game) {
		assertEquals("Jack", jack.toString());
		assertEquals("Jill", jill.toString());
		assertEquals("[1<Jack><Jill>]", game.firstSquare().toString());
		assertEquals("[4 (TikTok)]", game.getSquare(4).toString());
		assertEquals("[10]", game.getSquare(10).toString());
		return game;
	}
	
	@Given("newGame")
	public Game moveJackOnToTikTokSquare(Game game) {
		game.movePlayer(3);
		assertEquals(5, jack.position());
		assertEquals(1, jill.position());
		assertTrue("The game should not be over when Jack moves to TikTokSquare", game.notOver());
		return game;
	}

	@Given("moveJackOnToTikTokSquare")
	public Game moveJillOnToTikTokSquare(Game game) {
		game.movePlayer(3);
		assertEquals(5, jack.position());
		assertEquals(6, jill.position());
		assertTrue("The game should not be over when Jill moves to TikTokSquare", game.notOver());
		return game;
	}

}
