package sokoban;

/**
 * Created by daveb on 17.04.2016.
 */
public class Goal extends Tile {
    public Goal(int x, int y){
        super(x,y);
    }

    public String toString(){
        return "G";
    }
}
