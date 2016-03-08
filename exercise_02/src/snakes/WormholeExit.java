package snakes;

import java.util.ArrayList;

public class WormholeExit extends Square {

	private static ArrayList<WormholeExit> Exits;

	public WormholeExit(Game game, int position) {
		super(game, position);
		Exits.add(this);
	}

	public static ArrayList getExits(){
		return Exits;
	}

}