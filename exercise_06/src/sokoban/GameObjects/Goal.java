package sokoban.GameObjects;

/**
 * A Goal is a special type of Tile
 * It holds the position which inherits from the Tile class
 *
 * As a Tile a Goal is Stored in a Tile[][] array which represents the board of a game
 * It is used in the class Parser to create the board and by the class Game which
 * then modifies it.
 *
 * This class should only be used by the Parser Class and the Game Class.
 *
 * Since the only public method only returns a String it doesn't need to be tested.
 */

public class Goal extends Tile {
    public Goal(int y, int x){
        super(y,x);
    }

    @Override
    public String toString(){
        return "G";
    }
}
