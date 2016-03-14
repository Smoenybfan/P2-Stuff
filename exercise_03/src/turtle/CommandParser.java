package turtle;

/**
 * This class checks if the entered command is valid.
 * If the command is valid, it returns it to the BoardMaker.
 * Otherwise it throws an Exception that will be caught by the BoardMaker Class.
 * Created by Simon on 12.03.2016.
 */
public class CommandParser {

    private String[] command;
    private int x,y;
    private int SIZE;

    public CommandParser(String command,int x, int y, int SIZE) {
        this.command = command.split("\\s+");
        this.x = x;
        this.y = y;
        this.SIZE = SIZE;
        assert invariant();
    }

    /**
     * @return the board with the correct move
     */
    public String[] parse() throws ParserException {
        assert invariant();
        if(parseCommand()){
            return command;
        }
        throw new ParserException();
    }

    /**
     * @return true if there is a command
     */
    private boolean invariant() {
        return (command.length > 0);
    }

    private boolean parseCommand(){
        switch(command[0]){
            case "right": return parseRight();
            case "left" : return parseLeft();
            case "up": return parseUp();
            case "down": return parseDown();
            case "jump": return parseJump();
            default: return false;
        }
    }

    private boolean parseRight() {
        return command.length == 2 && (Integer.parseInt(command[1]) >= 0 && x + Integer.parseInt(command[1]) <= SIZE);
    }

    private boolean parseLeft() {
        return command.length == 2 && (Integer.parseInt(command[1]) >= 0 && x - Integer.parseInt(command[1]) >= 0);
    }

    private boolean parseUp() {
        return command.length == 2 && (Integer.parseInt(command[1]) >= 0 && y - Integer.parseInt(command[1]) >= 0);
    }

    private boolean parseDown() {
        return command.length == 2 && (Integer.parseInt(command[1]) >= 0 && y + Integer.parseInt(command[1]) <= SIZE);
    }

    private boolean parseJump() {
        return command.length == 3 && (0 <= Integer.parseInt(command[1]) && Integer.parseInt(command[1]) <= SIZE
                        && 0 <= Integer.parseInt(command[2]) && Integer.parseInt(command[2]) <= SIZE);
    }



}
