package turtle;

/**
 * Hold the steps in the command to be executed
 *
 * In case the turtle leaves the board he returns on the other side
 *
 * invariant isn't needed, because steps is final
 */
public class CommandRight implements Command{
    private final int steps;

    public CommandRight(int steps){
        this.steps = steps;
    }

    /**
     * Executes the "right" command
     * Leaves a red trail on the board where the turtle moves on
     * @param turtle the Turtle which is moved by the execution of the Program
     */
    public void execute(Turtle turtle){
        int x = turtle.getX();
        int y = turtle.getY();
        boolean[][] board = turtle.getBoard();
        for (int i = 1; i <= steps ; i++) {
            x ++;
            if(x >= board.length){x -= board.length;}
            board[x][y] = true;
        }
        turtle.setX(x);
    }

    public String toString(){
        return "right " + steps;
    }
}
