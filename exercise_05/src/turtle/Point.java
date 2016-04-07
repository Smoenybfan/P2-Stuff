package turtle;

/**
 * The Point class models a point in a Cartesian coordinate system.
 * <p>
 * All points objects are immutable. The operations of the {@link Point}
 * class return new <code>Point</code> objects. They do modify the state
 * of the objects they are invoked on. 
 * 
 * @immutable
 */ 
public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Point increment(Point delta) {
		return new Point(getX() + delta.getX(), getY() + delta.getY());
	}
	
	public Point decrement(Point delta) {
		return increment(new Point(-delta.getX(), -delta.getY()));
	}

	public Point incrementX(int deltaX) {
		return increment(new Point(deltaX, 0));
	}
	
	public Point decrementX(int deltaX) {
		return decrement(new Point(deltaX, 0));
	}
	
	public Point incrementY(int deltaY) {
		return increment(new Point(0, deltaY));
	}
	
	public Point decrementY(int deltaY) {
		return decrement(new Point(0, deltaY));
	}
	
	public String toString() {
		return "["+getX()+","+getY()+"]";
	}
}	
