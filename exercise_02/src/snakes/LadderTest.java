package snakes;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by kafader on 06.04.2016.
 */
@RunWith(JExample.class)
public class LadderTest {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player thirdPlayer;


    @Test
    public Game setGame() {
        firstPlayer=new Player("firstPlayer");
        secondPlayer=new Player("secondPlayer");
        thirdPlayer=new Player("thirdPlayer");
        Player[] players = {firstPlayer, secondPlayer, thirdPlayer};

        Game game = spy(new Game(12, players));

        game.setSquareToLadder(4,2);
        game.setSquareToLadder(5,7);

        /*assertTrue(game.notOver());
        assertEquals(1, firstPlayer.position());
        assertEquals(1, secondPlayer.position());
        assertEquals(1, thirdPlayer.position());
        assertSame(firstPlayer, game.currentPlayer());
        assertTrue(game.firstSquare().isOccupied()); */

        return game;
    }

    @Given("setGame")
    public Game firstPlayerEntersLadder(Game game) {
        game.movePlayer(3);
        assertEquals(6,firstPlayer.position());
        assertEquals(1, secondPlayer.position());
        assertEquals(1, thirdPlayer.position());
        assertTrue(game.notOver());
        assertSame(game.currentPlayer(),secondPlayer);
        return game;
    }

    @Given("firstPlayerEntersLadder")
    public Game secondPlayerEntersLadder(Game game){
        game.movePlayer(3);
        assertEquals(6, firstPlayer.position());
        assertEquals("gets moved back because 6 is occupied", 1, secondPlayer.position());
        assertEquals(1, thirdPlayer.position());
        assertTrue(game.notOver());
        assertSame(game.currentPlayer(), thirdPlayer);
        return game;
    }

    @Given("setGame")
    public Game firstPlayerEntersFinalLadder(Game game){
        game.movePlayer(4);
        assertEquals(12,firstPlayer.position());
        assertEquals(1, secondPlayer.position());
        assertEquals(1, thirdPlayer.position());
        assertTrue(game.isOver());
        assertSame(firstPlayer,game.winner());
        return game;
    }

    @Given("setGame")
    public Game initialStrings(Game game){
        assertEquals("firstPlayer", firstPlayer.toString());
        assertEquals("secondPlayer", secondPlayer.toString());
        assertEquals("thirdPlayer", thirdPlayer.toString());
        assertEquals("[4->6]",game.getSquare(4).toString());
        assertEquals("[5->12]",game.getSquare(5).toString());
        return game;
    }



}