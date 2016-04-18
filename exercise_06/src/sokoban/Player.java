package sokoban;

/**
 * The player is a special type of Tile
 * It holds the position which inherits from the Tile class
 */

public class Player extends Tile{
    Tile floor;

    public Player(int x, int y){
        super(x,y);
        floor= new Floor(x,y);
    }

    public String toString(){
        return "P";
    }

}