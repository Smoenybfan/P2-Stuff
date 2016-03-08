package snakes;

public class TikTokSquare extends Square {

	private int[] destination = new int[2];

	private boolean invariant(){
		return isValidDestination(destination[0]) && isValidDestination(destination[1]);
	}
	private boolean isValidDestination(int destination){
		return destination > 1 && game.isValidPosition(destination);
	}

	public TikTokSquare(Game game, int position, int destinationA, int destinationB) {
		super(game, position);
		assert isValidDestination(destinationA);
		assert isValidDestination(destinationB);
		this.destination[0] = destinationA;
		this.destination[1] = destinationB;
		assert invariant();
	}

	@Override
	public String toString() {
		return "[" + this.squareLabel() + this.player() + "]";
	}

	@Override
	protected String squareLabel() {
		return super.squareLabel() + " (TikTok)";
	}

	@Override
	public ISquare landHereOrGoHome(){
		return this.destination().landHereOrGoHome();
	}

	protected ISquare destination(){
		return game.getSquare(nextDestination());
	}

	private int nextDestination(){
		int cache = destination[0];
		destination[0] = destination[1];
		destination[1] = cache;
		return cache; //so that you start with destinationA
	}
}