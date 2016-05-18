package sokoban.GameObjects;

/**
 * A Floor is a special type of Tile
 * It holds the position which inherits from the Tile class
 *
 * As a Tile a Floor is Stored in a Tile[][] array which represents the board of a game
 * It is used in the class SokobanParser to create the board and by the class Game which
 * then modifies it.
 *
 * This class should only be used by the SokobanParser Class and the Game Class.
 *
 * Since the only public method only returns a String it doesn't need to be tested.
 */

public class Floor extends GroundLocator{

    public Floor(int y, int x){
        super(y,x);
    }

    @Override
    public String toString(){
        return " ";
    }
}
