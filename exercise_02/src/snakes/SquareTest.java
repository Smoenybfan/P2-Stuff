package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by kafader on 10.04.2016.
 */
public class SquareTest {
    Game spyGame;
    Player firstPlayer = mock(Player.class);
    Player secondPlayer = mock(Player.class);
    Player thirdPlayer = mock(Player.class);
    Player[] players = {firstPlayer, secondPlayer,thirdPlayer};

    @Before
    public void setUp(){
        Game game = new Game(12,players);
        spyGame = spy(game);
        Square secondSquare = new Square(spyGame, 2);
        Square thirdSquare = new Square(spyGame, 3);
        Square sixthSquare = new Square(spyGame, 6);
        when(spyGame.getSquare(2)).thenReturn(secondSquare);
        when(spyGame.getSquare(3)).thenReturn(thirdSquare);
        when(spyGame.getSquare(6)).thenReturn(sixthSquare);
        when(firstPlayer.toString()).thenReturn("first");
        when(secondPlayer.toString()).thenReturn("second");

    }

    @Test
    public void nextAndPreviousSquare() throws Exception{

        assertEquals(spyGame.getSquare(2).position()+1,spyGame.getSquare(3).position());
        assertEquals(spyGame.getSquare(3).position()-1, spyGame.getSquare(2).position());
    }

    @Test
    public void position() throws Exception {
        assertEquals(6, spyGame.getSquare(6).position());
    }

    @Test
    public void moveAndLand() throws Exception {
        Square secondSquare = new Square(spyGame,2);
        ISquare square = secondSquare.moveAndLand(4);
        assertEquals(6, square.position());
    }

    @Test
    public void landHereOrGoHome() throws Exception {
        Square square = new Square(spyGame, 2);
        square.enter(firstPlayer);
        ISquare secondSquare = square.landHereOrGoHome();
        assertEquals(1, secondSquare.position());
    }

    @Test
    public void isOccupied() throws Exception {
        Square square = new Square(spyGame, 2);
        square.enter(firstPlayer);
        assertTrue(square.isOccupied());
    }

    @Test
    public void leave() throws Exception {
       Square square = new Square(spyGame,2);
        square.enter(firstPlayer);
        square.leave(firstPlayer);
        assertFalse(square.isOccupied());
    }

    @Test
    public void player(){
        Square square = new Square(spyGame,2);
        assertEquals("",square.player());
        square.enter(firstPlayer);

        assertEquals("<first>",square.player());
    }

}