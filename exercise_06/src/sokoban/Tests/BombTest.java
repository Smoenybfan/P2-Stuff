package sokoban.Tests;

import org.junit.Before;
import org.junit.Test;
import sokoban.GameObjects.Bomb;
import sokoban.GameObjects.BreakableWall;
import sokoban.GameObjects.Tile;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by smoen on 04.05.2016.
 */
public class BombTest {
    Tile tile;
    Bomb mockedBomb;
    Tile[][]board =new Tile[5][5];

    @Before
    public void setUp(){
        BreakableWall someTile = new BreakableWall(2,2);
        tile = spy(someTile);
        Bomb bomb = new Bomb(2,3);
        mockedBomb = spy(bomb);

        board[2][3]= mockedBomb;
        board[1][3]=tile;
        board[3][3]=tile;
        board[2][2]=tile;
        board[2][4]=tile;
    }

    @Test
    public void moveBombUp() throws Exception {
        when(tile.toString()).thenReturn("X");
        assertTrue(mockedBomb.moveUp(board));
    }

    @Test
    public void moveDown() throws Exception {
        when(tile.toString()).thenReturn("X");
        assertTrue(mockedBomb.moveDown(board));
    }

    @Test
    public void moveRight() throws Exception {
        when(tile.toString()).thenReturn("X");
        assertTrue(mockedBomb.moveRight(board));
    }

    @Test
    public void moveLeft() throws Exception {
        when(tile.toString()).thenReturn("X");
        assertTrue(mockedBomb.moveLeft(board));
    }

}