package snakes;



/**
 * Created by kafader on 08.04.2016.
 */
import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JExample.class)
public class FirstSquareTest {
    Player firstPlayer = new Player("firstPlayer");
    Player[] players = {firstPlayer};


    @Test
    public Game setUpGame(){
        Game game = new Game(12, players);
        assertTrue(game.getSquare(1).isFirstSquare());
        assertTrue(game.firstSquare().isOccupied());
        return game;
    }

    @Test
    public Game setUpEmptyGame(){
        Game game = new Game(0, players);
        return game;
    }

    /*@Test
    public ISquare setUpFirstSquare() {


    }*/



    @Test
    public void landHereOrGoHome() throws Exception {

    }

    @Test
    public void isOccupied() throws Exception {

    }

    @Test
    public void enter() throws Exception {

    }

    @Test
    public void leave() throws Exception {

    }

    @Test
    public void isFirstSquare() throws Exception {

    }

    @Test
    public void player() throws Exception {

    }

}