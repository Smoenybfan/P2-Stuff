package sokoban;

public class Right implements Move {
    public void execute(Player player, Tile[][] board){
        player.moveRight(board);
    }
}
