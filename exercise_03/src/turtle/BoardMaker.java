package turtle;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;

/**
 * Creates a Board according to a given turtle program
 *
 * The invariant checks if the <code>xPosition</code> and the <code>yPosition</code> are valid
 */

public class BoardMaker {
	private boolean[][] board;
	private final static int SIZE = 100;
	private int xPosition = 1;
	private int yPosition = 1;

	/**
	 * Parse the given turtle program and evaluate it. Render the trail as
	 * described in the problem description and return a SIZExSIZE board
	 * corresponding to the evaluated path.
	 *
	 * @param turtleProgram input program according to specification. may also contain invalid text!
	 * @return SIZExSIZE boolean board, where true values denote "red trail".
	 * @see CommandParser
	 */
	public boolean[][] makeBoardFrom(String turtleProgram) throws ParserException {

		this.board = initialBoard();
		CommandParser parser = new CommandParser(SIZE);
		ArrayList<String[]> commands = parser.parse(turtleProgram);
		for(String[] command : commands){
			move(command);
		}
		assert invariant();
		return board;
	}

	/**
	 * Create a new board and return it. Sets the turtle in the center
	 * @return board, must be of size SIZExSIZE.
	 */
	public boolean[][] initialBoard() {
		assert invariant();
		board = new boolean[SIZE][SIZE];
		xPosition = SIZE/2;
		yPosition = SIZE/2;
		board[xPosition][yPosition] = true;
		assert invariant();
		return board;
	}

	/**
	 * Executes the given command
	 * asserts if the first argument of the <code>command</code>
	 * asserts if the <code>command</code> has the correct length
	 *
	 * @param command the executed command
     */
	private void move(String[] command){
		assert command[0] == "right" || command[0] =="left" || command[0] == "down" || command[0] == "up"
									|| command[0] == "jump";
		switch (command[0]){
			case "right":	assert command.length == 2;
				moveRight(Integer.parseInt(command[1]));
				break;
			case "left":    assert command.length == 2;
				moveLeft(Integer.parseInt(command[1]));
				break;
			case "down":    assert command.length == 2;
				moveDown(Integer.parseInt(command[1]));
				break;
			case "up":      assert command.length == 2;
				moveUp(Integer.parseInt(command[1]));
				break;
			case "jump":    assert command.length == 3;
				moveJump(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				break;
		}
	}

	/**
	 * Executes the up command
	 * asserts if the destination is on the board
	 */
	private void moveUp(int n) {
		assert yPosition - n > 0;
		for (int i = 1; i <= n; i++) {
			board[xPosition][yPosition - i] = true;
		}
		yPosition -= n;
	}

	/**
	 * Executes the right command
	 * asserts if the destination is on the board
	 */
	private void moveRight(int n) {
		assert xPosition + n < SIZE;
		for (int i = 1; i <= n; i++) {
			board[xPosition + i][yPosition] = true;
		}
		xPosition += n;
	}

	/**
	 * Executes the down command
	 * asserts if the destination is on the board
	 */
	private void moveDown(int n) {
		assert  yPosition + n < SIZE;
		for (int i = 1; i <= n ; i++) {
			board[xPosition][yPosition + i] = true;
		}
		yPosition += n;
	}

	/**
	 * Executes the left command
	 * asserts if the destination is on the board
	 */
	private void moveLeft(int n) {
		assert  xPosition - n > 0;
		for (int i = 1; i <= n ; i++) {
			board[xPosition - i][yPosition] = true;
		}
		xPosition -= n;
	}

	/**
	 * Executes the jump command
	 * asserts if the destination is on the board
	 */
	private void moveJump(int x, int y){
		assert  x > 0 && x < SIZE && y > 0 && y < SIZE;
		board[x][y]=true;
		xPosition = x;
		yPosition = y;
	}

	/**
	 * @return if the position of the turtle is valid
     */
	private boolean invariant(){
		return xPosition > 0 && xPosition < SIZE && yPosition > 0 && yPosition < SIZE;
	}
}