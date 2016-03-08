package snakes;

import java.util.ArrayList;
import java.util.Random;

public class WormholeEntrance extends Square {

	public WormholeEntrance(Game game, int position) {
		super(game, position);
	}

	public ISquare destination(){
		ArrayList<WormholeExit> Exits = WormholeExit.getExits();
		return Exits.get(randomInt(Exits.size()));

	}

	@Override
	public ISquare landHereOrGoHome(){
		if(!this.isOccupied()){
			return destination();
		}
		else{
			return game.firstSquare();
		}
	}

	private int randomInt(int range){  //returns a random int between 0 and range
		assert range >=0;
		Random random = new Random();
		return random.nextInt(range);
	}

}
