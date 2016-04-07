package turtle;

import java.awt.Color;

/**
 * The {@link Turtle} class models a turtle object that can move across a board.
 * <p>
 * A turtle object can move across the board by executing commands.
 * The turtle knows its current position on the board. Every command will
 * move the turtle from its current position to a new position, that will 
 * become the current position. 
 */
public class Turtle {
	public static final Color DEFAULT_COLOR = new Color(0xFF0000);
	
	private Point location;
	private Board board;
	
	private Color color = DEFAULT_COLOR;
	
	protected boolean invariant() {
		return board != null && board.checkCoordinates(location);
	}
	
	/**
	 * Create a new turtle object, and place it on the given board.
	 * <p>
	 * The initial square of the turtle is marked as visited.
	 * 
	 * @param initialLocation The initial location of the turtle on the board.
	 *        Must not be <code>null</code>, and must be a valid point on the board.
	 * @param board The board on which to place the turtle.
	 *        Must not be <code>null</code>.
	 */
	public Turtle(Point initialLocation, Board board) {
		assert initialLocation != null && board != null && board.checkCoordinates(initialLocation);
		
		this.board = board;
		this.location = initialLocation;
		this.board.markLocation(this.location, color);
		
		assert invariant();
	}

	/**
	 * Execute the given command on this turtle object.
	 * 
	 * @param command A command to execute on this turtle object.
	 *        Must not be <code>null</code>.
	 * @throws PointOutOfBoardException if the turtle steps outside of the board. 
	 *         Any effects this command might have had on the turtle are reverted.
	 */
	public void executeCommand(Command command) throws PointOutOfBoardException {
		assert command != null;
		
		command.execute(this);
		
		assert invariant();
	}

	/**
	 * Moves the turtle up on the board by the given number of moves.
	 * <p>
	 * It also updates the new location of the turtle on the board.
	 * 
	 * @param moves The number of moves by which to move the turtle.
	 * 			    Must be a non negative integer.
	 * @throws PointOutOfBoardException if the turtle steps outside of the board.
	 *         Any effects this command might have had on the turtle are reverted.
	 */
	public void moveUp(int moves) throws PointOutOfBoardException {
		assert moves > -1;
		board.addVerticalTrace(location, -1 * moves, color);
		location = location.decrementY(moves);
		
		assert invariant();
	}
	
	/**
	 * Moves the turtle down on the board by the given number of moves.
	 * <p>
	 * It also updates the new location of the turtle on the board.
	 * 
	 * @param moves The number of moves by which to move the turtle.
	 *  			Must be a non negative integer.
	 * @throws PointOutOfBoardException if the turtle steps outside of the board. 
	 *         Any effects this command might have had on the turtle are reverted.
	 */
	public void moveDown(int moves) throws PointOutOfBoardException {
		assert moves > -1;
		board.addVerticalTrace(location, moves, color);
		location = location.incrementY(moves);
		
		assert invariant();
	}
	
	/**
	 * Moves the turtle to the left on the board by the given number of moves.
	 * <p>
	 * It also updates the new location of the turtle on the board.
	 * 
	 * @param moves The number of moves by which to move the turtle.
	 *  			Must be a non negative integer.
	 * @throws PointOutOfBoardException if the turtle steps outside of the board. 
	 *         Any effects this command might have had on the turtle are reverted.
	 */
	public void moveLeft(int moves) throws PointOutOfBoardException {
		assert moves > -1;
		board.addHorizontalTrace(location, -1 * moves, color);
		location = location.decrementX(moves);
		
		assert invariant();
	}
	
	/**
	 * Moves the turtle to the right on the board by the given number of moves.
	 * <p>
	 * It also updates the new location of the turtle on the board.
	 * 
	 * @param moves The number of moves by which to move the turtle.
	 *  			Must be a non negative integer.
	 * @throws PointOutOfBoardException if the turtle steps outside of the board. 
	 *         Any effects this command might have had on the turtle are reverted.
	 */
	public void moveRight(int moves) throws PointOutOfBoardException {
		assert moves > -1;
		board.addHorizontalTrace(location, moves, color);
		location = location.incrementX(moves);
		
		assert invariant();
	}
	
	/**
	 * Moves the turtle to the given coordinates on the board.
	 * <p>
	 * It also marks the location as visited by the turtle.
	 * 
	 * @param x The x coordinate of the location.
	 *  			Must be a non negative integer.
	 * @param y The y coordinate of the location.
	 *  			Must be a non negative integer.
	 * @throws PointOutOfBoardException if the turtle steps outside of the board. 
	 *         Any effects this command might have had on the turtle are reverted.
	 */
	public void moveTo(int x, int y) throws PointOutOfBoardException  {
		assert x > -1;
		assert y > -1;
		
		Point newLocation = new Point(x, y);
		board.markLocation(newLocation, color);
		location = newLocation;
		
		assert invariant();
	}
	
	/**
	 * Set the color used to mark the squares visited by the turtle.
	 * 
	 * @param color The color used to mark the squares visited by the turtle.
	 * 			Must not be <code>null</code>
	 */
	public void setColor(Color color) {
		assert color != null;
		
		this.color = color;
	}
}
