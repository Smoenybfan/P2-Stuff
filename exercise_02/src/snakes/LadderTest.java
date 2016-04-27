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
    private Player firstPlayer = mock(Player.class);
    private Player secondPlayer = mock(Player.class);
    private Player thirdPlayer = mock(Player.class);
    private Game spyGame;

    @Test
    public Ladder setGame() {
        Player[] players = {firstPlayer, secondPlayer, thirdPlayer};

        Game game = new Game(10, players);
        spyGame = spy(game);
        Ladder ladder = new Ladder(2,spyGame,4);
        return ladder;
    }

    @Given("setGame")
    public Ladder firstPlayerEntersLadder(Ladder ladder) {
        Square square = mock(Square.class);
        when(square.landHereOrGoHome()).thenReturn(square);
        when(spyGame.getSquare(6)).thenReturn(square);
        assertEquals(square,ladder.landHereOrGoHome());
        return ladder;
    }

    @Given("firstPlayerEntersLadder")
    public Ladder secondPlayerEntersLadder(Ladder ladder){
        FirstSquare firstSquare = mock(FirstSquare.class);
        Square square = mock(Square.class);
        when(square.landHereOrGoHome()).thenReturn(firstSquare);
        when(spyGame.getSquare(6)).thenReturn(square);
        assertEquals(firstSquare,ladder.landHereOrGoHome());
        return ladder;
    }

    @Given("setGame")
    public void initialStrings(Ladder ladder){
        ladder.enter(firstPlayer);
        when(firstPlayer.toString()).thenReturn("first");
        assertEquals("[4->6<first>]",ladder.toString());

    }



}