package snakes;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Simon on 10.04.2016.
 */
@RunWith(JExample.class)
public class SnakeTest {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player thirdPlayer;

    @Test
    public Game setGame() {
        firstPlayer=new Player("firstPlayer");
        secondPlayer=new Player("secondPlayer");
        thirdPlayer=new Player("thirdPlayer");
        Player[] players = {firstPlayer, secondPlayer, thirdPlayer};

        Game game = new Game(12, players);

        game.setSquareToSnake(4,2);
        game.setSquareToSnake(9,3);
        game.setSquareToSnake(6,3);

        assertTrue(game.notOver());
        assertEquals(1, firstPlayer.position());
        assertEquals(1, secondPlayer.position());
        assertEquals(1, thirdPlayer.position());
        assertSame(firstPlayer, game.currentPlayer());
        assertTrue(game.firstSquare().isOccupied());

        return game;
    }

    @Given("setGame")
    public Game moveFirstPlayerToFirstSnake(Game game){
        game.movePlayer(3);
        assertEquals(firstPlayer.position(),2);
        assertFalse(game.getSquare(4).isOccupied());
        assertTrue(game.notOver());
        assertSame(game.currentPlayer(),secondPlayer);

        return game;
    }

    @Given("moveFirstPlayerToFirstSnake")
    public Game moveSecondPlayer(Game game){
        game.movePlayer(2);
        assertEquals(secondPlayer.position(),3);
        assertTrue(game.notOver());
        assertSame(game.currentPlayer(),thirdPlayer);

        return game;
    }

    @Given("moveSecondPlayer")
    public Game moveThirdPlayerToSecondSnake(Game game){
        game.movePlayer(8);
        assertEquals(secondPlayer.position(),3);
        assertEquals("thirdPlayer gets moved back over two snakes to an occupied field", thirdPlayer.position(),1);
        assertTrue(game.notOver());
        assertSame(game.currentPlayer(),firstPlayer);

        return game;
    }
}