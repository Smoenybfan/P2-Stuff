package sokoban;

import java.io.IOException;

/**
 * The Game class handles the game flow
 * It holds a Borad of Tiles, and a Player
 */

public class Game{
    Tile[][] board;
    Player player;

    /**
     * @param path path to the file which contains the board
     */
    private Game(String path){
        try{
            board = new Parser().parse(path);
            player = getPlayer();}
        catch(Exception e){
            System.out.println("Could not load level!");
            if(e.getClass().equals(java.io.FileNotFoundException.class)){
                System.out.println("File not found!");
            }
            if(e.getClass().equals(IOException.class)){
                System.out.println("Could not read from the file " + path);
            }
            if(e.getClass().equals(NumberFormatException.class)){
                System.out.println("Either height or width could not be parsed!");
            }
            if(e.getClass().equals(InvalidSizeException.class)){
                System.out.println("Either height or width was 0!");
            }
            if(e.getClass().equals(MultiplePlayerException.class)){
                System.out.println("There is more than one Player!");
            }
            if(e.getClass().equals(BoxGoalException.class)){
                System.out.println("There aren't as much Boxes as Goals!");
            }
            if(e.getClass().equals(IndexOutOfBoundsException.class)){
                System.out.println("The height or the width isn't correct");
            }
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
        }catch(RenderException e){
            System.out.println("Could not render board!");
        }
    }

    private void run() throws RenderException{
        Renderer rend = new Renderer();
        do {
            System.out.print(rend.render(board));
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