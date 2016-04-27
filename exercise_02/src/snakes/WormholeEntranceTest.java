package snakes;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by smoen on 27.04.2016.
 */
public class WormholeEntranceTest {

    private Player jack = mock(Player.class);
    private Player jill = mock(Player.class);
    private Player[] players = {jack,jill};
    private Game spyGame;
    private WormholeEntrance wormholeEntrance;

    @Before
    public void setUp(){
        Game game = new Game(12, players);
        spyGame = spy(game);
        wormholeEntrance = new WormholeEntrance(spyGame, 3);
    }


   /* @Test
    public void landHereOrGoHome() throws Exception {
        WormholeEntrance spy = spy(wormholeEntrance);
        WormholeExit one = mock(WormholeExit.class);
        WormholeExit two = mock(WormholeExit.class);
        when(spy.destination()).thenReturn(one);

        assertEquals(one, spy.landHereOrGoHome());
    }*/

    @Test
    public void outString() throws Exception {
        Square square = mock(Square.class);
        when(square.squareLabel()).thenReturn("3");
        assertEquals("[3 (WEn)]",wormholeEntrance.toString());
    }

}