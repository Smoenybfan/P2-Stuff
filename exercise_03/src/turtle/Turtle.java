package turtle;

/**
 * This class holds track of a Turtle moving around on a board
 *
 * It holds a board where the turtle will be moved on
 * and also the x and y Position where the turtle is currently located.
 *
 * You can move the Turtle around, but you need a Command to do so.
 * This class just executes the command. The actual movement and the red trail
 * that will be left on the board will be done by the Command itself.
 *
 * There are 5 Commands: CommandRight, CommandLeft, CommandUp, CommandDown and CommandJump
 *
 * This class checks with the invariant
 * before and after every execution, if the turtle is still on the board.
 *
 * It is used by the Class BoardMaker to make a board to an entered turtleProgram
 */
public class Turtle {
    private int x,y;
    private boolean[][] board;

    public Turtle(int x, int y, boolean[][] board){
        this.x = x;
        this.y = y;
        this.board = board;
        assert invariant();
    }

    /**
     * Moves the turtle according to a command
     * and leaves a red trail
     * @param command holds the execution,
     *                must be of type CommandLeft CommandRight, CommandUp, CommandDown or CommandJump
     */
    public void move(Command command){
        assert invariant();
        command.execute(this);
        assert invariant();
    }

    /**
     * @return if the turtle is still on the board
     */
    private boolean invariant(){return x >= 0 && x < board.length && y >= 0 && y < board.length;}

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
        assert invariant();
    }

    public void setY(int y){
        this.y = y;
        assert invariant();
    }

    public boolean[][] getBoard(){
        return board;
    }

}
