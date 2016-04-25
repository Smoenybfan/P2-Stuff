package sokoban;

/**
 * A BreakableWall is a special type of Tile
 * It holds the position which inherits from the Tile class
 *
 * As a Tile a BreakableWall is Stored in a Tile[][] array which represents the board of a game
 * It is used in the class Parser to create the board and by the classes Game and Bomb which
 * then modifies it.
 *
 * This class should only be used by the Parser Class, the Bomb Class and the Game Class.
 */

public class BreakableWall extends Wall {

    public BreakableWall(int y, int x){
        super(x,y);
    }

    @Override
    public String toString(){
        return "X";
    }
}
