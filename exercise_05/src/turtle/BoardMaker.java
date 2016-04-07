package turtle;

/**
 * BoardMaker can create a {@link Board} and mark all the squares that
 * have been visited by the turtle based on a given program.
 * <p>
 * The format of the program is described by the {@link CommandParser} class.
 * To keep track of the squares currently visited by the turtle a {@link Board}
 * object is used. The size of the board is given by the attribute {@link #boardSize}.
 *
 * @see Board
 * @see CommandParser
 */
public class BoardMaker {
	private int boardSize;
	private Point initialLocation;
	private ProgramParser parser;
	
	/**
	 * Instantiate a new {@link BoardMaker} that used boards of size <code>boardSize</code>.
	 * 
	 * @param boardSize The size of the board that will be created by this {@link BoardMaker}.
	 *        Must be a positive integer.
	 * @param initialLocation The initial location of the turtle on the board.
	 *        Must not be <code>null</code>.
	 */
	public BoardMaker(int boardSize, Point initialLocation) {
		assert boardSize > 0 && initialLocation != null;
		
		this.boardSize = boardSize;
		this.initialLocation = initialLocation;
		this.parser = new ProgramParser();
		
		assert invariant();
	}
	
	private boolean invariant() {
		return boardSize > 0 && parser != null && initialLocation != null;
	}
	
	/**
	 * Creates a new board and initializes it according to the given program.
	 * <p>
	 * The initial square of the turtle is marked as visited. Then all the
	 * squares visited by the turtle according to the supplied program are
	 * marked as visited by the turtle. 
	 * 
	 * @param turtleProgram A set of commands that describe the movement of the turtle.
	 *        Must not be <code>null</code>. The format of the command is specified by
	 *        the {@link CommandParser} class.
	 * 			
	 * @return A square matrix in which all the pixels visited by the turtle are
	 *  	<code>marked</code> and all the other squares <code>not marked</code>.
	 *         
	 * @see CommandParser
	 * @see Board
	 */
	public Pixel[][] makeBoardFrom(String turtleProgram) throws PointOutOfBoardException {
		assert turtleProgram != null;
		
		Board board = new Board(boardSize);
		Turtle turtle = new Turtle(initialLocation, board);
		
		for (Token token : parser.tokenizeProgram(turtleProgram)) {
			turtle.executeCommand(Commands.createCommand(token));
		}
		
		assert invariant();
		
		return board.rawBoard();
	}

	/**
	 * Creates an new board and marks the initial position of the turtle on that board.
	 * <p>
	 * It is not necessary to call {@link #initialBoard()} before {@link #makeBoardFrom(String)}.
	 * Any call to {@link #makeBoardFrom(String)} will also mark the initial square of
	 * the turtle as visited.
	 * 
	 * @return A square matrix, in which the initial position of the turtle is marked.
	 * 			All the other squares are not marked.
	 */
	public Pixel[][] initialBoard() {
		Board board = new Board(boardSize);
		board.markLocation(initialLocation, Turtle.DEFAULT_COLOR);
		return board.rawBoard();
	}
}
