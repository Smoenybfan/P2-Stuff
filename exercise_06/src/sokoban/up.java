package sokoban;

public class Up implements Move{
    public void execute(Player player, Tile[][] board){
           player.moveUp(board);
    }
}
