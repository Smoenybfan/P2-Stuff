package turtle;

/**
 * Holds the x and y Position to jump
 *
 * If the two Positions are on the board is already checked
 * when the turtleProgram is parsed
 *
 * invariant isn't needed, because x,y are final
 */
public class CommandJump implements Command {

    private final int x,y;

    public CommandJump(int x,  int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Executes the "jump" command
     * @param turtle the Turtle which is moved by the execution of the Program
     */
    public void execute(Turtle turtle){
        boolean[][] board = turtle.getBoard();
        board[this.x][this.y] = true;
        turtle.setX(x);
        turtle.setY(y);

    }
}
