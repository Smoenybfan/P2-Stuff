package sokoban.GameObjects;

/**
 * A Bomb is a special type of Box
 * It holds the floor Tile, which can either be a goal or a floor and the position which
 * inherit from the Box class.
 *
 * As a Box, the Bomb is stored in a Tile[][] array which represents the board of a game
 * It is used in the class Parser to create the board and by the class Game which
 * then modifies it.
 *
 * A Bomb can be moved around on a board, as long as there is no unbreakable wall. If there is
 * such a breakable wall, then the bomb can be moved on that wall by exploding. Then both the
 * Tile of the bomb and the breakable wall become floor Tiles.
 *
 * This class should only be used by the Parser and the Game. It can move around but
 * to be able to only move it when a player push it, you need to implement a new Game, Parse a Board
 * and then run the Game
 *
 * A Bomb has an explode method that turns the BreakableWall and the bomb to Floor Tiles.
 *
 * Look out! The symbol for Bomb is a capital o, not the number zero!
 */
public class Bomb extends Box{
    private Tile floor;

    public Bomb(int y, int x){
        super(y,x);
        floor = new Floor(x,y);
    }

    @Override
    public String toString(){
        return "O";
    }

    /**
     * Overrides the method from the <code>Box</code> class. If the upperTile is a BreakableWall, it makes
     * the explosion.
     * @param board where the Tile is located
     * @return if the move was successful
     */
    @Override
    public boolean moveUp(Tile[][] board){
        assert board[position[0]][position[1]]==this;
        Tile upperTile = getUpperTile(board,1);
        if(upperTile.toString()!="X"){
            return(super.moveUp(board));
        }
        explode(this, upperTile, board);
        return true;
    }

    /**
     * Overrides the method from the <code>Box</code> class. If the lowerTile is a BreakableWall, it makes
     * the explosion. Otherwise it makes the same move as a <code>Box</code>.
     * @param board where the Tile is located
     * @return if the move was successful
     */
    @Override
    public boolean moveDown(Tile[][] board){
        assert board[position[0]][position[1]]==this;
        Tile lowerTile = getLowerTile(board,1);
        if(lowerTile.toString()!="X"){
            return(super.moveDown(board));
        }
        explode(this, lowerTile, board);
        return true;
    }

    /**
     * Overrides the method from the <code>Box</code> class. If the righterTile is a BreakableWall, it makes
     * the explosion. Otherwise it makes the same move as a <code>Box</code>.
     * @param board where the Tile is located
     * @return if the move was successful
     */
    @Override
    public boolean moveRight(Tile[][] board){
        assert board[position[0]][position[1]]==this;
        Tile righterTile = getRighterTile(board,1);
        if( righterTile.toString()!="X"){
            return(super.moveRight(board));
        }
        explode(this,  righterTile, board);
        return true;
    }

    /**
     * Overrides the method from the <code>Box</code> class. If the upperTile is a BreakableWall, it makes
     * the explosion. Otherwise it makes the same move as a <code>Box</code>.
     * @param board where the Tile is located
     * @return if the move was successful
     */
    @Override
    public boolean moveLeft(Tile[][] board){
        assert board[position[0]][position[1]]==this;
        Tile lefterTile = getLefterTile(board,1);
        if(lefterTile.toString()!="X"){
            return(super.moveLeft(board));
        }
        explode(this, lefterTile, board);
        return true;
    }

    /**
     * Makes the explosion of the bomb by setting the <code>Tile</code> of the
     * <code>BreakableWall</code> and the <code>Bomb</code>, which both exploded to <code>Floor</code>.
     * @param bomb the bomb that explodes
     * @param neighbourTile the wall that explodes. Must be a <code>BreakableWall</code>
     * @param board the board on which is played
     */
    private void explode(Bomb bomb, Tile neighbourTile, Tile[][] board) {
        assert neighbourTile.toString()=="X";

        board[bomb.getY()][bomb.getX()]=null;
        board[bomb.getY()][bomb.getY()]=new Floor(bomb.getY(),bomb.getX());
        board[neighbourTile.getY()][neighbourTile.getX()]=null;
        board[neighbourTile.getY()][neighbourTile.getX()]=new Floor(neighbourTile.getY(),neighbourTile.getY());
    }
}
