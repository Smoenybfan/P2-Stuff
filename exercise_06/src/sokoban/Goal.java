package sokoban;

/**
 * A Goal is a special type of Tile
 * It holds the position which inherits from the Tile class
 *
 * As a Tile a Goal is Stored in a Tile[][] array which represents the board of a game
 * It is used in the class Parser to create the board and by the class Game which
 * then modifies it.
 *
 * This class should only be used by the Parser Class and the Game Class.
 */

public class Goal extends Tile {
    public Goal(int x, int y){
        super(x,y);
    }

    public String toString(){
        return "G";
    }
}
