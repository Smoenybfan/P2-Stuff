package turtle;

import java.util.ArrayList;

/**
 * Parses a turtle Program
 *
 * Commands must be in the correct semantics, else they will be ignored or in
 * case a number couldn't be parsed an Exception is thrown
 * (e.g. right 5right) thwors an Exception
 *
 * @throws ParserException if a number e.g. command argument couldn't be parsed
 */
public class CommandParser {

    private String[] command;
    private String[] step;
    ArrayList<Command> Program = new ArrayList<>();
    private final int SIZE;

    public CommandParser(int SIZE) {
        this.SIZE = SIZE;
    }

    /**
     * @return an ArrayList with the parsed Commands ready to execute
     * @throws ParserException if an argument couldn't be parsed
     */
    public ArrayList<Command> parse(String turtleProgram) throws ParserException {
        try{
            command = turtleProgram.split("\\r?\\n");
            for(String command : this.command){step = command.split("\\s");
                parseCommand();
            }
            return Program;}
        catch(Exception e){
            throw new ParserException();
        }
    }

    /**
     * Parses the command
     */
    private void parseCommand() throws Exception{
        switch(step[0]){
            case "right":   parseRight(); break;
            case "left" :   parseLeft(); break;
            case "up":      parseUp(); break;
            case "down":    parseDown(); break;
            case "jump":    parseJump(); break;
                default:
        }
    }

    /**
     * Parses the command "right" and adds it to the Program
     */
    private void parseRight() throws Exception{
        if(step.length < 2) return;
        int n = Integer.parseInt(step[1]);
        CommandRight command = new CommandRight(n);
        Program.add(command);
    }

    /**
     * Parses the command "left" and adds it to the Program
     */
    private void parseLeft()throws Exception{
        if(step.length < 2) return;
        int n = Integer.parseInt(step[1]);
        CommandLeft command = new CommandLeft(n);
        Program.add(command);
    }

    /**
     * Parses the command "up" and adds it to the Program
     */
    private void parseUp()throws Exception{
        if(step.length < 2) return;
        int n = Integer.parseInt(step[1]);
        CommandUp command = new CommandUp(n);
        Program.add(command);
    }

    /**
     * Parses the command "down" and adds it to the Program
     */
    private void parseDown()throws Exception{
        if(step.length < 2) return;
        int n = Integer.parseInt(step[1]);
        CommandDown command = new CommandDown(n);
        Program.add(command);
    }

    /**
     * Parses the command "jump" and adds it to the Program
     */
    private void parseJump()throws Exception{
        if(step.length < 3) return;
        int x = Integer.parseInt(step[1]);
        int y = Integer.parseInt(step[2]);
        if(!(0 < x && x < SIZE && 0 < y && y < SIZE)) return;
        CommandJump command = new CommandJump(x,y);
        Program.add(command);
    }
}
