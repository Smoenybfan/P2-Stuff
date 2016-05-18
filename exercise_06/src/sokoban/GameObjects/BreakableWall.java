package sokoban.GameObjects;

/**
 * A BreakableWall is a special type of Tile
 * It holds the position which inherits from the Tile class
 *
 * As a Tile a BreakableWall is Stored in a Tile[][] array which represents the board of a game
 * It is used in the class SokobanParser to create the board and by the classes Game and Bomb which
 * then modifies it.
 *
 * This class should only be used by the SokobanParser Class, the Bomb Class and the Game Class.
 *
 * Since the only public method only returns a String it doesn't need to be tested.
 */

public class BreakableWall extends Wall {

    public BreakableWall(int y, int x){
        super(y,x);
    }

    @Override
    public String toString(){
        return "X";
    }
}
