package sokoban;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    Parser parser;

    @Before
    public void setUp(){
        parser = new Parser();
    }

    @Test
    public void equalsBasic1Sok()throws Exception{
        Tile[][] board = parser.parse("levels/basic1.sok");
        Tile[][] excpectedBoard = new Tile[6][7];
        //first row
        for(int i = 0; i < 7; i++){
            excpectedBoard[0][i] = new Wall(0,i);
        }
        //second row
        excpectedBoard[1][0] = new Wall(1,0);
        for(int i = 1; i < 6; i++){
            excpectedBoard[1][i] = new Floor(1,i);
        }
        excpectedBoard[1][6] = new Wall(1,6);
        //third row
        excpectedBoard[2][0] = new Wall(2,0);
        excpectedBoard[2][1] = new Player(2,1);
        for(int i = 2; i < 6; i++){
            excpectedBoard[2][i] = new Floor(2,i);
        }
        excpectedBoard[2][6] = new Wall(2,6);
        //fourth row
        for(int i = 0; i < 3; i++){
            excpectedBoard[3][i] = new Wall(3,i);
        }
        excpectedBoard[3][3] = new Box(3,3);
        excpectedBoard[3][4] = new Floor(3,4);
        excpectedBoard[3][5] = new Floor(3,5);
        excpectedBoard[3][6] = new Wall(3,6);
        //fifth row
        for(int i = 0; i < 3; i++){
            excpectedBoard[4][i] = new Wall(4,i);
        }
        excpectedBoard[4][3] = new Floor(4,3);
        excpectedBoard[4][4] = new Floor(4,4);
        excpectedBoard[4][5] = new Goal(4,5);
        excpectedBoard[4][6] = new Wall(4,6);
        //sixth row
        for(int i = 0; i < 7; i++){
            excpectedBoard[5][i] = new Wall(5,i);
        }

        assertArrayEquals(excpectedBoard, board);
    }

    @Test
    public void equalsBasic2Sok() throws Exception{
        Tile[][] board = parser.parse("levels/basic2.sok");
        Tile[][] excpectedBoard = new Tile[7][8];
        //first row
        excpectedBoard[1][0] = new Wall(1,0);
        for(int i = 0; i < 8; i++){
            excpectedBoard[0][i] = new Wall(0,i);
        }
        //second row
        excpectedBoard[1][0] = new Wall(1,0);
        for(int i = 1; i < 7; i++){
            excpectedBoard[1][i] = new Floor(1,i);
        }
        excpectedBoard[1][7] = new Wall(1,7);
        //third row
        excpectedBoard[2][0] = new Wall(2,0);
        excpectedBoard[2][1] = new Floor(2,1);
        excpectedBoard[2][2] = new Floor(2,2);
        excpectedBoard[2][3] = new Box(2,3);
        excpectedBoard[2][4] = new Floor(2,4);
        excpectedBoard[2][5] = new Floor(2,5);
        excpectedBoard[2][6] = new Player(2,6);
        excpectedBoard[2][7] = new Wall(2,7);
        //fourth row
        for(int i = 0; i < 3; i++){
            excpectedBoard[3][i] = new Wall(3,i);
        }
        excpectedBoard[3][3] = new Box(3,3);
        for(int i = 4; i < 7; i++){
            excpectedBoard[3][i] = new Floor(3,i);
        }
        excpectedBoard[3][7] = new Wall(3,7);
        //fifth row
        excpectedBoard[4][0] = new Wall(4,0);
        for(int i = 1; i < 4; i++){
            excpectedBoard[4][i] = new Floor(4,i);
        }
        for(int i = 4; i < 8; i++){
            excpectedBoard[4][i] = new Wall(4,i);
        }
        //sixth row
        excpectedBoard[5][0] = new Wall(5,0);
        for(int i = 1; i < 5; i++){
            excpectedBoard[5][i] = new Floor(5,i);
        }
        excpectedBoard[5][5] = new Goal(5,5);
        excpectedBoard[5][6] = new Goal(5,6);
        excpectedBoard[5][7] = new Wall(5,7);
        //seventh row
        excpectedBoard[6][0] = new Wall(6,0);
        for(int i = 1; i < 8; i++){
            excpectedBoard[6][i] = new Wall(6,i);
        }

        assertArrayEquals(excpectedBoard, board);
    }
}
