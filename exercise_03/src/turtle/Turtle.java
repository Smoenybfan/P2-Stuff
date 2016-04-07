package turtle;

/**
 * Moves a turtle around on a board
 * The board must be of size SIZExSIZE
 *
 * the invariant checks if the turtle is still on the board
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

    /**
     * Moves the turtle according to a command
     * and leaves a red trail
     * @param command holds the execution,
     *                must be of type CommandLeft CommandRight, CommandUp, CommandDown or CommandJump
     */
    public void move(Command command){
        assert invariant();
        command.execute(this);
        assert invariant();
    }

    /**
     * @return if the turtle is still on the board
     */
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
