package sokoban.Tests;

import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import sokoban.Game.Game;
import sokoban.Exceptions.RenderException;

import static org.junit.Assert.*;

/**
 * This is an integration Test
 */
@RunWith(JExample.class)
public class SolvePuzzleTest {
    Game game;

    @Test
    public void solveBasic1() throws RenderException{
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

        game.run(program.toString());
        assertTrue(!game.notOver());
    }
}
