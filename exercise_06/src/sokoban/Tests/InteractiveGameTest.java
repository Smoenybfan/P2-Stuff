package sokoban.Tests;


import org.junit.Before;
import sokoban.Game.InteractiveGame;

public class InteractiveGameTest{

    /**
     * There is only the main method which is public so it makes no sense  for me to Test anything
     */

    InteractiveGame game;

    @Before
    public void setUp(){
        game = new InteractiveGame("levels/baisc1");
    }
}
