package turtle;

/**
 * Hold the steps in the command to be executed
 *
 * In case the turtle leaves the board he returns on the other side
 *
 * invariant isn't needed, because steps is final
 */
public class CommandDown implements Command{

    private final int steps;

    public CommandDown(int steps){
        this.steps = steps;
    }

    /**
     * Executes the "down" command
     * @param turtle the Turtle which is moved by the execution of the Program
     */
    public void execute(Turtle turtle){
        int x = turtle.getX();
        int y = turtle.getY();
        boolean[][] board = turtle.getBoard();
        for (int i = 1; i <= steps ; i++) {
            y ++;
            if(y >= board.length){y -= board.length;}
            board[x][y] = true;
        }
        turtle.setY(y);
    }
}
