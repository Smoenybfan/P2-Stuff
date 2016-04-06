package turtle;

/**
 * Creates
 */

public class CommandJump implements Command {

    private int x,y;

    public CommandJump(int x,  int y){
        this.x = x;
        this.y = y;
    }

    public void execute(Turtle turtle){
        boolean[][] board = turtle.getBoard();
        board[this.x][this.y] = true;
        turtle.setX(x);
        turtle.setY(y);

    }
}
