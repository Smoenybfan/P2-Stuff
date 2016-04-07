package turtle;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class ProgramParserTest {
	private ProgramParser parser;
	
	@Before
	public void setUp() {
		parser = new ProgramParser();
	}
	
	@Test
	public void testSplitThreeCommands() throws ParseException{
		String[] commands = parser.split("up 10; down 20; print \"this is double qoute:\\\"\";");
		assertEquals("up 10;",commands[0]);
		assertEquals("down 20;",commands[1]);
		assertEquals("print \"this is double qoute:\\\"\";",commands[2]);
	}
	
	@Test
	public void testSplitComplexProgramm() throws ParseException{
		String[] commands = parser.split(
			"up 10;"
			+ "repeat 10 {"
				+ "print \"hi world\";"
				+ "repeat 6 {"
					+ "up 10;"
					+ "right 20"
				+ "};"
			+ "};"
			+ "down 20;");
		assertEquals("up 10;",commands[0]);
		assertEquals("repeat 10 {"
				+ "print \"hi world\";"
				+ "repeat 6 {"
					+ "up 10;"
					+ "right 20"
				+ "};"
			+ "};",commands[1]);
		assertEquals("down 20;",commands[2]);
	}
	
	@Test
	public void checkCorrectBrackets() throws ParseException{
		String[] commands = parser.split(
			"repeat 10 {"
				+ "repeat 5 {"
					+ "repeat 6 {"
						+ "up 10;"
					+ "};"
				+ "};"
			+ "};");
		assertEquals(1,commands.length);
	} 
	
	@Test(expected=ProgramSyntaxException.class)
	public void checkIncorrectBrackets() throws ParseException{
		parser.split(
			"repeat 10 {"
				+ "repeat 5 {"
					+ "repeat 6 {"
						+ "up 10;"
				+ "};"
			+ "};");
	}
	
	@Test
	public void checkCorrectTokenization() throws ParseException{
		String command = "repeat 10 {"
					+ "repeat 5 {"
						+ "repeat 6 {"
							+ "up 10;"
						+ "};"
					+ "};"
				+ "};";
		
		Token expectedToken = new Token("repeat");
		expectedToken.setArguments("10 {repeat 5 {repeat 6 {up 10;};};}");
		
		assertEquals(expectedToken, parser.tokenizeCommand(command));
	} 
}
