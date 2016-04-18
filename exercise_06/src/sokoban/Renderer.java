package sokoban;

/**
 * The Renderer takes a Tile[][] array, makes a String out of it
 * and prints it to the console
 *
 * This class is used by the Game to show the current state of the game
 *
 * There are only 5 types of Tiles that are allowed which are:
 * Box, Wall, Goal, Floor and Player
 *
 * When a tile is empty or it isn't one of the above an Exception is thrown
 */

public class Renderer {

    /**
     * @param board which will be printed. Shouldn't be null
     * @throws Exception if an element in the board is null ot not one of the five tiles
     *          described in the class comment
     */
    public String render(Tile[][] board) throws RenderException{
        assert board != null;
        StringBuffer representation = new StringBuffer();
        /*representation.append(board[0].length);
        representation.append(" ");
        representation.append(board.length);
        representation.append("\n");*/
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
     * @param tile to be checked if it is one of the five tiles described in the class comment
     * @throws Exception if it is not
     */
    private void checkTile(Tile tile) throws RenderException{
        switch(tile.toString()){
            default: throw new RenderException();
            case " ": return;
            case "P": return;
            case "G": return;
            case "B": return;
            case "#": return;
        }
    }

}
