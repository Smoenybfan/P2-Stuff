package sokoban;

/**
 * The Game class handles the game flow
 * It holds a Borad of Tiles, and a Player
 */

public class Game{
    Tile[][] board;
    Player player;

    /**
     * @param path to the file which contains the board
     */
    private Game(String path){
        try{
            board = new Parser().parse(path);
            player = getPlayer();}
        catch(Exception e){
            System.out.println("Could not load level");
        }
    }

    private Player getPlayer(){
        assert board != null;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j].toString().equals("P")){
                    return (Player) board[i][j];
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        Game game = new Game("levels/basic1.sok");
        game.run();
    }

    private void run(){
        do {

        }while(notOver());
    }

    private boolean notOver(){
        return false;
    }




}