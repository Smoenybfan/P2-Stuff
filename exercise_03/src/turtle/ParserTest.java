package turtle;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(JExample.class)
public class ParserTest {
    private CommandParser commandParser;
    private final int SIZE = 100;

    @Test
    public void parseEmptyProgram() throws ParserException{
        commandParser = new CommandParser(SIZE);
        ArrayList<Command> commands = commandParser.parse("");
        assertEquals(0,commands.size());
    }

    @Given("parseEmptyProgram")
    public void parseRightCommand() throws ParserException{
        ArrayList<Command> commands = commandParser.parse("right 4\n");
        assertEquals(commands.size(),1);
        assertEquals("right 4",commands.get(0).toString());
    }

    @Given("parseRightCommand")
    public void parseSecondCommand() throws ParserException{
        ArrayList<Command> commands = commandParser.parse("up 5\n");
        assertEquals(2,commands.size());
        assertEquals("up 5",commands.get(1).toString());
    }

    @Test(expected = ParserException.class)
    public void parseException() throws ParserException {
        commandParser = new CommandParser(SIZE);
        ArrayList<Command> commands = commandParser.parse("right 3right");}

    @Test
    public void exceptionClass(){
        commandParser = new CommandParser(SIZE);
        try{
            ArrayList<Command> commands = commandParser.parse("right 3right");
        }catch(Exception e){
            assertEquals(new ParserException().getClass(),e.getClass());
        }
    }

    @Test
    public void parseMultipleCommands() throws ParserException{
        commandParser = new CommandParser(SIZE);
        ArrayList<Command> commands = commandParser.parse("up 2\nleft 6\ndown 45\njump 3 6\ndown 34\n");
        assertEquals(5 , commands.size());
        assertEquals("up 2",commands.get(0).toString());
        assertEquals("left 6", commands.get(1).toString());
        assertEquals("down 45", commands.get(2).toString());
        assertEquals("jump 3 6", commands.get(3).toString());
        assertEquals("down 34", commands.get(4).toString());
    }

    @Test
    public void invalidInput() throws ParserException{
        commandParser = new CommandParser(SIZE);
        ArrayList<Command> commands = commandParser.parse("asdfdfs\nright 6\nasdfdas\nup 4");
        assertEquals(2,commands.size());
        assertEquals("right 6",commands.get(0).toString());
        assertEquals("up 4",commands.get(1).toString());
    }
}
