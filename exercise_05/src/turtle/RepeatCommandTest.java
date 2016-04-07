package turtle;

import java.awt.Color;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RepeatCommandTest {
	private static final Color TEST_COLOR = Turtle.DEFAULT_COLOR;
	private static final int BOARD_SIZE = 100;
	
	private Token token;
	private Turtle turtle;
	private Board board;
	
	@Before
	public void setUp() {
		token = new Token("repeat");
		board = new Board(BOARD_SIZE);
		turtle = new Turtle(new Point(0, 0), board);
	}
	
	@Test
	public void testRepeatOnceOneCommand() {
		token.setArguments("1 {down 10;}");
		RepeatCommand command = new RepeatCommand(token);
		
		command.execute(turtle);
		
		Board expected = new Board(BOARD_SIZE);
		expected.markLocation(new Point(0, 0), TEST_COLOR);
		expected.addVerticalTrace(new Point(0, 0), 10, TEST_COLOR);
		assertArrayEquals(expected.rawBoard(), board.rawBoard());
	}
	
	@Test
	public void testTwiceOneCommand() {
		token.setArguments("2 {down 10;}");
		RepeatCommand command = new RepeatCommand(token);
		
		command.execute(turtle);
		
		Board expected = new Board(BOARD_SIZE);
		expected.markLocation(new Point(0, 0), TEST_COLOR);
		expected.addVerticalTrace(new Point(0, 0), 20, TEST_COLOR);
		assertArrayEquals(expected.rawBoard(), board.rawBoard());
	}
	
	@Test
	public void testOnceTwoCommand() {
		token.setArguments("1 {down 10; right 10;}");
		RepeatCommand command = new RepeatCommand(token);
		
		command.execute(turtle);
		
		Board expected = new Board(BOARD_SIZE);
		expected.markLocation(new Point(0, 0), TEST_COLOR);
		expected.addVerticalTrace(new Point(0, 0), 10, TEST_COLOR);
		expected.addHorizontalTrace(new Point(0, 10), 10, TEST_COLOR);
		assertArrayEquals(expected.rawBoard(), board.rawBoard());
	}
}
