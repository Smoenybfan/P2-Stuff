package turtle;


/**
 * This class checks if the entered command is valid.
 * If the command is valid, it moves the turtle to the correct place and colors the path.
 * Otherwise it throws an Exception that will be caught by the BoardMaker Class.
 * Created by Simon on 12.03.2016.
 */
public class CommandParser {

    private String turtleProgram;
    private int xPosition;
    private int yPosition;
    private boolean[][] board;

    public CommandParser(String turtleProgram, int xPosition, int yPosition, boolean[][] board) {
        this.turtleProgram = turtleProgram;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.board = board;
    }

    /**
     * @return the board with the correct move
     */
    public String[] parse() {
        assert turtleProgram != null;
        assert invariant();

        return turtleProgram.split("\\s+");
    }

    /**
     * An invariant method for the class CommandParser
     *
     * @return true if the turtleProgram is a valid command
     */

    private boolean invariant() {

        return (parseRight() || parseLeft() || parseDown() || parseUp() || parseJump());
    }


    /**
     * Helper method that checks if the entered command is a valid "right" command
     *
     * @return true if the turtleProgram is a valid "right" command
     */

    private boolean parseRight() {
        String[] str = turtleProgram.split("\\s+");
        return (str[0] == "right" && 0 <= Integer.parseInt(str[1]) && Integer.parseInt(str[1]) <= 100);
    }

    /**
     * Helper method that checks if the entered command is a valid "left" command
     *
     * @return true if the turtleProgram is a valid "left" command
     */

    private boolean parseLeft() {
        String[] str = turtleProgram.split("\\s+");
        return (str[0] == "left" && 0 <= Integer.parseInt(str[1]) && Integer.parseInt(str[1]) <= 100);
    }

    /**
     * Helper method that checks if the entered command is a valid "up" command
     *
     * @return true if the turtleProgram is a valid "up" command
     */

    private boolean parseUp() {
        String[] str = turtleProgram.split("\\s+");
        return (str[0] == "up" && 0 <= Integer.parseInt(str[1]) && Integer.parseInt(str[1]) <= 100);
    }

    /**
     * Helper method that checks if the entered command is a valid "down" command
     *
     * @return true if the turtleProgram is a valid "down" command
     */

    private boolean parseDown() {
        String[] str = turtleProgram.split("\\s+");
        return (str[0] == "down" && 0 <= Integer.parseInt(str[1]) && Integer.parseInt(str[1]) <= 100);
    }

    /**
     * Helper method that checks if the entered command is a valid "jump" command
     *
     * @return true if the turtleProgram is a valid "jump" command
     */

    private boolean parseJump() {
        String[] str = turtleProgram.split("\\s+");
        return (str[0] == "jump" && 0 <= Integer.parseInt(str[1]) && Integer.parseInt(str[1]) <= 100 && 0 <= Integer.parseInt(str[2]) && Integer.parseInt(str[2]) <= 100);

    }


}
