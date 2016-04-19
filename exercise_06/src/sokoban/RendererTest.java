package sokoban;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RendererTest {
    private Parser parser;
    private Renderer rend;

    @Before
    public void setUp(){
        parser = new Parser();
        rend = new Renderer();
    }

    @Test
    public void renderBasic1Sok()throws Exception{
        Tile[][] board = parser.parse("levels/basic1.sok");
        String string = rend.render(board);
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
        Tile[][] board = parser.parse("levels/basic2.sok");
        String string = rend.render(board);
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
}
