package turtle;

/**
 * Created by daveb on 06.04.2016.
 */
public class CommandRight implements Command{

    private int steps;

    public CommandRight(int steps){
        this.steps = steps;
    }

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
}
