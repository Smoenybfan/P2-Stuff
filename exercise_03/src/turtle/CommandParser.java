package turtle;

import java.util.ArrayList;

/**
 * Parses a turtle Program
 *
 * It holds an ArrayList Program where the parsed Commands will be saved in, which will then
 * be passed to an instance of BoardMaker. It also holds a variable SIZE which is the SIZE
 * of the board where after the parsing the turtle will be moved. This is used to check whether
 * or not a command "jump" would change the Position of a turtle to somewhere out of the board.
 *
 * A Program need to have only one command per Line
 * A Command can be "right" or "left" or "up" or "down" with one number which is the steps to move (e.g. up 4)
 * Or it can be "jump" with two numbers which are the x and y Position to jump.
 * Between command and the numbers need to be at least one space.
 *
 * Commands must be in the correct semantics, else they will be ignored or in
 * case a number couldn't be parsed an Exception is thrown
 * (e.g. right 5right throws an Exception)
 *
 * There is no invariant because the arguments will be dynamically changed
 * means they are variant. The only invariant would be that they exist and that makes no sense to implement.
 * Also the SIZE is final so there is no need to check that either.
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
     * @return an ArrayList with the parsed Commands ready to execute, this ArrayList can
     *          also be empty if there wasn't a Command that could been parsed
     * @throws ParserException if an argument couldn't be parsed
     * @param turtleProgram is the String which will be parsed, the String can be anything
     *                      but note that only the correct Commands will be returned
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
     * Parses the command itself
     * @throws ParserException if an argument couldn't be parsed
     * @param command has to at least contain one element.
     *                The first Parameter should be one of the following Strings:
     *                "right","left","up","down","jump". else the command will be ignored
     */
    private void parseCommand(String[] command) throws Exception{
        assert command.length > 0;
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
     * Parses the command "right" and adds it to the ArrayList
     * @throws ParserException if steps couldn't be parsed
     * @param command must be of size 2 else the command will be ignored
     *                command[0] must be "right"
     *                command[1] should be an integer else a ParserException will be thrown
     * This method should add a CommandRight with the parameter steps to the ArrayList
     */
    private void parseRight(String[] command) throws Exception{
        assert command[0].equals("right");
        if(command.length != 2) return;
        int steps = Integer.parseInt(command[1]);
        CommandRight commandRight = new CommandRight(steps);
        Program.add(commandRight);
        assert Program.get(Program.size()-1).toString().equals("right " + steps);
    }

    /**
     * Parses the command "left" and adds it to the ArrayList
     * @throws ParserException if steps couldn't be parsed
     * @param command must be of size 2 else the command will be ignored
     *                command[0] must "left"
     *                command[1] should be an integer else a ParserException will be thrown
     * This method should add a CommandLeft with the parameter steps to the ArrayList
     */
    private void parseLeft(String[] command)throws Exception{
        assert command[0].equals("left");
        int ProgramSize = Program.size();
        if(command.length != 2) return;
        int steps = Integer.parseInt(command[1]);
        CommandLeft commandLeft = new CommandLeft(steps);
        Program.add(commandLeft);
        assert Program.size() == ProgramSize + 1;
        assert Program.get(Program.size()-1).toString().equals("left " + steps);
    }

    /**
     * Parses the command "up" and adds it to the ArrayList
     * @throws ParserException if steps couldn't be parsed
     * @param command must be of size 2 else the command will be ignored
     *                command[0] must be "up"
     *                command[1] should be an integer else a ParserException will be thrown
     * This method should add a CommandUp with the parameter steps to the ArrayList
     */
    private void parseUp(String[] command)throws Exception{
        assert command[0].equals("up");
        int ProgramSize = Program.size();
        if(command.length != 2) return;
        int steps = Integer.parseInt(command[1]);
        CommandUp commandUp = new CommandUp(steps);
        Program.add(commandUp);
        assert Program.size() == ProgramSize + 1;
        assert Program.get(Program.size()-1).toString().equals("up " + steps);
    }

    /**
     * Parses the command "down" and adds it to the ArrayList
     * @throws ParserException if steps couldn't be parsed
     * @param command must be of size 2 else the command will be ignored
     *                command[0] must be "down"
     *                command[1] should be an integer else a ParserException will be thrown
     * This method should add a CommandDown with the parameter steps to the ArrayList
     */
    private void parseDown(String[] command)throws Exception{
        assert command[0].equals("down");
        int ProgramSize = Program.size();
        if(command.length != 2) return;
        int steps = Integer.parseInt(command[1]);
        CommandDown commandDown = new CommandDown(steps);
        Program.add(commandDown);
        assert Program.size() == ProgramSize + 1;
        assert Program.get(Program.size()-1).toString().equals("down " + steps);
    }

    /**
     * Parses the command "jump" and adds it to the ArrayList
     * @throws ParserException if x or y couldn't be parsed
     * @param command must be of size 3 else the command will be ignored
     *                command[0] must be "jump"
     *                command[1] should be an integer else a ParserException will be thrown
     *                command[2] should be an integer else a ParserException will be thrown
     * This method should add a CommandJump with the parameters x y to the ArrayList
     */
    private void parseJump(String[] command)throws Exception{
        assert command[0].equals("jump");
        int ProgramSize = Program.size();
        if(command.length != 3) return;
        int x = Integer.parseInt(command[1]);
        int y = Integer.parseInt(command[2]);
        if(!(0 < x && x < SIZE && 0 < y && y < SIZE)) return;
        CommandJump commandJump = new CommandJump(x,y);
        Program.add(commandJump);
        assert Program.size() == ProgramSize + 1;
        assert Program.get(Program.size()-1).toString().equals("jump " + x + " " + y);
    }
}
