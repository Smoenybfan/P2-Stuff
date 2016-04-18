package sokoban;

/**
 * A Box is a special type of Tile
 * It holds the position which inherits from the Tile class
 * and a floor Tile, which is the Tile where the player is currently on (Could be either a Floor o a Goal)
 *
 * As a Tile a Box is Stored in a Tile[][] array which represents the board of the game
 * It is used in the class Parser to create the board and by the class Game which
 * then modifies it.
 *
 * A Box has a match method which will return if the Box is on a Goal.
 */

public class Box extends Tile {
    Tile floor;

    public Box(int x, int y){
        super(x,y);
        floor = new Floor(x,y);
    }

    public String toString(){
        return "B";
    }

    /**
     * @return true when the box is on a goal
     */
    public boolean match(){
        return floor.toString().equals("G");
    }
}
