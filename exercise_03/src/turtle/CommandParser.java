package turtle;

import java.util.ArrayList;

/**
 * Checks if an entered Program is valid.
 * If minimum one command is valid, it returns the formatted Program.
 *
 * Invalid commands will be ignored
 *
 * In the array <code>command</code> will the splitted commands be stored
 * The array <code>step</code> is used to store the arguments of a command
 * <code>x</code> and <code>y</code> are used to hold track of the turtle e.g. if the turtle would leaves the board
 * The Integer <code>SIZE</code> is the Size of the Board an is used for the same matter
 *
 * The Program is formatted to fit the Execution in the Class <code>BoardMaker</code>
 *
 * @see BoardMaker
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
        ArrayList<String[]> Program = new ArrayList<>();
        command = turtleProgram.split("\\r?\\n");
        for(String command : this.command){
            step = command.split("\\s");
            if(parseCommand()){
                Program.add(step);
            }
        }
        if(Program.size() == 0){
            throw new ParserException();
        }
        return Program;
    }

    private boolean parseCommand(){
        switch(step[0]){
            case "right":  return parseRight();
            case "left" :  return parseLeft();
            case "up":     return parseUp();
            case "down":   return parseDown();
            case "jump":   return parseJump();
                default:   return false;
        }
    }


    private boolean parseRight(){
        if(step.length < 2) return false;
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && x + n < SIZE)) return false;
        x += n;
        return true;
    }

    private boolean parseLeft(){
        if(step.length < 2) return false;
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && x - n > 0)) return false;
        x -= n;
        return true;
    }

    private boolean parseUp(){
        if(step.length < 2) return false;
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && y - n > 0)) return false;
        y -=n;
        return true;
    }

    private boolean parseDown(){
        if(step.length < 2) return false;
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && y + n < SIZE)) return false;
        y += n;
        return true;
    }

    private boolean parseJump(){
        if(step.length < 3) return false;
        int x = Integer.parseInt(step[1]);
        int y = Integer.parseInt(step[2]);
        if(!(0 < x && x < SIZE && 0 < y && y < SIZE)) return false;
        this.x = x;
        this.y = y;
        return true;
    }
}
