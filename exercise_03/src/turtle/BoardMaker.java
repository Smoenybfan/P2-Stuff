package turtle;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;

/**
 * Modifies a SIZExSIZE board.
 *
 * It holds a turtle which will be moved around on the board, the board
 * where it will be moved around and the SIZE which is the SIZE of the board.
 *
 * This Class Parses a turtleProgram, then executed it and leaves a red trail on the
 * board where the turtle was moved.
 *
 * This Class is used by the TurtleRenderer to parse and execute a turtleProgram
 *
 * invariant isn't needed because the board is an argument of
 * the turtle and the invariant of the turtle checks if the turtle is still
 * on the board and the SIZE is final.
 */

public class BoardMaker {
	private boolean[][] board;
	private final static int SIZE = 100;
	Turtle turtle;

	/**
	 * Parse the given turtle program and evaluate it. Render the trail as
	 * described in the problem description and return a SIZExSIZE board
	 * corresponding to the evaluated path.
	 *
	 * @param turtleProgram input program according to specification. may also contain invalid text!
	 * @return SIZExSIZE boolean board, where true values denote "red trail". Invalid commands will be ignored.
	 * @see CommandParser
	 */
	public boolean[][] makeBoardFrom(String turtleProgram) throws ParserException {
		initialBoard();
		CommandParser parser = new CommandParser(SIZE);
		ArrayList<Command> commands = parser.parse(turtleProgram);
		for(Command command : commands){
			turtle.move(command);
		}
		return board.clone();
	}

	/**
	 * Creates a new board and returns it. Sets the turtle in the center
	 * @return board, must be of size SIZExSIZE.
	 */
	public boolean[][] initialBoard() {
		board = new boolean[SIZE][SIZE];
		turtle = new Turtle(SIZE/2,SIZE/2,board);
		board[SIZE/2][SIZE/2] = true;
		return board.clone();
	}
}