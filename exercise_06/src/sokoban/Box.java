package sokoban;

/**
 * A Box is a special type of Tile
 * It holds the position which inherits from the Tile class
 * and a floor Tile, which is the Tile where the player is currently on
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
