package sokoban;

/**
 * A Goal is a special type of Tile
 * It holds the position which inherits from the Tile class
 */

public class Goal extends Tile {
    public Goal(int x, int y){
        super(x,y);
    }

    public String toString(){
        return "G";
    }
}
