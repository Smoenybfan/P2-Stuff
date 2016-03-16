package turtle;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;

public class BoardMaker {
	private boolean[][] board;
	private final static int SIZE = 100;
	private int xPosition;
	private int yPosition;
	private ArrayList<String[]> commands;

	/**
	 * Parse the given turtle program and evaluate it. Render the trail as
	 * described in the problem description and return a SIZExSIZE board
	 * corresponding to the evaluated path.
	 *
	 * @param turtleProgram input program according to specification. may also contain invalid text!
	 * @return SIZExSIZE boolean board, where true values denote "red trail".
	 */
	public boolean[][] makeBoardFrom(String turtleProgram) throws ParserException {

		// TODO: Read text below!
		// You should handle parsing of the program in a different class.
		// That class should create and store individual programs, which
		// can then be executed.
		//
		// An example of how this method could be implemented follows.
		// Please note that this is not real Java code; you will have
		// to come up with your own classes and structures!
		/*
		// You can create a new board each time makeBoardFrom is called.
		boolean[][] board = new boolean[SIZE][SIZE];

		// Create a parser that accepts a program and creates individual
		// programs.
		CommandParser parser = new CommandParser();
		parser.parse(turtleProgram);

		// Iterate over the parsed commands and keep track of the turtle.
		for each parsed command {
			execute the command on the board and update the state of the turtle
		}
		*/
		this.board = initialBoard();
		CommandParser parser = new CommandParser(SIZE);
		commands = parser.parse(turtleProgram);
		for(String[] command : commands){
			move(command);
		}
		return board;
	}

	/**
	 * Create a new board and return it. Sets the turtle in the center
	 * @return board, must be of size SIZExSIZE.
	 */
	public boolean[][] initialBoard() {
		board = new boolean[SIZE][SIZE];
		xPosition = SIZE/2;
		yPosition = SIZE/2;
		board[xPosition][yPosition] = true;
		return board;
	}

	public void move(String[] command){

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
	 * Helper Method that marks the way of the turtle and moves it up
	 */
	private void moveUp(int n) {
		assert yPosition - n > 0;
		for (int i = 1; i <= n; i++) {
			board[xPosition][yPosition - i] = true;
		}
		yPosition -= n;
	}

	/**
	 * Helper method that marks the way of the turtle and moves it right
	 */
	private void moveRight(int n) {
		assert xPosition + n < SIZE;
		for (int i = 1; i <= n; i++) {
			board[xPosition + i][yPosition] = true;
		}
		xPosition += n;
	}

	/**
	 * Helper method that marks the way of the turtle and moves it down
	 */

	private void moveDown(int n) {
		assert  yPosition + n < SIZE;
		for (int i = 1; i <= n ; i++) {
			board[xPosition][yPosition + i] = true;
		}
		yPosition += n;
	}

	/**
	 * Helper method that marks the way of the turtle and moves it left
	 */

	private void moveLeft(int n) {
		assert  xPosition - n > 0;
		for (int i = 1; i <= n ; i++) {
			board[xPosition - i][yPosition] = true;
		}
		xPosition -= n;
	}

	/**
	 * Helper method that jumps the turtle and marks the new position.
	 */

	private void moveJump(int x, int y){
		assert  x > 0 && x < SIZE && y > 0 && y < SIZE;
		board[x][y]=true;
		xPosition = x;
		yPosition = y;
	}

	private boolean invariant(){
		return xPosition > 0 && xPosition < SIZE && yPosition > 0 && yPosition < SIZE;
	}
}