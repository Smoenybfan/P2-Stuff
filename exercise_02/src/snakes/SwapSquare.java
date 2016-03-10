package snakes;

/**
 * If a Player enters this <code>Square</code>, he swaps
 * place with the player whos next
 *
 * @author David Bösiger
 * @author Simon Kafader
 * @see ISquare
 */
public class SwapSquare extends Square {

	public SwapSquare(Game game, int position) {
		super(game, position);
	}

	protected ISquare destination(){
		return game.getSquare(game.currentPlayer().position());
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