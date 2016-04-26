package sokoban.Moves;

import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;

public class Right implements Move {
    public void execute(Player player, Tile[][] board){
        player.moveRight(board);
    }
    public String toString(){
        return"Right Move";
    }
}
