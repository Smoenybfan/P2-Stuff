package turtle;

/**
 * Moves a turtle around on a board
 *
 */

public class Turtle {
    private int x,y;
    private boolean[][] board;

    public Turtle(int x, int y, boolean[][] board){
        this.x = x;
        this.y = y;
        this.board = board;
        assert invariant();
    }


    public void move(Command command){
        assert invariant();
        command.execute(this);
        assert invariant();
    }

    private boolean invariant(){return x > 0 && x < board.length && y > 0 && y < board.length;}

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
        assert invariant();
    }

    public void setY(int y){
        this.y = y;
        assert invariant();
    }

    public boolean[][] getBoard(){
        return board;
    }

}
