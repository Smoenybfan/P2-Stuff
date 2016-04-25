package sokoban.Moves;

import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;

public class Left implements Move {
    public void execute(Player player, Tile[][] board){
        player.moveLeft(board);
    }
    public String toString(){
        return"Left Move";
    }
}
