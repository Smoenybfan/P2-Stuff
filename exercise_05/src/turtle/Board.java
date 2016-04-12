package turtle;

import java.awt.Color;

/**
 * Board models a square board made out of squares on which the turtle can move.
 * <p>
 * Each square is identified by an unique {@link Point} representing a point in
 * a cartesian coordinate system. The top left corner of the board is identified
 * by the coordinate (0, 0) and the bottom left corner by the coordinate (size, size),
 * where <code>size</code> is the parameter given to the constructor {@ Board#Board(int)}
 * <p>
 * Each square of the board can be in two states:
 * <ul>
 * 	<li><b>touched</b> by the turtle</li>
 *  <li><b>not touched</b> by the turtle</li>
 * </ul>
 * The turtle can touched the same square multiple times, but once a square 
 * is in the <b>touched</b> stated in cannot go back to the <b>not touched</b>
 * state. Initially all squares are in the <b>not touched</b> state.
 */

public class Board {
	private int size;
	private Pixel[][] board;
	
	protected boolean invariant() {
		return size > 0 && board != null && board.length == size && board[0].length == size;
	}
	
	/**
	 * Creates a new board of the given size and initializes it.
	 * <p>
	 * In the initial configuration of the board the turtle has not
	 * touched any square.
	 * 
	 * @param size the size of the board.
	 *        Must be an integer greater than zero.
	 */
	public Board(int size) {
		assert size > 0;
		
		this.size = size;
		this.board = new Pixel[size][size];
		
		for (Pixel[] y : board){
			for (int x = 0; x < y.length; x++){
				y[x] = new Pixel();
			}
		}
		
		assert invariant();
	}
	
	/**
	 * Verifies that <code>aPoint</code> refers to a valid square on the board.
	 * <p>
	 * A point refers to a valid square on the board, if it is inside 
	 * the board or on one of its edges.
	 * 
	 * @param aPoint the point for which the verification is done.
	 *        Must not be <code>null</code>.
	 * @return <code>true</code> if <code>aPoint</code> is valid,
	 *         or <code>false</code> otherwise
	 */
	public boolean checkCoordinates(Point aPoint) {
		assert aPoint != null;
		
		return (aPoint.getX() >= 0 && aPoint.getX() < size) && (aPoint.getY() >= 0 && aPoint.getY() < size);
	}

	/**
	 * Marks a horizontal set of squares as being touched by the turtle.
	 * <p>
	 * If the parameter <code>distance</code> is positive then it marks 
	 * a set of consecutive squares to the right of <code>start</code>, 
	 * of size <code>distance</code>. Otherwise, if <code>distance</code> 
	 * is negative then it marks a set of consecutive squares to the left 
	 * of <code>start</code>, of size <code>Math.abs(distance)</code>, 
	 * 
	 * @param start the point from where to start the trace.
	 *        The square at this position is not marked.
	 * @param distance the number of squares to mark as touched by the turtle
	 * @param color the with which to mark the point.
	 *        It must not be <code>null</code>
	 * @throws PointOutOfBoardException if a point that should be marked as
	 * 	       <b>touched</b> by the turtle is outside of the board.
	 */
	public void addHorizontalTrace(Point start, int distance, Color color) throws PointOutOfBoardException{
		assert start != null;
		assert color != null;
		
		if (!checkCoordinates(start.incrementX(distance))) {
			throw new PointOutOfBoardException(start.incrementX(distance));
		}
		
		int increment = distance <= 1 ? -1 : 1;
		for ( int stepIndex = 0; stepIndex <= Math.abs(distance); stepIndex++ ) {
			markPoint(start.incrementX(increment * stepIndex), color);
		}
	}
	
	/**
	 * Marks a vertical set of squares as being touched by the turtle.
	 * <p>
	 * If the parameter <code>distance</code> is positive then it marks 
	 * a set of consecutive squares directly bellow <code>start</code>, 
	 * of size <code>distance</code>. Otherwise, if <code>distance</code> 
	 * is negative then it marks a set of consecutive squares directly above 
	 * <code>start</code>, of size <code>Math.abs(distance)</code>, 
	 * 
	 * @param start the point from where to start the trace.
	 *        The square at this position is not marked.
	 * @param distance the number of squares to mark as touched by the turtle
	 * @param color the with which to mark the point.
	 *        It must not be <code>null</code>
	 * @throws PointOutOfBoardException if a point that should be marked as
	 * 	       <b>touched</b> by the turtle is outside of the board.
	 */
	public void addVerticalTrace(Point start, int distance, Color color) throws PointOutOfBoardException{
		assert start != null;
		assert color != null;
		
		if (!checkCoordinates(start.incrementY(distance))) {
			throw new PointOutOfBoardException(start.incrementY(distance));
		}
		
		int increment = distance <= 1 ? -1 : 1;
		for ( int stepIndex = 0; stepIndex <= Math.abs(distance); stepIndex++ ) {
			markPoint(start.incrementY(increment * stepIndex), color);
		}
	}
	
	/**
	 * Marks the given point as being touched by the turtle. 
	 * <p>
	 * If the given point is already touched by the turtle 
	 * it remains in this state.
	 * 
	 * @param point the point to mark as being touched by the turtle.
	 *        It must not be <code>null</code>
	 * @param color the with which to mark the point.
	 *        It must not be <code>null</code>
	 * @throws PointOutOfBoardException if the point that should be marked as
	 * 	       <b>touched</b> by the turtle is outside of the board.
	 */
	public void markLocation(Point point, Color color) {
		assert point != null;
		assert color != null;
		
		if (!checkCoordinates(point)) {
			throw new PointOutOfBoardException(point);
		}
		
		markPoint(point, color);
	}
	
	/**
	 * Marks the given point as being touched by the turtle. 
	 * <p>
	 * If the given point is already touched by the turtle 
	 * it remains in this state.
	 * 
	 * @param point the point to mark as being touched by the turtle.
	 *        It must not be <code>null</code>
	 * @param color the with which to mark the point.
	 *        It must not be <code>null</code>
	 */
	private void markPoint(Point point, Color color) {
		assert point != null;
		assert color != null;
		
		board[point.getX()][point.getY()].mark(color);
	}
	
	/**
	 * Returns a Pixel matrix representing the current state of the board. 
	 * <p>
	 * Each pixel of the matrix is <code>marked</code> if the corresponding square
	 * was touched by the turtle, or <code>not marked</code> if the corresponding square
	 * was not touched by the turtle.
	 * <p>
	 * Modifying the values of this matrix does not affect the board.
	 * 
	 * @return a pixel matrix representing the current state of the board
	 */
	public Pixel[][] rawBoard() {
		return board.clone();
	}

}
