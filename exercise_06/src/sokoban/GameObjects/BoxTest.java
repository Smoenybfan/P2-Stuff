package sokoban.GameObjects;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by smoen on 04.05.2016.
 */
@RunWith(JExample.class)
public class BoxTest {
    Box box1,box2,box3,box4;
    Tile tile;
    Box box = new Box(2,3);
    Tile[][]board =new Tile[7][7];

    @Test
    public void setUp(){
        Tile tiler = new Tile(2,2);
        tile = spy(tiler);
       Wall wall = mock(Wall.class);
        board[2][3]= box;

        board[0][3]= wall;
        board[1][3]=tile;
        board[4][3]= wall;
        board[3][3]=tile;

        board[2][2]=tile;
        board[2][1]= wall;
        board[2][4]=tile;
        board[2][5]= wall;
        when(wall.toString()).thenReturn("#");
    }

    @Given("setUp")
    public void moveUp() {
        when(tile.toString()).thenReturn(" ");
        when(tile.getX()).thenReturn(3);
        when(tile.getY()).thenReturn(1);
        assertTrue(box.moveUp(board));
        int[] pos = {1,3};
        assertArrayEquals(pos , box.position);
        assertFalse(box.moveUp(board));
    }

    @Given("setUp")
    public void moveDown() {
        when(tile.toString()).thenReturn(" ");
        when(tile.getX()).thenReturn(3);
        when(tile.getY()).thenReturn(3);
        assertTrue(box.moveDown(board));
        int[] pos = {3,3};
        assertArrayEquals(pos , box.position);
        assertFalse(box.moveDown(board));
    }

    @Given("setUp")
    public void moveRight(){
        when(tile.toString()).thenReturn(" ");
        when(tile.getX()).thenReturn(4);
        when(tile.getY()).thenReturn(2);
        assertTrue(box.moveRight(board));
        int[] pos = {2,4};
        assertArrayEquals(pos , box.position);
        assertFalse(box.moveRight(board));
    }

    @Given("setUp")
    public void moveLeft() {
        when(tile.toString()).thenReturn(" ");
        when(tile.getX()).thenReturn(2);
        when(tile.getY()).thenReturn(2);
        assertTrue(box.moveLeft(board));
        int[] pos = {2,2};
        assertArrayEquals(pos , box.position);
        assertFalse(box.moveLeft(board));
    }

    @Test
    public void setBoxUp(){
        Tile tiler = new Tile(2,2);
        tile = spy(tiler);
        box1 = new Box(1,3);
        box2 = new Box(3,3);
        box3 = new Box(2,2);
        box4 = new Box(2,4);
        Wall wall = mock(Wall.class);
        board[2][3]= box;

        board[0][3]= wall;
        board[1][3]= box1;
        board[4][3]=tile;
        board[5][3]= wall;
        board[3][3]= box2;

        board[2][2]= box3;
        board[2][1]=tile;
        board[2][0]= wall;
        board[2][5]=tile;
        board[2][4]= box4;
        board[2][6]= wall;
        when(wall.toString()).thenReturn("#");
    }

    @Given("setBoxUp")
    public void moveBoxUp(){
        assertFalse(box.moveUp(board));
        int[] pos = {1,3};

    }

    @Given("setBoxUp")
    public void moveBoxDown(){
        when(tile.toString()).thenReturn(" ");
        when(tile.getX()).thenReturn(3);
        when(tile.getY()).thenReturn(4);
        assertTrue(box.moveDown(board));
        int[] pos = {3,3};
        assertArrayEquals(pos , box.position);
        assertFalse(box.moveDown(board));
    }

    @Given("setBoxUp")
    public void moveBoxLeft(){
        when(tile.toString()).thenReturn(" ");
        when(tile.getX()).thenReturn(1);
        when(tile.getY()).thenReturn(2);
        assertTrue(box.moveLeft(board));
        int[] pos = {2,2};
        assertArrayEquals(pos , box.position);
        assertFalse(box.moveLeft(board));
    }

    @Given("setBoxUp")
    public void moveBoxRight(){
        when(tile.toString()).thenReturn(" ");
        when(tile.getX()).thenReturn(5);
        when(tile.getY()).thenReturn(2);
        assertTrue(box.moveRight(board));
        int[] pos = {2,4};
        assertArrayEquals(pos , box.position);
        assertFalse(box.moveRight(board));
    }


}