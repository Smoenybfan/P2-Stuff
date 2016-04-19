package sokoban;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Game class handles the game flow
 * It holds a Borad of Tiles, a Player and a List of every Box
 *
 * With a came you can either play a level interactively or you can
 * play by giving an input Program as String where the commands are separated by a "."
 *
 * This class is used in the GameDriver to initialize and run the Game;
 *
 * To use this class you have to first make an instance of it
 * and the call the run method. You can also inherit from it and implement you own run method
 * e.g. to make it interactive
 *
 * If you want to run a scripted Game you simply call the method run with the moves you
 * want to make, separated by a comma as a String
 * There are four moves: "up","down","right" and "left"
 *
 * A very specified ExceptionHandling is implemented in the Constructor while you read and
 * parse the level from the file, so you get a detailed feedback what went wrong
 * Still there are two uncaught Exceptions in the run method which are a RenderException
 * it the Rendering fails or a IOException if something with the input on the console went wrong
 *
 * Note that there is a method IsInitializes() to check whether or not the Game is initialized,
 * because even if the Game gets an Exception during the parsing of the filed it will
 * be instanced.
 */

public class Game{
    private Tile[][] board;
    protected Player player;
    private ArrayList<Box> boxes;

    /**
     * @param path path to the file which contains the board
     */
    public Game(String path){
        try{
            board = new Parser().parse(path);
            player = getPlayer();
            getBoxes();
        }
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
        boxes = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j].toString().equals("P")){
                    return (Player) board[i][j];
                }
            }
        }
        return null;
    }

    private void getBoxes(){
        assert board != null;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j].toString().equals("B")){
                    boxes.add((Box) board[i][j]);
                }
            }
        }
    }

    /**
     * This method contains the game-flow for a scripted game
     * @throws RenderException if the board couldn't been rendered
     */
    public void run(String program) throws Exception{
        Renderer rend = new Renderer();
        ArrayList<Move> moves = parseProgram(program);
        Iterator<Move> it = moves.iterator();
        while(it.hasNext()){
            System.out.print(rend.render(board));
            Move move = it.next();
            player.move(move,board);
            if(!notOver()){
                System.out.print(rend.render(board));
                System.out.println("Finished, " + "" +"moves left.");
                return;
            }
        }
        System.out.print(rend.render(board));
        System.out.println("Puzzle not solved!");
    }

    /**
     * All commands that doesn't fit to: "up","down","right","left" ,will just be left out
     * @param program a program where the commands are sperated by a .
     * @return a ArrayList which contains the corresponding Moves
     */
    private ArrayList<Move> parseProgram(String program){
        ArrayList<Move> moves = new ArrayList<>();
        if(program == null) return moves;
        String[] commands = program.split(",");
        for(String c: commands){
            switch(c){
                default: break;
                case "up": moves.add(new Up()); break;
                case "down": moves.add(new Down()); break;
                case "right": moves.add(new Right()); break;
                case "left": moves.add(new Left()); break;
            }
        }
        return moves;
    }

    protected boolean notOver(){
        Iterator<Box> it = boxes.iterator();
        while(it.hasNext()){
            Box box = it.next();
            if(!box.match()) return true;
        }
        return false;
    }

    /**
     * This method takes an input from the command line and
     * parses it. You have to try until you get one of the following commands
     * "up", "down", "right", "left" right.
     * @return the corresponding move to the given input
     * @throws IOException if it couldn't read from the console
     */
    protected Move getMove() throws IOException{
        System.out.println("Where to go next: ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String command = bf.readLine();
            switch(command){
                default: System.out.println("Try again :"); break;
                case "up": return new Up();
                case "down": return new Down();
                case "right": return new Right();
                case "left": return new Left();
            }
        }
    }

    public boolean isInitialized(){
        if(board == null) return false;
        if(player == null) return false;
        if(boxes == null) return false;
        return true;
    }

    public Tile[][] getBoard(){
        return this.board;
    }
}