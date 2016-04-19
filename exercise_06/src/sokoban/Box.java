package sokoban;

/**
 * A Box is a special type of Tile
 * It holds the position which inherits from the Tile class
 * and a floor Tile, which is the Tile where the box is currently on (Could be either a Floor o a Goal)
 *
 * As a Tile a Box is Stored in a Tile[][] array which represents the board of a game
 * It is used in the class Parser to create the board and by the class Game which
 * then modifies it.
 *
 * A Box can be moved around on a board as long as there is no wall.
 *
 * This class should only be used by the Parser and the Game. It can move around but
 * to be able to only move it when a player push it, you need to implement a new Game, Parse a Board
 * and the run the Game
 *
 * A Box has a match method which will return if the Box is on a Goal.
 */

public class Box extends Tile {
    private Tile floor;

    public Box(int x, int y){
        super(x,y);
        floor = new Floor(x,y);
    }

    public String toString(){
        return "B";
    }

    /**
     * @return true when the box is on a goal
     */
    public boolean match(){
        return floor.toString().equals("G");
    }

    /**
     * This method moves this Box up, if the upper box isn't a Wall
     * @param board where the Tile is located
     * @return if the Box was moved or not
     * @see Tile for the getUpperTile() method
     */
    public boolean moveUp(Tile[][] board){
        assert board[position[0]][position[1]] == this;
        Tile upperTile = getUpperTile(board,1);
        if(upperTile.toString().equals("#")) return false; //upperTile = Wall
        if(upperTile.toString().equals("B")){ //upperTile = Box
            Box box = (Box) upperTile;
            if(box.moveUp(board)){
                swap(getUpperTile(board,1),board);
                return true;
            }
            return false;
        }
        swap(upperTile,board); //move the Box
        return true;
    }

    /**
     * This method moves this Box down, if the upper box isn't a Wall
     * @param board where the Tile is located
     * @return if the Box was moved or not
     * @see Tile for the getLowerTile() method
     */
    public boolean moveDown(Tile[][] board){
        assert board[position[0]][position[1]] == this;
        Tile lowerTile = getLowerTile(board,1);
        if(lowerTile.toString().equals("#")) return false;
        if(lowerTile.toString().equals("B")){
            Box box = (Box) lowerTile;
            if(box.moveDown(board)){
                swap(getLowerTile(board,1),board);
                return true;
            }
            return false;
        }
        swap(lowerTile,board);
        return true;
    }

    /**
     * This method moves this Box right, if the upper box isn't a Wall
     * @param board where the Tile is located
     * @return if the Box was moved or not
     * @see Tile for the getRighterTile() method
     */
    public boolean moveRight(Tile[][] board){
        assert board[position[0]][position[1]] == this;
        Tile righterTile = getRighterTile(board,1);
        if(righterTile.toString().equals("#")) return false;
        if(righterTile.toString().equals("B")){
            Box box = (Box) righterTile;
            if(box.moveRight(board)){
                swap(getRighterTile(board,1),board);
                return true;
            }
            return false;
        }
        swap(righterTile,board);
        return true;
    }

    /**
     * This method moves this Box left, if the upper box isn't a Wall
     * @param board where the Tile is located
     * @return if the Box was moved or not
     * @see Tile for the getLefterTile() method
     */
    public boolean moveLeft(Tile[][] board){
        assert board[position[0]][position[1]] == this;
        Tile lefterTile = getLefterTile(board,1);
        if(lefterTile.toString().equals("#")) return false;
        if(lefterTile.toString().equals("B")){
            Box box = (Box) lefterTile;
            if(box.moveLeft(board)){
                swap(getLefterTile(board,1),board);
                return true;
            }
            return false;
        }
        swap(lefterTile,board);
        return true;
    }

    /**
     * This method makes the actual move by swapping the Tiles on the board
     * @param destination where the player is moved should not be null an should be on the board
     *                    should either be a Floor or a Goal
     * @param board the board where the swap should take place
     */
    private void swap(Tile destination,Tile[][] board){
        assert destination != null;
        assert destination == board[destination.getY()][destination.getX()];
        assert destination.toString().equals(" ")
                || destination.toString().equals("G");
        Tile temp = this.floor;
        this.floor = destination;
        position[0] = destination.getY();
        position[1] = destination.getX();
        board[position[0]][position[1]] = this;
        board[temp.getY()][temp.getX()] = temp;
    }

    public Tile getFloor(){
        return this.floor;
    }

    public void setFloor(Tile tile){
        this.floor = tile;
    }
}
