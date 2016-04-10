package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kafader on 10.04.2016.
 */
public class SquareTest {
    Game game;
    Player firstPlayer = new Player("firstPlayer");
    Player secondPlayer = new Player(("secondPlayer"));
    Player thirdPlayer = new Player("thirdPlayer");
    Player[] players = {firstPlayer, secondPlayer,thirdPlayer};

    @Before
    public void setUp(){
        game = new Game(12,players);
    }

    @Test
    public void nextAndPreviousSquare() throws Exception{
        assertEquals(game.getSquare(2).position()+1,game.getSquare(3).position());
        assertEquals(game.getSquare(3).position()-1, game.getSquare(2).position());
    }

    @Test
    public void position() throws Exception {
        assertEquals(6, game.getSquare(6).position());
    }

    @Test
    public void moveAndLand() throws Exception {
        game.movePlayer(4);
        assertEquals(5,firstPlayer.position());
    }

    @Test
    public void landHereOrGoHome() throws Exception {
        game.movePlayer(4);//moves firstPlayer
        game.movePlayer(4);//moves secondPlayer
        assertEquals(5,firstPlayer.position());
        assertEquals(1,secondPlayer.position());
    }

    @Test
    public void isOccupied() throws Exception {
        assertTrue(game.getSquare(1).isOccupied());
        game.movePlayer(3);
        assertTrue(game.getSquare(4).isOccupied());
    }

    @Test
    public void leave() throws Exception {
        game.movePlayer(3);
        assertNotEquals(1, firstPlayer.position());
    }

    @Test
    public void isFirstSquare() throws Exception {
        assertEquals(1,game.firstSquare().position());
    }

}