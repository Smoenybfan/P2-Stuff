package turtle;

/**
 * This class is responsible for the execution of the command "up"
 * It holds the variable steps which is how many steps the turtle
 * which executes the command will be moved up on the according board.
 *
 * This class is used by the class CommandParser: if an "up" command is parsed
 * a CommandUp is created then it will be passed to an instance of BoardMaker which
 * will then move a turtle. Finally the turtle will then execute the Command.
 *
 * In case the turtle leaves the board on the upper Boarder, it will return on
 * the bottom Boarder and will be moved up by the residual steps
 *
 * invariant isn't needed, because the steps are final
 */
public class CommandUp implements Command {
    private final int steps;

    public CommandUp(int steps){
        this.steps = steps;
    }

    /**
     * Executes the "up" command
     * Leaves a red trail on the board where the turtle moves on
     * @param turtle the Turtle which is moved by the execution of the Program
     */
    public void execute(Turtle turtle){
        assert turtle != null;
        int x = turtle.getX();
        int y = turtle.getY();
        boolean[][] board = turtle.getBoard();
        for (int i = 1; i <= steps; i++) {
            y --;
            if(y < 0){y += board.length;}
            board[x][y] = true;
        }
        turtle.setY(y);
    }

    public String toString(){
        return "up " + steps;
    }
}
