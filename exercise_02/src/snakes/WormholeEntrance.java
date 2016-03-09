package snakes;

import java.util.ArrayList;
import java.util.Random;

public class WormholeEntrance extends Square {

	public WormholeEntrance(Game game, int position) {
		super(game, position);
	}

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

	private int randomInt(int range){  //returns a random int between 0 and range
		assert range >=0;
		Random random = new Random();
		return random.nextInt(range);
	}

}
