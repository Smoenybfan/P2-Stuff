package snakes;

/**
 * The interface for the Square Class and all its special types
 *
 * @author David Bösiger
 * @author Simon Kafdader
 */

public interface ISquare {

	/**
	 * Returns the position on the board of a Square
	 *
	 * @return the position of the Square
     */
	public int position();

	/**
	 *  moves the Player forward on the board with the amount moves.
	 *
	 * @param moves the amount of Squares the Player moves forward
	 *              must be bigger or equal to zero
	 * @return	the <code>ISquare</code> the Player lands on
     */
	public ISquare moveAndLand(int moves);

	/**
	 * Chekcks if a Square is the first on the board
	 *
	 * @return <code>true</code> if the Square is the first Square on the Board
	 * 		   <code>false</code> otherwise
     */
	public boolean isFirstSquare();

	/**
	 * Checks if a Square is the last on the board
	 *
	 * @return <code>true</code> if the Square is the last Square on the Board
	 * 		   <code>false</code> otherwise
     */
	public boolean isLastSquare();

	/**
	 * Sets the player that landed on this Square to its player.
	 * Mustn't hold another player
	 *
	 * @param player the player that lands on the square
     */
	public void enter(Player player);

	/**
	 * Removes the player that leaves this square as its player.
	 * Must hold a Player
	 *
	 * @param player the Player that leaves the square
     */
	public void leave(Player player);

	/**
	 * Checks if a Square holds a player
	 *
	 * @return <code>true</code> if it holds a player
	 * 		   <code>false</code> otherwise
     */
	public boolean isOccupied();

	/**
	 * Checks if the player that landed on the square can enter it or
	 * if he has to leave it and move to another square
	 *
	 * @return the Square the player can enter
     */
	public ISquare landHereOrGoHome();
}
