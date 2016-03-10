package snakes;

import java.util.ArrayList;
import java.util.List;

/**
 * Is the <code>Square</code> where a Player may be sent to if they enter a <code>WormholeEntrance</code>
 * The List <code>exits</code> is a static List that contains all the existing
 * <code>WormholeExit</code>s.
 *
 * @author David Bösiger
 * @author Simon Kafdader
 * @see WormholeEntrance
 * @see ISquare
 */
public class WormholeExit extends Square{

	private static List<WormholeExit> exits = new ArrayList<>();

	public WormholeExit(Game game, int position) {
		super(game, position);
		exits.add(this);
	}

	@Override
	public String toString() {
		return "[" + this.squareLabel() + this.player() + "]";
	}

	@Override
	protected String squareLabel() {
		return super.squareLabel() + " (WEx)";
	}

	/**
	 * @return all WormholeExits
     */
	public static List<WormholeExit> getExits(){
		return exits;
	}
}