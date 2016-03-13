package turtle;

import javax.swing.text.html.parser.Parser;

public class BoardMaker {
	private boolean[][] board;
	private final static int SIZE = 100;
	private int xPosition;
	private int yPosition;
	private String[] commands;

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

		CommandParser parser = new CommandParser(turtleProgram, xPosition, yPosition, board);
		try {
			commands= parser.parse();
			return move();
		}

		catch (Exception err){
			throw new ParserException();
		}

		// TODO: remove this and return a board instead

		//throw new UnsupportedOperationException();
	}

	/**
	 * Create a new board and return it. Sets the turtle in the center
	 * @return board, must be of size SIZExSIZE.
	 */
	public boolean[][] initialBoard() {
		// TODO: remove this and return a board instead
		board= new boolean[SIZE][SIZE];
		xPosition = SIZE/2;
		yPosition = SIZE/2;
		board[xPosition][yPosition]=true;
		return board;
	}

	public boolean[][] move(){

		switch (commands[0]){
			case "right":   moveRight();
				break;
			case "left":    moveLeft();
				break;
			case "down":    moveDown();
				break;
			case "up":      moveUp();
				break;
			case "jump":    moveJump();
				break;
		}

		return board;
	}

	/**
	 * Helper Method that marks the way of the turtle and moves it up
	 */
	private void moveUp() {
		assert commands.length == 2;
		for (int i = yPosition; i < Integer.parseInt( commands[1]); i++) {
			board[xPosition][i] = true;
		}
		yPosition+=Integer.parseInt( commands[1]);
	}

	/**
	 * Helper method that marks the way of the turtle and moves it right
	 */
	private void moveRight() {
		assert  commands.length == 2;
		for (int i = 1; i <= Integer.parseInt( commands[1]); i++) {
			board[xPosition+i][yPosition] = true;
		}
		xPosition+=Integer.parseInt( commands[1]);
	}

	/**
	 * Helper method that marks the way of the turtle and moves it down
	 */

	private void moveDown() {
		assert  commands.length == 2;
		for (int i = xPosition; i < Integer.parseInt( commands[1]); i--) {
			board[i][yPosition] = true;
		}
		yPosition-=Integer.parseInt( commands[1]);
	}

	/**
	 * Helper method that marks the way of the turtle and moves it left
	 */

	private void moveLeft() {
		assert  commands.length == 2;
		for (int i = xPosition; i < Integer.parseInt( commands[1]); i--) {
			board[i][yPosition] = true;
		}
		xPosition -= Integer.parseInt( commands[1]);
	}

	/**
	 * Helper method that jumps the turtle and marks the new position.
	 */

	private void moveJump(){
		assert  commands.length==3;
		board[Integer.parseInt( commands[1])][Integer.parseInt( commands[2])]=true;
		xPosition=Integer.parseInt( commands[1]);
		yPosition=Integer.parseInt( commands[2]);
	}
}