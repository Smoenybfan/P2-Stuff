package sokoban.Tests;


import org.junit.Before;
import org.junit.Test;
import sokoban.GameObjects.Floor;
import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;
import sokoban.Moves.Right;

import static org.junit.Assert.assertArrayEquals;

public class PlayerTest {
    private Player player;
    private Tile[][] board;

    /**
     * This is an integration Test
     */
    @Before
    public void setUp(){
        player = new Player(0,0);
        board = new Tile[1][2];
        board[0][0] = player;
        board[0][1] = new Floor(0,1);
    }

    /**
     * This is an integration Test
     */
    @Test
    public void movePlayerRight(){
        player.move(new Right(),board);
        Tile[][] expectedBoard = new Tile[1][2];
        expectedBoard[0][0] = new Floor(0,0);
        expectedBoard[0][1] = new Player(0,1);
        assertArrayEquals(board,expectedBoard);
    }
}
