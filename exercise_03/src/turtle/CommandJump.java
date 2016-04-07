package turtle;

/**
 * Holds the x and y Position to jump
 *
 * There is no need to check whether or not x and y
 * are on the board because the Parser already does that
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
     * Draws Red Point where the turtle jumps
     * @param turtle the Turtle which is moved by the execution of the Program
     */
    public void execute(Turtle turtle){
        boolean[][] board = turtle.getBoard();
        board[this.x][this.y] = true;
        turtle.setX(x);
        turtle.setY(y);

    }
}
