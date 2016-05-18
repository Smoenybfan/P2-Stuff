package sokoban.GameObjects;

/**
 * A Wall is a special type of Tile
 * It holds the position which inherits from the Tile class
 *
 * As a Tile a Wall is Stored in a Tile[][] array which represents the board of a game
 * It is used in the class SokobanParser to create the board and by the class Game which
 * then modifies it.
 *
 * This class should only be used by the SokobanParser Class and the Game Class.
 *
 * Since the only public method only returns a String it doesn't need to be tested.
 */

public class Wall extends Tile {
    public Wall(int y, int x){
        super(y,x);
    }

    public String toString(){
        return "#";
    }
}
