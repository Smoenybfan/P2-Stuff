package turtle;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertArrayEquals;

/**
 * This Test is there to Cover the Code of BoardMaker
 */
@RunWith(JExample.class)
public class BoardMakerTest {
    private BoardMaker boardMaker;
    private final int SIZE = 100;

    @Test
    public void newBoardMaker() {
        boardMaker = new BoardMaker();
        boolean[][] board = boardMaker.initialBoard();
        assertTrue(board != null);
        assertEquals(board.length, SIZE);
    }

    @Given("newBoardMaker")
    public void emptyProgram() throws ParserException{
        boolean[][] board = boardMaker.makeBoardFrom("");
        assertTrue(board[SIZE/2][SIZE/2]);
    }

    @Given("emptyProgram")
    public void moveLeftOverBoarder() throws ParserException{
        boolean[][] board = boardMaker.makeBoardFrom("left 55\n");
        for(int i = 0; i < SIZE/2; i++) {
            assertTrue(board[SIZE / 2 - i][SIZE / 2]);
        }
        for(int i = 1; i <= 55-SIZE/2; i++){
            assertTrue(board[SIZE - i][SIZE / 2]);
        }
    }

}
