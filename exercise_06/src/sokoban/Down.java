package sokoban;

public class Down implements Move {
    public void execute(Player player, Tile[][] board){
        player.moveDown(board);
    }
}
