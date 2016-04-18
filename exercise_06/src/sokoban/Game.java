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
            System.out.println("Could not load level!");
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
        Game game = new Game("levels/basic2.sok");
        try{
            game.run();
        }catch(Exception e){
            System.out.println("Could not render board!");
        }
    }

    private void run() throws Exception{
        Renderer rend = new Renderer();
        do {
            rend.render(board);
            int move = getMove();
            player.move(board);
        }while(notOver());
    }

    private boolean notOver(){
        return false;
    }

    private int getMove(){
        return 0;
    }




}