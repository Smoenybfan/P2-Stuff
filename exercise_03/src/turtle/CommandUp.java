package turtle;

/**
 * Hold the steps in the command to be executed
 *
 * In case the turtle leaves the board he returns on the other side
 *
 * invariant isn't needed, because steps isn't modified
 */

public class CommandUp implements Command {

    private int steps;

    public CommandUp(int steps){
        this.steps = steps;
    }

    public void execute(Turtle turtle){
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
}
