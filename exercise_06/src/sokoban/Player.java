package sokoban;

/**
 * The player is a special type of Tile
 * It holds the position which inherits from the Tile class
 * and a floor Tile, which is the Tile where the player is currently on (Which is either a Floor or a Goal)
 *
 * As a Tile the Player is Stored in a Tile[][] array which represents the board of the game
 * It is used in the class Parser to create the board and by the class Game which
 * then modifies it.
 *
 * The Player is capable of moving around. He can move around as long as there is a free Floor or Goal next to him
 * (Moves are horizontal and vertical). If Box is next to him he can move and move the Box as long as there is
 * space to do so. If there's a Wall he can't move.
 */

public class Player extends Box{
    private Tile floor;

    public Player(int x, int y){
        super(x,y);
        floor= new Floor(x,y);
    }

    public void move(Move move, Tile[][] board){
        move.execute(this,board);
    }

    public String toString(){
        return "P";
    }

    public Tile getFloor(){
        return this.floor;
    }

    public void setFloor(Tile tile){
        this.floor = tile;
    }

}