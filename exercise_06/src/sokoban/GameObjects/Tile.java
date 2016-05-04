package sokoban.GameObjects;

/**
 * A Tile holds the position on the board
 *
 * It is used to create a Tile[][] board by the parser
 * and later on in the Game to have a data-structure capable
 * of holding the information about the game
 *
 * It can get you every Tile from the same board, if you provide it with the correct board
 *
 * It should only be used by the Parser and Game Class.
 */

public class  Tile{
    public void setPosition(int[] position) {
        this.position = position;
    }

    protected int[] position;

    public int[] getPosition(){return this.position.clone();}

    public Tile(int y, int x){
        position = new int[2];
        position[0] = y;
        position[1] = x;
    }

    public boolean equals(Object object){
        if(object == null) return false;
        if(!Tile.class.isAssignableFrom(object.getClass())) return false;
        final Tile tile = (Tile) object;
        if(tile.position[0] != this.position[0]) return false;
        if(tile.position[1] != this.position[1]) return false;
        return object.getClass().equals(this.getClass());
    }

    /**
     * @param board board which should contains this tile
     * @param index how much steps you want to go,
     *              "y position of this tile" - index should be greater or equal to 0
     * @return tile which lies index positions over this one
     */
    protected Tile getUpperTile(Tile[][] board, int index){
        assert board[position[0]][position[1]] == this;
        assert position[0] - index >= 0;
        return board[position[0]-index][position[1]];
    }

    /**
     * @param board board which should contains this tile
     * @param index how much steps you want to go,
     *              "y position of this tile" + index should be smaller than the height of the board
     * @return tile which lies index positions under this one
     */
    protected Tile getLowerTile(Tile[][] board, int index){
        assert board[position[0]][position[1]] == this;
        assert position[0] + index < board.length;
        return board[position[0] + index][position[1]];
    }

    /**
     * @param board board which should contains this tile
     * @param index how much steps you want to go,
     *              "x position of this tile" + index should be smaller than the width of the board
     * @return tile which lies index positions right this one
     */
    protected Tile getRighterTile(Tile[][] board, int index){
        assert board[position[0]][position[1]] == this;
        assert position[0] + index < board[0].length;
        return board[position[0]][position[1] + index];
    }

    /**
     * @param board board which should contains this tile
     * @param index how much steps you want to go,
     *              "x position of this tile" - index should be greater or equal to 0
     * @return tile which lies index positions left this one
     */
    protected Tile getLefterTile(Tile[][] board, int index){
        assert board[position[0]][position[1]] == this;
        assert position[0] - index >= 0;
        return board[position[0]][position[1] - index];
    }



    public int getX(){
        return position[1];
    }

    public int getY(){
        return  position[0];
    }

    public void setX(int value){
        position[1]=value;
    }

    public void setY(int value){
        position[0]=value;

    }

    public String toString(){
        return "No type";
    }
}