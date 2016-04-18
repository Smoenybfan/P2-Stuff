package sokoban;


public class Box extends Tile {
    Tile floor;

    public Box(int x, int y){
        super(x,y);
        floor = new Floor(x,y);
    }

    public String toString(){
        return "B";
    }

    public boolean match(){
        return floor.toString().equals("G");
    }
}
