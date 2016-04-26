package snakes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
	private List<ISquare> squares;
	private int size;
	private Queue<Player> players;
	private Player winner;

	private boolean invariant() {
		return squares.size() > 3
				&& size == squares.size()
				&& players.size() > 1;
	}

	public Game(int size, Player[] initPlayers) {
		this.size = size;
		this.addSquares(size);
		this.addPlayers(initPlayers);
		assert invariant();
	}

	public boolean isValidPosition(int position) {
		return position>=1 && position<=size;
	}

	public static void main(String args[]) {
		//Add players
		Player jack = new Player("Jack");
		Player jill = new Player("Jill");
		Player roby = new Player("Roby");
		Player[] players ={jack,jill,roby};
		//Add Game
		Game game = new Game(15, players);
		//Add special Squares
		game.setSquareToWormholeEntrance(3);
		game.setSquareToWormholeExit(12);
		game.setSquareToLadder(5,7);
		game.setSquareToSnake(9,-2);
		game.setSquareToTikTok(4,13,2);
		game.setSquareToSwap(10);
		//Start game
		game.play(new Die());
	}

	public void play(IDie die) {
		System.out.println("Initial state: " + this);
		while (this.notOver()) {
			int roll = die.roll();
			System.out.println(this.currentPlayer() + " rolls " + roll + ":  " + this);
			this.movePlayer(roll);
		}
		System.out.println("Final state:   " + this);
		System.out.println(this.winner() + " wins!");
	}

	public boolean notOver() {
		return winner == null;
	}

	public boolean isOver() {
		return !this.notOver();
	}

	public Player currentPlayer() {
		return players.peek();
	}

	public void movePlayer(int roll) {
		assert roll>=1 && roll<=6;
		Player currentPlayer = players.remove(); // from front of queue
		currentPlayer.moveForward(roll);
		players.add(currentPlayer); // to back of the queue
		if (currentPlayer.wins()) {
			winner = currentPlayer;
		}
		assert invariant();
	}

	public void setSquare(int position, ISquare square) {
		// Do not change the type of the first or last square!
		assert !this.getSquare(position).isLastSquare()
				&& !this.getSquare(position).isFirstSquare();
		this.initSquare(position, square);
		assert invariant();
	}

	public Player winner() {
		return winner;
	}

	public ISquare firstSquare() {
		return squares.get(0);
	}

	public ISquare getSquare(int position) {
		assert this.isValidPosition(position);
		return squares.get(position - 1);
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (ISquare square : squares) {
			buffer.append(square.toString());
		}
		return buffer.toString();
	}

	private void addSquares(int size) {
		squares = new ArrayList<>();
		for(int i=0; i<size; i++) {
			Square square = new Square(this, i+1);
			squares.add(square);
		}
		this.initSquare(1, new FirstSquare(this, 1));
		this.initSquare(size, new LastSquare(this, size));
	}

	private void addPlayers(Player[] initPlayers) {
		players = new LinkedList<>();
		for (Player player : initPlayers) {
			player.joinGame(this);
			players.add(player);
		}
	}

	private void initSquare(int position, ISquare square) {
		assert this.isValidPosition(position) && square != null;
		squares.set(position-1, square);
	}

	public void setSquareToLadder(int position, int transport) {
		this.setSquare(position, new Ladder(transport, this, position));
	}

	public void setSquareToSnake(int position, int transport) {
		this.setSquare(position, new Snake(transport, this, position));
	}

	public void setSquareToTikTok(int position, int destinationA, int destinationB){
		this.setSquare(position,new TikTokSquare(this, position, destinationA, destinationB));
	}

	public void setSquareToSwap(int position){
		this.setSquare(position, new SwapSquare(this, position));
	}

	public void setSquareToWormholeEntrance(int position){
		this.setSquare(position, new WormholeEntrance(this, position));
	}

	public void setSquareToWormholeExit(int position){
		this.setSquare(position, new WormholeExit(this, position));
	}

	public ISquare findSquare(int position, int moves) {
		assert position + moves <= 2*size - 1; // can't go more than size-1 moves backwards past end
		int target = position + moves;
		if (target > size) { // reverse direction if we go past the end
			target = size - (target - size);
		}
		return this.getSquare(target);
	}

}