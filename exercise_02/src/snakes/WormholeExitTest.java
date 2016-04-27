package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by smoen on 27.04.2016.
 */
public class WormholeExitTest {

    private Player jack = mock(Player.class);
    private Player jill = mock(Player.class);
    private Player[] players = {jack,jill};
    private Game spyGame;
    private WormholeExit wormholeExit;

    @Before
    public void setUp(){
        Game game = new Game(12, players);
        spyGame = spy(game);
        wormholeExit = new WormholeExit(spyGame, 3);
    }

    @Test
    public void outString() throws Exception {
        Square square = mock(Square.class);
        when(square.squareLabel()).thenReturn("3");
        assertEquals("[3 (WEx)]",wormholeExit.toString());
    }



}