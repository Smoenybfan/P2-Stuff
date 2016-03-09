package snakes;

import java.util.ArrayList;
import java.util.List;

public class WormholeExit extends Square {

	public static List<WormholeExit> exits = new ArrayList<>();

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

	public static List<WormholeExit> getExits(){
		return exits;
	}

}