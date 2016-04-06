package turtle;

import java.util.ArrayList;

/**
 * Parses a turtle Program
 *
 * Invalid commands will be ignored
 *
 * @throws ParserException if the fist or the second argument from a command couldn't be parsed
 */
public class CommandParser {

    private String[] command;
    private String[] step;
    private int x,y;
    private final int SIZE;

    public CommandParser(int SIZE) {
        assert SIZE > 0;
        this.SIZE = SIZE;
        x = SIZE/2;
        y = SIZE/2;
    }

    /**
     * @return formatted Program as ArrayList
     * @throws ParserException if there is no valid command
     */
    public ArrayList<String[]> parse(String turtleProgram) throws ParserException {
        try{
            ArrayList<String[]> Program = new ArrayList<>();
            command = turtleProgram.split("\\r?\\n");
            for(String command : this.command){step = command.split("\\s");
                if(parseCommand()){Program.add(step);}
            }
            return Program;}
        catch(Exception e){
            throw new ParserException();
        }
    }

    private boolean parseCommand() throws Exception{
        switch(step[0]){
            case "right":  return parseRight();
            case "left" :  return parseLeft();
            case "up":     return parseUp();
            case "down":   return parseDown();
            case "jump":   return parseJump();
                default:   return false;
        }
    }

    private boolean parseRight() throws Exception{
        if(step.length < 2) return false;
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && x + n < SIZE)) return false;
        x += n;
        return true;
    }

    private boolean parseLeft()throws Exception{
        if(step.length < 2) return false;
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && x - n > 0)) return false;
        x -= n;
        return true;
    }

    private boolean parseUp()throws Exception{
        if(step.length < 2) return false;
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && y - n > 0)) return false;
        y -=n;
        return true;
    }

    private boolean parseDown()throws Exception{
        if(step.length < 2) return false;
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && y + n < SIZE)) return false;
        y += n;
        return true;
    }

    private boolean parseJump()throws Exception{
        if(step.length < 3) return false;
        int x = Integer.parseInt(step[1]);
        int y = Integer.parseInt(step[2]);
        if(!(0 < x && x < SIZE && 0 < y && y < SIZE)) return false;
        this.x = x;
        this.y = y;
        return true;
    }
}
