package snakes;

import java.util.Random;

/**
 * If a Player enters this <code>Square</code> it sends him to a random <code>WormholeExit</code>
 *
 * @author David Bösiger
 * @author Simon Kafader
 * @see WormholeExit
 * @see ISquare
 */
public class WormholeEntrance extends Square {

	public WormholeEntrance(Game game, int position) {
		super(game, position);
	}

	/**
	 * @return a random WormholeExit
     */

	public ISquare destination(){
		return WormholeExit.getExits().get(randomInt(WormholeExit.getExits().size()));
	}

	@Override
	public ISquare landHereOrGoHome(){
		return destination();
	}

	@Override
	public String toString() {
		return "[" + this.squareLabel() + this.player() + "]";
	}

	@Override
	protected String squareLabel() {
		return super.squareLabel() + " (WEn)";
	}

	/**
	 * @param range the range of the random int
	 * @return a random int between 0 and range
     */
	private int randomInt(int range){
		assert range >=0;
		Random random = new Random();
		return random.nextInt(range);
	}

}
