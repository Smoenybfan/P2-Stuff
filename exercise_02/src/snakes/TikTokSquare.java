package snakes;

public class TikTokSquare extends Square {

	private int[] destination = new int[2];

	private boolean invariant(){
		return isValidTransport(destination[0]) && isValidTransport(destination[1]);
	}
	private boolean isValidTransport(int transport){
		return transport != 0 && game.isValidPosition(position + transport);
	}

	public TikTokSquare(Game game, int position, int destinationA, int destinationB) {
		super(game, position);
		assert isValidTransport(destinationA);
		assert isValidTransport(destinationB);
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
		return game.getSquare(position + nextDestination());
	}

	private int nextDestination(){
		int cache = destination[0];
		destination[0] = destination[1];
		destination[1] = cache;
		return cache; //so that you start with destinationA
	}
}