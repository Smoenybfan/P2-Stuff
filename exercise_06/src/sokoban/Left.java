package sokoban;

public class Left implements Move {
    public void execute(Player player, Tile[][] board){
        player.moveLeft(board);
    }
}
