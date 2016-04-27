package snakes;

/**
 * Created by smoen on 27.04.2016.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ch.unibe.jexample.JExample;
import ch.unibe.jexample.Given;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;


public class DieTestWithMockito {
    Die mockedDie = mock(Die.class);
    private static final int MAX = 20;

    @Before
    public void testDie(){
    when(mockedDie.roll()).thenReturn(2);

    }

    @Test
    public void testInRange() {
        for (int i = 1;i<=6;i++) {
            when(mockedDie.roll()).thenReturn(i);
            int result = mockedDie.roll();
            assertTrue(result >= 1 && result <= Die.FACES);
        }
    }

    @Test
    public void rolled(){
        int move = mockedDie.roll();
        assertEquals(move, 2);
    }

    @Test
    public void testGamePlay(){
        Player playerOne = new Player("playerOne");
        Player playerTwo = new Player("playerTwo");
        Player[] players = {playerOne,playerTwo};
        Game game = new Game(10, players);

        game.movePlayer(mockedDie.roll());
        assertEquals(3,playerOne.position());
    }

    @Test
    public void testMinReached() {
        assertTrue(reached(1));
    }

    @Test
    public void testMaxReached() {
        assertTrue(reached(Die.FACES));
    }

    /**
     * Roll at most MAX times and return true if the given value has occurred.
     * @param value value that needs to be rolled
     * @return true, if the value has been rolled, false otherwise
     */
    private boolean reached(int value) {

        for (int i = 1; i<=6; i++) {
            when(mockedDie.roll()).thenReturn(i);
            if (mockedDie.roll() == value) {
                return true;
            }
        }
        return false;
    }

}
