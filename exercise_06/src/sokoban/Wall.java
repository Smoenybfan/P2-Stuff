package sokoban;

/**
 * Created by daveb on 17.04.2016.
 */

public class Wall extends Tile {
    public Wall(int x, int y){
        super(x,y);
    }

    public String toString(){
        return "#";
    }
}
