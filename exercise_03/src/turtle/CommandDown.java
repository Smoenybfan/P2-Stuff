package turtle;

/**
 * Created by daveb on 06.04.2016.
 */
public class CommandDown implements Command{

    private int steps;

    public CommandDown(int steps){
        this.steps = steps;
    }

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
