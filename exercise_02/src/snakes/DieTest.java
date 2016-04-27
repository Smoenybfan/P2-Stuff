package snakes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ch.unibe.jexample.JExample;
import ch.unibe.jexample.Given;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class DieTest {
	MockedDie die;
	private int[] dieValues = {2,4,5,1,6,3};
	private static final int MAX = 20;

	@Before
	public void testDie(){

		die = new MockedDie(dieValues);

	}
	
	@Test
	public void testInRange() {
		for (int i = 0;i<dieValues.length;i++) {
			int result = die.roll();
			assertTrue(result >= 1 && result <= Die.FACES);
		}
	}

	@Test
	public void rolled(){
		int move = die.roll();
		assertEquals(move, 2);
	}

	@Test
	public void testMinReached() {
		assertTrue(reached(1));
	}

	@Test
	public void testMaxReached() {
		assertTrue(reached(Die.FACES));
	}

	@Test
	public void testGamePlay(){
		Player playerOne = new Player("playerOne");
		Player playerTwo = new Player("playerTwo");
		Player[] players = {playerOne,playerTwo};
		Game game = new Game(10, players);

		game.movePlayer(die.roll());
		assertEquals(3,playerOne.position());
	}

	/**
	 * Roll at most MAX times and return true if the given value has occurred.
	 * @param value value that needs to be rolled
	 * @return true, if the value has been rolled, false otherwise
	 */
	private boolean reached(int value) {

		for (int i = 1; i<dieValues.length; i++) {
			if (die.roll() == value) {
				return true;
			}
		}
		return false;
	}
}
