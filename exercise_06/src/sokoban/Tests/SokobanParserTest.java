package sokoban.Tests;

import org.junit.Before;
import org.junit.Test;
import sokoban.Exceptions.BoxGoalException;
import sokoban.Exceptions.InvalidSizeException;
import sokoban.Exceptions.MultiplePlayerException;
import sokoban.Game.SokobanParser;
import sokoban.GameObjects.*;

import static org.junit.Assert.*;

public class SokobanParserTest {
    private SokobanParser sokobanParser;

    @Before
    public void setUp(){
        sokobanParser = new SokobanParser();
    }

    @Test
    public void equalsBasic1Sok(){
        try{
            Tile[][] board = sokobanParser.parse("levels/basic1.sok");
            Tile[][] expectedBoard = buildExpectedBasic1Sok();
            assertArrayEquals(expectedBoard, board);
        }catch(Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void equalsBasic2Sok(){
        try {
            Tile[][] board = sokobanParser.parse("levels/basic2.sok");
            Tile[][] expectedBoard = buildExpectedBasic2Sok();
            assertArrayEquals(expectedBoard, board);
        }catch(Exception e){
            assertTrue(false);
        }
    }

    @Test(expected = java.io.FileNotFoundException.class)
    public void fileNotFount() throws Exception{
        sokobanParser.parse("basic1.sok");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void OutOfBound() throws Exception{
        sokobanParser.parse("test/OutOfBound.sok");
    }

    @Test(expected = NumberFormatException.class)
    public void NumberFormat() throws Exception{
        sokobanParser.parse("test/NumberFormat.sok");
    }

    @Test(expected = InvalidSizeException.class)
    public void InvalidSize() throws Exception{
        sokobanParser.parse("test/InvalidSize.sok");
    }

    @Test(expected = MultiplePlayerException.class)
    public void multiplePlayer() throws Exception{
        sokobanParser.parse("test/MultiplePlayer.sok");
    }

    @Test(expected = BoxGoalException.class)
    public void moreBoxesThanGoals() throws Exception{
        sokobanParser.parse("test/BoxGoal.sok");
    }

    private  Tile[][] buildExpectedBasic1Sok(){
        Tile[][] expectedBoard = new Tile[6][7];
        //first row
        for(int i = 0; i < 7; i++){
            expectedBoard[0][i] = new Wall(0,i);
        }
        //second row
        expectedBoard[1][0] = new Wall(1,0);
        for(int i = 1; i < 6; i++){
            expectedBoard[1][i] = new Floor(1,i);
        }
        expectedBoard[1][6] = new Wall(1,6);
        //third row
        expectedBoard[2][0] = new Wall(2,0);
        expectedBoard[2][1] = new Player(2,1);
        for(int i = 2; i < 6; i++){
            expectedBoard[2][i] = new Floor(2,i);
        }
        expectedBoard[2][6] = new Wall(2,6);
        //fourth row
        for(int i = 0; i < 3; i++){
            expectedBoard[3][i] = new Wall(3,i);
        }
        expectedBoard[3][3] = new Box(3,3, new Floor(3,3));
        expectedBoard[3][4] = new Floor(3,4);
        expectedBoard[3][5] = new Floor(3,5);
        expectedBoard[3][6] = new Wall(3,6);
        //fifth row
        for(int i = 0; i < 3; i++){
            expectedBoard[4][i] = new Wall(4,i);
        }
        expectedBoard[4][3] = new Floor(4,3);
        expectedBoard[4][4] = new Floor(4,4);
        expectedBoard[4][5] = new Goal(4,5);
        expectedBoard[4][6] = new Wall(4,6);
        //sixth row
        for(int i = 0; i < 7; i++){
            expectedBoard[5][i] = new Wall(5,i);
        }
        return  expectedBoard;
    }

    private Tile[][] buildExpectedBasic2Sok(){
        Tile[][] expectedBoard = new Tile[7][8];
        //first row
        for(int i = 0; i < 8; i++){
            expectedBoard[0][i] = new Wall(0,i);
        }
        //second row
        expectedBoard[1][0] = new Wall(1,0);
        for(int i = 1; i < 7; i++){
            expectedBoard[1][i] = new Floor(1,i);
        }
        expectedBoard[1][7] = new Wall(1,7);
        //third row
        expectedBoard[2][0] = new Wall(2,0);
        expectedBoard[2][1] = new Floor(2,1);
        expectedBoard[2][2] = new Floor(2,2);
        expectedBoard[2][3] = new Box(2,3, new Floor(2,3));
        expectedBoard[2][4] = new Floor(2,4);
        expectedBoard[2][5] = new Floor(2,5);
        expectedBoard[2][6] = new Player(2,6);
        expectedBoard[2][7] = new Wall(2,7);
        //fourth row
        for(int i = 0; i < 3; i++){
            expectedBoard[3][i] = new Wall(3,i);
        }
        expectedBoard[3][3] = new Box(3,3, new Floor(3,3));
        for(int i = 4; i < 7; i++){
            expectedBoard[3][i] = new Floor(3,i);
        }
        expectedBoard[3][7] = new Wall(3,7);
        //fifth row
        expectedBoard[4][0] = new Wall(4,0);
        for(int i = 1; i < 4; i++){
            expectedBoard[4][i] = new Floor(4,i);
        }
        for(int i = 4; i < 8; i++){
            expectedBoard[4][i] = new Wall(4,i);
        }
        //sixth row
        expectedBoard[5][0] = new Wall(5,0);
        for(int i = 1; i < 5; i++){
            expectedBoard[5][i] = new Floor(5,i);
        }
        expectedBoard[5][5] = new Goal(5,5);
        expectedBoard[5][6] = new Goal(5,6);
        expectedBoard[5][7] = new Wall(5,7);
        //seventh row
        expectedBoard[6][0] = new Wall(6,0);
        for(int i = 1; i < 8; i++){
            expectedBoard[6][i] = new Wall(6,i);
        }
        return expectedBoard;
    }
}
