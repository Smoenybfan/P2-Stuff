package turtle;

import java.util.ArrayList;

/**
 * Parses a turtle Program
 *
 * A Program need to have only one command per Line
 * A Command can be right or left or up or down with one number which is the steps to move (e.g. up 4)
 * Or it can be jump with two numbers which are the x and y Position to jump.
 *
 * Commands must be in the correct semantics, else they will be ignored or in
 * case a number couldn't be parsed an Exception is thrown
 * (e.g. right 5right throws an Exception)
 *
 * There is no invariant because the arguments will be dynamically changed
 * means they are variant. The only invariant would be that they exist and that makes no sense to implement.
 * Also the SIZE is final so there is also no need to
 * check that
 *
 * @throws ParserException if command argument as number (not the command itself but the number/numbers after) couldn't be parsed
 */
public class CommandParser {
    private String[] commands;
    ArrayList<Command> Program = new ArrayList<>();
    private final int SIZE;

    public CommandParser(int SIZE) {
        this.SIZE = SIZE;
    }

    /**
     * @return an ArrayList with the parsed Commands ready to execute
     * @throws ParserException if an argument couldn't be parsed
     * @param turtleProgram is the String which will be parsed
     */
    public ArrayList<Command> parse(String turtleProgram) throws ParserException {
        try{
            commands = turtleProgram.split("\\r?\\n");
            for(String command : this.commands){parseCommand(command.split("\\s"));}
            return Program;}
        catch(Exception e){
            throw new ParserException();
        }
    }

    /**
     * Parses the command
     * @throws ParserException if an argument couldn't be parsed
     * @param command The first Parameter should be one of the following Strings:
     * "right","left","up","down","jump". else the command will be ignored
     */
    private void parseCommand(String[] command) throws Exception{
        switch(command[0]){
            case "right":   parseRight(command); break;
            case "left" :   parseLeft(command); break;
            case "up":      parseUp(command); break;
            case "down":    parseDown(command); break;
            case "jump":    parseJump(command); break;
                default:
        }
    }

    /**
     * Parses the command "right" and adds it to the Program
     * @throws ParserException if steps couldn't be parsed
     * @param command must be of size 2 else the command will be ignored
     */
    private void parseRight(String[] command) throws Exception{
        if(command.length != 2) return;
        int steps = Integer.parseInt(command[1]);
        CommandRight commandRight = new CommandRight(steps);
        Program.add(commandRight);
    }

    /**
     * Parses the command "left" and adds it to the Program
     * @throws ParserException if steps couldn't be parsed
     * @param command must be of size 2 else the command will be ignored
     */
    private void parseLeft(String[] command)throws Exception{
        if(command.length != 2) return;
        int steps = Integer.parseInt(command[1]);
        CommandLeft commandLeft = new CommandLeft(steps);
        Program.add(commandLeft);
    }

    /**
     * Parses the command "up" and adds it to the Program
     * @throws ParserException if steps couldn't be parsed
     * @param command must be of size 2 else the command will be ignored
     */
    private void parseUp(String[] command)throws Exception{
        if(command.length != 2) return;
        int steps = Integer.parseInt(command[1]);
        CommandUp commandUp = new CommandUp(steps);
        Program.add(commandUp);
    }

    /**
     * Parses the command "down" and adds it to the Program
     * @throws ParserException if steps couldn't be parsed
     * @param command must be of size 2 else the command will be ignored
     */
    private void parseDown(String[] command)throws Exception{
        if(command.length != 2) return;
        int steps = Integer.parseInt(command[1]);
        CommandDown commandDown = new CommandDown(steps);
        Program.add(commandDown);
    }

    /**
     * Parses the command "jump" and adds it to the Program
     * @throws ParserException if x or y couldn't be parsed
     * @param command must be of size 3 else the command will be ignored
     */
    private void parseJump(String[] command)throws Exception{
        if(command.length != 3) return;
        int x = Integer.parseInt(command[1]);
        int y = Integer.parseInt(command[2]);
        if(!(0 < x && x < SIZE && 0 < y && y < SIZE)) return;
        CommandJump commandJump = new CommandJump(x,y);
        Program.add(commandJump);
    }
}
