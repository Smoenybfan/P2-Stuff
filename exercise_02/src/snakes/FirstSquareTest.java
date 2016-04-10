package snakes;



/**
 * Created by kafader on 08.04.2016.
 */
import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JExample.class)
public class FirstSquareTest {
    Player firstPlayer = new Player("firstPlayer");
    Player secondPlayer = new Player(("secondPlayer"));
    Player thirdPlayer = new Player("thirdPlayer");
    Player[] players = {firstPlayer, secondPlayer,thirdPlayer};


    @Test
    public Game setUpGame(){
        Game game = new Game(12, players);
        assertTrue(game.getSquare(1).isFirstSquare());
        assertTrue(game.firstSquare().isOccupied());
        assertEquals(firstPlayer.position(),1);
        assertEquals(thirdPlayer.position(),1);
        assertEquals(secondPlayer.position(),1);
        return game;
    }

    @Given("setUpGame")
    public void initialString(Game game){
        assertEquals("[1<firstPlayer><secondPlayer><thirdPlayer>]",game.getSquare(1).toString());

    }

}