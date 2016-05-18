package sokoban.Game;

import sokoban.Exceptions.RenderException;
import sokoban.GameObjects.Tile;

/**
 * The SokobanRenderer takes a Tile[][] array, makes a String out of it
 * and prints it to the console
 *
 * This class is used by the Game to show the current state of the game
 *
 * There are only 7 types of Tiles that are allowed which are:
 * Box, Wall, Goal, Floor, Player, Bomb and BreakableWall
 *
 * When a tile is null or it isn't one of the above an Exception is thrown
 */

public class SokobanRenderer extends RendererLocator{

    /**
     * This method renders the board and returns it as a String
     * @param board which will be printed. Shouldn't be null
     * @throws RenderException if an element in the board is null ot not one of the five tiles
     *          described in the class comment
     */
    @Override
    public String render(Tile[][] board) throws RenderException{
        assert board != null;
        StringBuffer representation = new StringBuffer();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                checkTile(board[i][j]);
                representation.append(board[i][j].toString());
            }
            representation.append("\n");
        }
        return representation.toString();
    }

    /**
     * This method checks if a Tile is one of the seven above
     * @param tile to be checked if it is one of the seven tiles described in the class comment, should not be null
     * @throws RenderException if it is not
     */
    private void checkTile(Tile tile) throws RenderException{
        assert tile != null;
        switch(tile.toString()){
            default: throw new RenderException();
            case " ": return;
            case "P": return;
            case "G": return;
            case "B": return;
            case "#": return;
            case "X": return;
            case "O": return;
        }
    }

    public String toString(){
        return "Game SokobanRenderer";
    }

}
