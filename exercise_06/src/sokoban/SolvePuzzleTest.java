package sokoban;

import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JExample.class)
public class SolvePuzzleTest {
    Game game;

    @Test
    public void solveBasic1(){
        game = new Game("levels/basic1.sok");
        StringBuffer program = new StringBuffer();
        program.append("right,right,right,");
        program.append("down,down,");
        program.append("left,");
        program.append("up,");
        program.append("right,");
        program.append("up,");
        program.append("up,");
        program.append("left,left,");
        program.append("down,");
        program.append("right,right,");
        program.append("up,");
        program.append("right,");
        program.append("down,down");
        try {
            game.run(program.toString());
        }catch(RenderException e){
            assertTrue(false);
        }
        assertTrue(!game.notOver());

    }
}
