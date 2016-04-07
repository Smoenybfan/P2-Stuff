package turtle;

public class PointOutOfBoardException extends RuntimeException{
	private static final long serialVersionUID = -655414815672387199L;
 
	public PointOutOfBoardException(Point point) {
		super("Point "+point+" out of the board");
	}
}
