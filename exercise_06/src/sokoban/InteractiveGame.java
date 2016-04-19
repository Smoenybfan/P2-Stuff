package sokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InteractiveGame extends Game{

    public InteractiveGame(String path){
        super(path);
    }
    public static InteractiveGame initialize(){
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
        }catch(Exception e){
            if(e.getClass().equals(RenderException.class)){
                System.out.println("Could not render board!");
            }
            if(e.getClass().equals(IOException.class)){
                System.out.println("Could not read from the console");
            }
        }
    }

    /**
     * This method contains the game-flow for an interactive game
     * @throws IOException if it couldn't read from the console
     * @throws RenderException if the board couldn't been rendered
     */
    public void run() throws Exception{
        Renderer rend = new Renderer();
        do {
            System.out.print(rend.render(this.getBoard()));
            Move move = getMove();
            player.move(move,this.getBoard());
        }while(notOver());
        System.out.print(rend.render(this.getBoard()));
        System.out.println("You Win!");
        return;
    }
}
