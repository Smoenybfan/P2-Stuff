package turtle;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private static final Color TEST_COLOR = Color.BLUE;
	private static final int BOARD_SIZE = 100;
	private Board board;
	
	@Before
	public void setUp() {
		board = new Board(100);
		
	}
	
	@Test
	public void testSimpleMovement() {
		Pixel[][] rawBoard = emptyRawBoard(BOARD_SIZE);
		
		for (int i = 0; i <= 10; i++) {
			rawBoard[0][i].mark(TEST_COLOR);
			rawBoard[i][10].mark(TEST_COLOR);
		}
		board.addVerticalTrace(new Point(0, 0), 10, TEST_COLOR);
		board.addHorizontalTrace(new Point(0, 10), 10, TEST_COLOR);
		assertArrayEquals(rawBoard, board.rawBoard());
	}
	
	@Test
	public void testCircularMovement() {
		Pixel[][] rawBoard = emptyRawBoard(BOARD_SIZE);
		
		for (int i = 0; i <= 10; i++) {
			rawBoard[0][i].mark(TEST_COLOR);
			rawBoard[i][10].mark(TEST_COLOR);
			rawBoard[10][10-i].mark(TEST_COLOR);
			rawBoard[i][0].mark(TEST_COLOR);
		}
		board.addVerticalTrace(new Point(0, 0), 10, TEST_COLOR);
		board.addHorizontalTrace(new Point(0, 10), 10, TEST_COLOR);
		board.addVerticalTrace(new Point(10, 10), -10, TEST_COLOR);
		board.addHorizontalTrace(new Point(10, 0), -10, TEST_COLOR);
		assertArrayEquals(rawBoard, board.rawBoard());
	}

	
	@Test
	public void testVerticalTrace() {
		Pixel[][] rawBoard = emptyRawBoard(BOARD_SIZE);
		
		for (int i = 0; i <= 10; i++) {
			rawBoard[0][i].mark(TEST_COLOR);
		}
		board.addVerticalTrace(new Point(0, 0), 10, TEST_COLOR);
		assertArrayEquals(rawBoard, board.rawBoard());
	}
	
	@Test(expected=PointOutOfBoardException.class)
	public void testVerticalTraceOutOfBoard() {
		Pixel[][] rawBoard = emptyRawBoard(BOARD_SIZE);
		
		for (int i = 0; i <= 10; i++) {
			rawBoard[0][i].mark(TEST_COLOR);
		}
		board.addVerticalTrace(new Point(0, 0), -1, TEST_COLOR);
	}
	
	@Test
	public void testMaximumVerticalTrace() {
		Pixel[][] rawBoard = emptyRawBoard(BOARD_SIZE);
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			rawBoard[0][i].mark(TEST_COLOR);
		}
		board.addVerticalTrace(new Point(0, 0), BOARD_SIZE-1, TEST_COLOR);
		assertArrayEquals(rawBoard, board.rawBoard());
	}
	
	@Test
	public void testHorizontalTrace() {
		Pixel[][] rawBoard = emptyRawBoard(BOARD_SIZE);
		
		for (int i = 0; i <= 10; i++) {
			rawBoard[i][0].mark(TEST_COLOR);
		}
		board.addHorizontalTrace(new Point(0, 0), 10, TEST_COLOR);
		assertArrayEquals(rawBoard, board.rawBoard());
	}
	
	@Test(expected=PointOutOfBoardException.class)
	public void testHorizontalTraceOutOfBoard() {
		Pixel[][] rawBoard = emptyRawBoard(BOARD_SIZE);
		
		for (int i = 0; i <= 10; i++) {
			rawBoard[i][0].mark(TEST_COLOR);
		}
		board.addHorizontalTrace(new Point(0, 0), -1, TEST_COLOR);
	}
	
	@Test
	public void testMaximumHorizontalTrace() {
		Pixel[][] rawBoard = emptyRawBoard(BOARD_SIZE);
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			rawBoard[i][0].mark(TEST_COLOR);
		}
		board.addHorizontalTrace(new Point(0, 0), BOARD_SIZE-1, TEST_COLOR);
		assertArrayEquals(rawBoard, board.rawBoard());
	}
	
	private Pixel[][] emptyRawBoard(int size) {
		Pixel[][] rawBoard;
		
		rawBoard = new Pixel[size][size];
		for (Pixel[] y : rawBoard){
			for (int x = 0; x < y.length; x++){
				y[x] = new Pixel();
			}
		}
		
		return rawBoard;
	}
}
