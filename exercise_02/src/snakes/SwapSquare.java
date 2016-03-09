package snakes;

public class SwapSquare extends Square {

	public SwapSquare(Game game, int position) {
		super(game, position);
	}

	protected ISquare destination(){
		return game.getSquare(game.currentPlayer().position()); //this is actually the next Player
	}

	@Override
	public ISquare landHereOrGoHome(){
		ISquare destination = this.destination();
		game.currentPlayer().jumpTo(this);
		return destination;
	}

	@Override
	public String toString() {
		return "[" + this.squareLabel() + this.player() + "]";
	}

	@Override
	protected String squareLabel() {
		return super.squareLabel() + " (Swap)";
	}

}