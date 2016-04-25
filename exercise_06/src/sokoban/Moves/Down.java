package sokoban.Moves;

import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;

public class Down implements Move {
    public void execute(Player player, Tile[][] board){
        player.moveDown(board);
    }
    public String toString(){return "Down Move";}
}
