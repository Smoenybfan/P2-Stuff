package snakes;

public class TikTokSquare extends Square {

	public TikTokSquare(Game game, int position, int destinationA, int destinationB) {
		super(game, position);
	}

	@Override
	public String toString() {
		return "[" + this.squareLabel() + this.player() + "]";
	}

	@Override
	protected String squareLabel() {
		return super.squareLabel() + " (TikTok)";
	}
}