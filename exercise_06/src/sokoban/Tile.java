package sokoban;

/**
 * A Tile holds the position on the board
 */

public class Tile{
    protected int[] position;

    public Tile(int x, int y){
        position = new int[2];
        position[0] = x;
        position[1] = y;
    }
}