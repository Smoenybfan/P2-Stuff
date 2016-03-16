package turtle;

import java.util.ArrayList;

/**
 * This class checks if the entered command is valid.
 * If the command is valid, it returns it to the BoardMaker.
 * Otherwise it throws an Exception that will be caught by the BoardMaker Class.
 * Created by Simon on 12.03.2016.
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
     */
    public ArrayList<String[]> parse(String turtleProgram) throws ParserException {
        ArrayList<String[]> parsedProgram = new ArrayList<>();
        command = turtleProgram.split("\\r?\\n");
        for(String command : this.command){
            step = command.split("\\s");
            parseCommand();
            parsedProgram.add(step);
        }
        return parsedProgram;
    }

    private void parseCommand() throws ParserException{
        switch(step[0]){
            case "right":  parseRight();
                break;
            case "left" :  parseLeft();
                break;
            case "up":     parseUp();
                break;
            case "down":   parseDown();
                break;
            case "jump":   parseJump();
                break;
                default:   throw new ParserException();
        }
    }

    private void parseRight() throws ParserException{
        if(step.length < 2) throw new ParserException();
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && x + n < SIZE)) throw new ParserException();
        x += n;
    }

    private void parseLeft() throws ParserException{
        if(step.length < 2) throw new ParserException();
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && x - n > 0)) throw new ParserException();
        x -= n;
    }

    private void parseUp() throws ParserException{
        if(step.length < 2) throw new ParserException();
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && y - n > 0)) throw new ParserException();
        y -=n;
    }

    private void parseDown() throws ParserException{
        if(step.length < 2) throw new ParserException();
        int n = Integer.parseInt(step[1]);
        if(!(n > 0 && y + n < SIZE)) throw new ParserException();
        y += n;
    }

    private void parseJump() throws ParserException{
        if(step.length < 3) throw new ParserException();
        int x = Integer.parseInt(step[1]);
        int y = Integer.parseInt(step[2]);
        if(!(0 < x && x < SIZE && 0 < y && y < SIZE)) throw new ParserException();
        this.x = x;
        this.y = y;
    }



}
