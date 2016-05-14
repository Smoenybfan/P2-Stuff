package sokoban.Tests;

import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import sokoban.Game.Game;
import sokoban.Exceptions.RenderException;

import static org.junit.Assert.*;


@RunWith(JExample.class)
public class SolvePuzzleTest {
    Game game;

    /**
     * This is an integration Test
     * @throws RenderException
     */
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

    /**
     * This is an integration Test
     * @throws RenderException
     */
    @Test
    public void solveExtended1() throws RenderException{
        game = new Game("levels/extended1.sok");
        StringBuffer program = new StringBuffer();
        program.append("down,down,");
        program.append("right,right,right,right,right,right,");
        program.append("up,up,");
        program.append("left,left,left,left,");
        program.append("right,right,right,right,");
        program.append("down,down,");
        program.append("left,left,left,left,left,left,");
        program.append("up,up,up,");
        program.append("right,");
        program.append("down,down,down,");
        program.append("left,");
        program.append("down,");
        program.append("right,");
        program.append("up,");
        program.append("right,");
        program.append("down,");
        program.append("up,up,");
        program.append("left,");
        program.append("up,up,");
        program.append("right,right,right,right,");
        program.append("down,down,");
        program.append("right,");
        program.append("down,");
        program.append("left,left,left,");
        program.append("up,");
        program.append("left,");
        program.append("down,down,down,");
        program.append("right,");
        program.append("down,");
        program.append("left,");
        program.append("down,");
        program.append("left,");
        program.append("up,");

        program.append("right,");
        program.append("up,up,up,");
        program.append("left,");
        program.append("down,down,down,");
        program.append("left,");
        program.append("down,");
        program.append("right,right,right,right");

        game.run(program.toString());
        assertTrue(!game.notOver());
    }
}
