package snakes;

/**
 * Not necessary to test since the only overwritten method only returns true.
 */

public class LastSquare extends Square {

	public LastSquare(Game game, int position) {
		super(game, position);
	}

	@Override
	public boolean isLastSquare() {
		return true;
	}
}
