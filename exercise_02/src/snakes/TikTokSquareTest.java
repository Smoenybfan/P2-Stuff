package snakes;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(JExample.class)
public class TikTokSquareTest {
	private Player jack;
	private Player jill;
	private TikTokSquare tikTokSquare;
	Game spyGame;

	@Test
	public TikTokSquare newGame() {
		jack = mock(Player.class);
		jill = mock(Player.class);
		Player[] args = { jack, jill };
		Game game = new Game(12,args);
		spyGame = spy(game);
		tikTokSquare = new TikTokSquare(spyGame, 3, 5, 7);
		return tikTokSquare;
	}

	@Given("newGame")
	public TikTokSquare initialStrings(TikTokSquare tikTokSquare) {
		Square square = mock(Square.class);
		when(square.squareLabel()).thenReturn("3");
		assertEquals("[3 (TikTok)]",tikTokSquare.toString());
		return tikTokSquare;
	}

	@Given("newGame")
	public TikTokSquare landHereOrGoHome(TikTokSquare tikTokSquare){
		Square squareFive = mock(Square.class);
		Square squareSeven = mock(Square.class);
		when(spyGame.getSquare(5)).thenReturn(squareFive);
		when(spyGame.getSquare(7)).thenReturn(squareSeven);
		when(squareFive.landHereOrGoHome()).thenReturn(squareFive);
		when(squareSeven.landHereOrGoHome()).thenReturn(squareSeven);

		assertEquals(squareFive,tikTokSquare.landHereOrGoHome());
		assertEquals(squareSeven, tikTokSquare.landHereOrGoHome());
		return tikTokSquare;
	}

}
