package sokoban;

/**
 * The player is a special type of Tile
 * It holds the position which inherits from the Tile class
 * and a floor Tile, which is the Tile where the player is currently on
 */

public class Player extends Tile{
    Tile floor;

    public Player(int x, int y){
        super(x,y);
        floor= new Floor(x,y);
    }

    public void move(Tile[][] board){

    }

    public String toString(){
        return "P";
    }

}