package turtle;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;

/**
 * Modifies a SIZExSIZE board.
 *
 * The user has to ensure that <code>xPosition</code> and <code>yPosition</code>
 * are always smaller than the <code>SIZE</code>
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
	 * @return SIZExSIZE boolean board, where true values denote "red trail". Invalid commands will be ignored.
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
		return board.clone();
	}

	/**
	 * Creates a new board and returns it. Sets the turtle in the center
	 * @return board, must be of size SIZExSIZE.
	 */
	public boolean[][] initialBoard() {
		assert invariant();
		board = new boolean[SIZE][SIZE];
		xPosition = SIZE/2;
		yPosition = SIZE/2;
		board[xPosition][yPosition] = true;
		assert invariant();
		return board.clone();
	}

	/**
	 * Executes the given command
	 *
	 * @param command the first element has to be one of the commands left, right, up, down or jump
	 *                if the command is jump the size of <code>command</code> has to be 3
	 *                else it has to be 2
     */
	private void move(String[] command){
		switch (command[0]){
			default: assert false;
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
	 * @param n has to be small enough, so that destination after the move is still on the board
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
	 * @param n has to be small enough, so that destination after the move is still on the board
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
	 * @param n has to be small enough, so that the turtle doesn't leave the board
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
	 * @param n has to be small enough, so that destination after the move is still on the board
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
	 * @param x has to be smaller than the SIZE of the board
	 * @param y has to be smaller than the SIZE of the board
	 */
	private void moveJump(int x, int y){
		assert  x > 0 && x < SIZE && y > 0 && y < SIZE;
		board[x][y]=true;
		xPosition = x;
		yPosition = y;
	}

	/**
	 * @return if the position of the turtle is on the board
     */
	private boolean invariant(){
		return xPosition > 0 && xPosition < SIZE && yPosition > 0 && yPosition < SIZE;
	}
}