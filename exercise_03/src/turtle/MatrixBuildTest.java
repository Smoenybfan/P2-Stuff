package turtle;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JExample.class)
public class MatrixBuildTest {
    private final int SIZE=100;
    private Turtle turtle;
    boolean[][] expectedBoard;

    @Test
    public void initialize(){
        boolean[][] board = new boolean[SIZE][SIZE];
        board[SIZE/2][SIZE/2] = true;
        turtle = new Turtle(SIZE/2,SIZE/2,board);
    }

    @Given("initialize")
    public void moveRight(){

        assertEquals(turtle.getX(),SIZE/2);
        assertEquals(turtle.getY(),SIZE/2);
        Command right = new CommandRight(6);
        turtle.move(right);

        expectedBoard = new boolean[SIZE][SIZE];
        for(int i = 0; i <= 6; i++) {
            expectedBoard[SIZE / 2 + i][SIZE / 2] = true;
        }
        assertArrayEquals(expectedBoard, turtle.getBoard());
        assertEquals(SIZE/2+6,turtle.getX());
        assertEquals(SIZE/2,turtle.getY());
    }

    @Given("moveRight")
    public void moveUp(){
        Command up = new CommandUp(8);
        int x = turtle.getX();
        int y = turtle.getY();
        turtle.move(up);
        for(int i = 1; i <= 8; i++){
            expectedBoard[x][y - i] = true;
        }
        assertArrayEquals(expectedBoard,turtle.getBoard());
        assertEquals(y - 8,turtle.getY());
    }

    @Given("moveUp")
    public void moveLeft(){
        Command left = new CommandLeft(22);
        int x = turtle.getX();
        int y = turtle.getY();
        turtle.move(left);
        for(int i = 1; i <= 22; i++){
            expectedBoard[x - i][y] = true;
        }
        assertArrayEquals(expectedBoard,turtle.getBoard());
        assertEquals(x - 22,turtle.getX());
    }

    @Given("moveLeft")
    public void moveDown(){
        Command down = new CommandDown(44);
        int x = turtle.getX();
        int y = turtle.getY();
        turtle.move(down);
        for(int i = 1; i <= 44; i++){
            expectedBoard[x][y + i] = true;
        }
        assertArrayEquals(expectedBoard,turtle.getBoard());
        assertEquals(y + 44, turtle.getY());
    }

    @Given("moveDown")
    public void jump(){
        Command jump = new CommandJump(20,20);
        turtle.move(jump);
        expectedBoard[20][20] = true;
        assertArrayEquals(expectedBoard,turtle.getBoard());
        assertEquals(20 , turtle.getY());
        assertEquals(20, turtle.getX());
    }

    @Given("jump")
    public void moveRightOverBoarder(){
        Command right = new CommandRight(88);
        int x = turtle.getX();
        int y = turtle.getY();
        turtle.move(right);
        for(int i = 1; i < SIZE-x; i++){
            expectedBoard[x+i][y] = true;
        }
        for(int i = 0; i <= 8; i++){
            expectedBoard[i][y] = true;
        }
        assertArrayEquals(expectedBoard,turtle.getBoard());
        assertEquals(8 , turtle.getX());
    }

    @Given("moveRightOverBoarder")
    public void moveUpOverBoarder(){
        Command up = new CommandUp(50);
        int x = turtle.getX();
        int y = turtle.getY();
        turtle.move(up);
        for(int i = 1; i <= y; i++){
            expectedBoard[x][y - i] = true;
        }
        for(int i = 1; i <= 30; i++){
            expectedBoard[x][SIZE - i] = true;
        }
        assertArrayEquals(expectedBoard,turtle.getBoard());
        assertEquals(70, turtle.getY());
    }

    @Given("moveUpOverBoarder")
    public void moveLeftOverBoarder(){
        CommandLeft left = new CommandLeft(9);
        int x = turtle.getX();
        int y = turtle.getY();
        turtle.move(left);
        for(int i = 1; i <= 8; i++){
            expectedBoard[x - i][y] = true;
        }
        expectedBoard[SIZE-1][y] = true;
        assertArrayEquals(expectedBoard,turtle.getBoard());
        assertEquals(99,turtle.getX());
    }

    @Given("moveLeftOverBoarder")
    public void moveDownOverBoarder(){
        Command down = new CommandDown(30);
        int x = turtle.getX();
        int y = turtle.getY();
        turtle.move(down);
        for(int i = 1; i < 30; i++){
            expectedBoard[x][y + i] = true;
        }
        expectedBoard[x][0] = true;
        assertArrayEquals(expectedBoard,turtle.getBoard());
        assertEquals(0,turtle.getY());
    }





}

