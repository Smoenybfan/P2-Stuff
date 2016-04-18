import static org.junit.Assert.*;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.mockito.Mockito.*;

/**
 * Created by Simon on 16.04.2016.
 */
@RunWith(JExample.class)
public class ParserTest {


    Parser mockedParser;

    @Before
    public Parser setUp(){



        mockedParser = mock(Parser.class);
        return mockedParser;
    }


    @Test
    public void checkNotMoreBoxesThanGoals(){

    }

    @Test
    public void checkMoreThanOnePlayer(){

    }

    @Test
    public void correctBoard(){
        char[][] chars={{'#','#','#','#','#'},{'#','P',' ',' ','#'},{'#',' ',' ',' ','#'},{'#',' ','B','G','#'},{'#','#','#','#','#'}};
        assertTrue(mockedParser.isSurroundedByWall(chars));
        assertTrue(mockedParser.onlyOnePlayer(chars));
        assertTrue(mockedParser.boxesBalanced(chars));

    }

    @Test
    public void surroundedByWall(){
        char[][] chars={{'#','#','#','#'},{'#',' ',' ','#'},{'#',' ',' ','#'},{'#','#','#','#'}};
        assertTrue(mockedParser.isSurroundedByWall(chars));
    }

    @Test
    public void notSurroundedByWall(){
        char[][] chars={{'#','#','#',' '},{'#',' ',' ','#'},{'#',' ',' ','#'},{'#','#','#','#'}};
        assertFalse(mockedParser.isSurroundedByWall(chars));
    }

}