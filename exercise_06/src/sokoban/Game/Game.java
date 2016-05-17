package sokoban.Game;

import sokoban.Exceptions.*;
import sokoban.GameObjects.Box;
import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;
import sokoban.Moves.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * The Game class handles the game flow
 * It holds a Board of Tiles, a Player and a List of every Box
 *
 * This class is used in the InteractiveGame where the a game initialize and run
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
 * parse the level from a file, so you get a detailed feedback what went wrong
 * There still is one uncaught Exceptions in the run method which is a RenderException
 * which is thrown if the Rendering fails
 *
 * Note that there is a method IsInitializes() to check whether or not the Game is initialized,
 * because the game is instanced even if you get an Exception from the SokobanParser
 */

public class Game{
    private Tile[][] board;
    protected Player player;
    private ArrayList<Box> boxes;

    /**
     * @param path path to the file which contains the board, should not be null
     */
    public Game(String path){
        assert path != null;
        try{
            ParserLocator.setParserLocator(new SokobanParser());
            board = ParserLocator.instance().parse(path);
            player = getPlayer();
            getBoxes();
        }
        catch(FileNotFoundException e){
            System.out.println("Could not load level!");
            System.out.println("File not found!");
        }
        catch(IOException e){
            System.out.println("Could not load level!");
            System.out.println("Could not read from the file " + path);
        }
        catch(NumberFormatException e){
            System.out.println("Could not load level!");
            System.out.println("Either height or width could not be parsed!");
        }
        catch(InvalidSizeException e){
            System.out.println("Could not load level!");
            System.out.println("Either height or width was 0!");
        }
        catch(MultiplePlayerException e){
            System.out.println("Could not load level!");
            System.out.println("There is more than one Player!");
        }
        catch(BoxGoalException e){
            System.out.println("Could not load level!");
            System.out.println("There aren't as much Boxes as Goals!");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Could not load level!");
            System.out.println("The height or the width isn't correct");
        }
        catch (CouldNotIdentifyCharacterException e){
            System.out.println("Could not load level!");
            System.out.println("There was a foreign character in the file");
        }
        catch (Exception e){
            System.out.println("Could not load level!");
            System.out.println("There was an unknown error");
        }
    }

    private Player getPlayer(){
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

    /**
     * Gets all the Boxes from the Board and saves them in an ArrayList
     * The board should already be parsed
     */
    private void getBoxes(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j].toString().equals("B")){
                    boxes.add((Box) board[i][j]);
                }
            }
        }
    }

    /**
     * This method moves the player around meaning i actually plays the game
     * After the moves are made you will be noticed in the console,
     * if you have successfully solved the puzzle or not
     * @param program a Program that instructs the player where to move. There are 4 commands:
     *                "up","down","left" and "right". In order to to pass several commands at one time
     *                you need to separate them by a comma (invalid commands will be ignored)
     *                the program should not be null
     *                e.g "up,down,right" moves the player up then down then right
     * @throws RenderException if the board couldn't been rendered
     */
    public void run(String program) throws RenderException{
        assert program != null;
        Renderer rend = new Renderer();
        ArrayList<Move> moves = parseProgram(program);
        Iterator<Move> it = moves.iterator();
        while(it.hasNext()){
            System.out.print(rend.render(board)+"\n");
            Move move = it.next();
            player.move(move,board);
            if(!notOver()){
                System.out.print(rend.render(board));
                System.out.println("Puzzle Solved!");
                return;
            }
        }
        System.out.print(rend.render(board));
        System.out.println("Puzzle not solved!");
    }

    /**
     * Parses a Program which afterwards moves a Player in the run method.
     * A Program has the 4 commands explain later which are separated by a comma.
     * All commands that doesn't fit to: "up","down","right","left" ,will just be left out
     * @param program a program where the commands are separated by a comma, should not be null
     * @return an ArrayList which contains the corresponding Moves
     */
    private ArrayList<Move> parseProgram(String program){
        assert program != null;
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

    public boolean notOver(){
        Iterator<Box> it = boxes.iterator();
        while(it.hasNext()){
            Box box = it.next();
            if(!box.match()) return true;
        }
        return false;
    }

    /**
     * @return if the game could been initialised
     */
    public boolean isInitialized(){
        if(board == null) return false;
        if(player == null) return false;
        if(boxes == null) return false;
        return true;
    }

    public Tile[][] getBoard(){
        return this.board;
    }

    public String toString(){
        return Arrays.toString(board);
    }
}