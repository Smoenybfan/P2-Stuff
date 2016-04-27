package snakes;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by Simon on 10.04.2016.
 */
@RunWith(JExample.class)
public class SnakeTest {
    private Player firstPlayer = mock(Player.class);
    private Player secondPlayer = mock(Player.class);
    private Player thirdPlayer = mock(Player.class);
    private Game spyGame;

    @Test
    public Snake setGame() {
        Player[] players = {firstPlayer, secondPlayer, thirdPlayer};

        Game game = new Game(10, players);
        spyGame = spy(game);
        Snake snake = new Snake(2,spyGame,4);
        return snake;
    }

    @Given("setGame")
    public void initialStrings(Snake snake){
        snake.enter(firstPlayer);
        when(firstPlayer.toString()).thenReturn("first");
        assertEquals("[6<-4<first>]",snake.toString());

    }
}