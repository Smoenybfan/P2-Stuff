package sokoban.Moves;

import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;

public class Up implements Move {
    public void execute(Player player, Tile[][] board){
           player.moveUp(board);
    }
    public String toString(){
        return"Up Move";
    }
}
