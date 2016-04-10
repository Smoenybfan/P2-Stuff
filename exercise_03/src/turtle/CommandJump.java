package turtle;

/**
 * This class is responsible for the execution of the command "jump"
 * It holds the variables x and y which is the destination where to jump.
 *
 * This class is used by the class CommandParser: if a "jump" command is parsed
 * a CommandJump is created then it will be passed to an instance of BoardMaker which
 * will then move a turtle. Finally the turtle will then execute the Command.
 *
 * In case the turtle leaves the board on the right Boarder, it will return on
 * the left boarder and will be moved right by the residual steps
 *
 * invariant isn't needed, because the x and y are final
 */
public class CommandJump implements Command {
    private final int x,y;

    public CommandJump(int x,  int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Executes the "jump" command
     * Draws Red Point where the turtle jumps
     * x and y shouldn't be out of the board.
     * This is checked here because else there is no reference to SIZE of the board.
     * @param turtle the Turtle which is moved by the execution of the Program
     */
    public void execute(Turtle turtle){
        assert turtle != null;
        boolean[][] board = turtle.getBoard();
        assert x < board.length;
        assert y < board.length;
        board[x][y] = true;
        turtle.setX(x);
        turtle.setY(y);
    }

    public String toString(){
        return "jump " + x + " " + y;
    }
}
