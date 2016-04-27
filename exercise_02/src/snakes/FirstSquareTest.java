package snakes;



/**
 * Created by kafader on 08.04.2016.
 */
import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(JExample.class)
public class FirstSquareTest {
    Player firstPlayer = new Player("firstPlayer");
    Player secondPlayer = new Player(("secondPlayer"));
    Player thirdPlayer = new Player("thirdPlayer");
    Player[] players = {firstPlayer, secondPlayer,thirdPlayer};


    @Test
    public Game setUpGame(){
        Game spygame = spy(new Game(12, players));
        /*doReturn().when(spygame.getSquare(1))
        when(spygame.getSquare(1)).thenReturn(new FirstSquare(spygame, 1));
        assertTrue(spygame.getSquare(1).isFirstSquare());
        return spygame;*/
    return spygame;}

    @Given("setUpGame")
    public void initialString(Game spygame){
        assertEquals("[1<firstPlayer><secondPlayer><thirdPlayer>]",spygame.getSquare(1).toString());

    }

}