package sokoban;

/**
 * A Tile holds the position on the board
 */

public class Tile{
    protected int[] position;

    public Tile(int y, int x){
        position = new int[2];
        position[0] = y;
        position[1] = x;
    }

    public boolean equals(Object object){
        if(object == null) return false;
        if(!Tile.class.isAssignableFrom(object.getClass())) return false;
        final Tile tile = (Tile) object;
        if(tile.position[0] != this.position[0]) return false;
        if(tile.position[1] != this.position[1]) return false;
        return object.getClass().equals(this.getClass());
    }
}