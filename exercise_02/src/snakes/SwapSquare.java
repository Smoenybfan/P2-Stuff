package snakes;

public class SwapSquare extends Square {

	public SwapSquare(Game game, int position) {
		super(game, position);
	}

	protected ISquare destination(){
		return game.getSquare(game.currentPlayer().position()); //currentPlayer() is acutally the next player
	}

	@Override
	public ISquare landHereOrGoHome(){
		if(!this.isOccupied()){
			ISquare destination = destination();
			destination.leave(game.currentPlayer());
			this.enter(game.currentPlayer());
			return destination;
		}
		else{
			return game.firstSquare();
		}
	}
}