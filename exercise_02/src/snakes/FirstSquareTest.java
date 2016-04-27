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

    Player firstPlayer = mock(Player.class);
    Player secondPlayer = mock(Player.class);
    Player fourthPlayer;
    Player[] players = {firstPlayer, secondPlayer};


    @Test
    public FirstSquare setUpGame(){
        Game game = new Game(12,players);
        Game spyGame = spy(game);
        FirstSquare firstSquare = new FirstSquare(spyGame,1);
        assertEquals("",firstSquare.player());
        return firstSquare;
    }

    @Given("setUpGame")
    public FirstSquare firstEnters(FirstSquare firstSquare){
        fourthPlayer = mock(Player.class);
        firstSquare.enter(fourthPlayer);
        when(fourthPlayer.toString()).thenReturn("first");
        assertEquals("<first>",firstSquare.player());
        return firstSquare;
    }

    @Given("firstEnters")
    public FirstSquare firstLeaves(FirstSquare firstSquare){
        firstSquare.leave(fourthPlayer);
        assertEquals("",firstSquare.player());
        return firstSquare;
    }

    @Given("firstEnters")
    public void initialString(FirstSquare firstSquare){
        assertEquals("[1<first>]",firstSquare.toString());

    }

}