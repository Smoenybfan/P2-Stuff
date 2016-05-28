package sokoban.Game;

import sokoban.Moves.*;
import sokoban.Exceptions.RenderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InteractiveGame extends Game{

    public InteractiveGame(String path){
        super(path, new Parser());
    }

    private static InteractiveGame initialize(){
        InteractiveGame game = null;
        boolean initialized = false;
        while(!initialized){
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Which level do you wanna play? Enter the title of the level:");
            try{
                String level = bf.readLine();
                game = new InteractiveGame("levels/" + level + ".sok");
                if(game.isInitialized()){
                    initialized = true;
                }
            }catch(IOException e){
                System.out.println("Could not read from the console!");
            }
        }
        return game;
    }

    public static void main(String[] args){
        InteractiveGame game = initialize();
        try{
            game.run();
        }
        catch(RenderException e){
            System.out.println("Could not render board!");
        }
        catch(IOException e){
            System.out.println("Could not read from the console");
        }
    }

    /**
     * This method contains the game-flow for an interactive game
     * @throws IOException if it couldn't read from the console
     * @throws RenderException if the board couldn't been rendered
     */
    private void run() throws IOException, RenderException{
        SokobanRenderer rend = new SokobanRenderer();
        do {
            System.out.print(rend.render(this.getBoard()));
            Move move = getMove();
            player.move(move,this.getBoard());
        }while(notOver());
        System.out.print(rend.render(this.getBoard()));
        System.out.println("You Win!");
    }

    /**
     * This method takes an input from the command line and
     * parses it. You have to try until you get one of the following commands
     * "up", "down", "right", "left" right.
     * @return the corresponding move to the given input
     * @throws IOException if it couldn't read from the console
     */
    private Move getMove() throws IOException{
        System.out.println("Which direction do you want to go next?");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String command = bf.readLine();
            switch(command){
                default: System.out.println("Try again!"); break;
                case "up": return new Up();
                case "down": return new Down();
                case "right": return new Right();
                case "left": return new Left();
            }
        }
    }
}
