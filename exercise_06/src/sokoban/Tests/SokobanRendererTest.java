package sokoban.Tests;


import org.junit.Before;
import org.junit.Test;
import sokoban.Exceptions.RenderException;
import sokoban.Game.SokobanParser;
import sokoban.Game.SokobanRenderer;
import sokoban.GameObjects.Tile;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SokobanRendererTest {
    private SokobanParser sokobanParser;
    private SokobanRenderer rend;

    @Before
    public void setUp(){
        sokobanParser = new SokobanParser();
        rend = new SokobanRenderer();
    }

    @Test
    public void renderBasic1Sok(){
        String string = "";
        try {
            Tile[][] board = sokobanParser.parse("levels/basic1.sok");
            string += rend.render(board);
        }catch(Exception e){
            assertTrue(false);
        }
        StringBuffer excpectedString = new StringBuffer();
        excpectedString.append("#######\n");
        excpectedString.append("#     #\n");
        excpectedString.append("#P    #\n");
        excpectedString.append("###B  #\n");
        excpectedString.append("###  G#\n");
        excpectedString.append("#######\n");
        assertEquals(excpectedString.toString(),string);
    }


    @Test
    public void renderBasic2Sok() throws Exception{
        String string = "";
        try {
            Tile[][] board = sokobanParser.parse("levels/basic2.sok");
            string += rend.render(board);
        }catch(Exception e){
            assertTrue(false);
        }
        StringBuffer excpectedString = new StringBuffer();
        excpectedString.append("########\n");
        excpectedString.append("#      #\n");
        excpectedString.append("#  B  P#\n");
        excpectedString.append("###B   #\n");
        excpectedString.append("#   ####\n");
        excpectedString.append("#    GG#\n");
        excpectedString.append("########\n");
        assertEquals(excpectedString.toString(),string);
    }

    @Test(expected = RenderException.class)
    public void throwRenderExpection() throws RenderException{
        Tile[][] board = new Tile[1][1];
        board[0][0] = mock(Tile.class);
        when(board[0][0].toString()).thenReturn("R");
        rend.render(board);
    }
}
