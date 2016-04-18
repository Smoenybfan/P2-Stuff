package sokoban;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * The Parser takes an input String, reads the File from that String
 * parses it an returns a board filled with the appropriate tiles
 *
 * This class is used by the Game to initialize the board.
 *
 * If you want to use this class you need a new instance of it and then simply call the
 * parse method with a String which is the path to the file you want to parse.
 * The ending of the File should be ".sok"
 * If the file doesn't exist, the parser couldn't read from the file,
 * the height or the width couldn't be parsed, the height or the width equals to 0
 * ,there is more than one Player on the board
 * or there aren't as many boxes as goals an Exception is thrown
 *
 * The file have to be in the following order:
 * In the first line are two integers which are the width and the height of the field
 * between them has to be one space and one space only
 * After that line comes the board:
 * A " " character represents floor tile
 * A "P" character represents the player (also a tile), there has to be only one player
 * A "B" character represents a Box tile
 * A "#" character represents a Wall tile
 * A "G" character represents a Goal tile (where the player have to put the boxes)
 *
 * There have to be as many Boxes as there are Goals
 *
 * If there are more characters as described with the first two parameters (height and width)
 * they just wont be parsed
 *
 * Since the Parses holds only the hasPlayer attribute and the differenceBoxGoal which
 * will be caught by an exception if they don't have the right value,
 * there is no need for an invariant
 */

public class Parser {

    private boolean hasPlayer;
    private int differenceBoxGoal = 0;

    public Parser(){}

    /**
     *
     * @param path should be the path to a file which should have a ".sok" extension and should not be null.
     *             Should fulfill the terms described in the class comment.
     * @return a board (actually a Tile[][] array) filled with the appropriate Tiles
     * @throws Exception if the file doesn't exists, the Parser couldn't read from the file
     *          the height or width couldn't be parsed, one of them equals to 0, if there is already one
     *          player on the board or there aren't as many boxes as goals on the board.
     */
    public Tile[][] parse(String path) throws Exception{
        assert path != null;
        assert path.split("\\.")[1].equals("sok");
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file.toString()));
        int[] size = parseSize(reader);
        if(size[0] == 0 || size[1] == 0) throw new Exception();
        Tile[][] board = new Tile[size[0]][size[1]];
        hasPlayer = false;
        parseBoard(board, reader);
        if(differenceBoxGoal != 0) throw new Exception();
        return board;
    }

    /**
     *
     * @param reader BufferedReader with a the File which contains the Board, it should not be null
     * @return integer array : the first element is the height and the second is the width of the board
     * @throws Exception if the height or the width couldn't be parsed or the reader couldn't read the first line
     */
    private int[] parseSize(BufferedReader reader) throws Exception{
        assert reader != null;
        String size = reader.readLine();
        String[] splitedSize = size.split("\\s");
        return new int[] {Integer.parseInt(splitedSize[1]),Integer.parseInt(splitedSize[0])};
    }

    /**
     *
     * @param board should be an empty Tile[][] array (all elements are null) and not null
     * @param reader BufferedReader with a the File which contains the Board, it should not be null
     * @throws Exception if the reader couldn't read a line or there is already one Player one the board
     */
    private void parseBoard(Tile[][] board, BufferedReader reader) throws Exception{
        assert board != null;
        for(int height = 0; height < board.length; height++){
            String line = reader.readLine();
            for(int pos = 0; pos < board[0].length; pos++){
                board[height][pos] = parseTile(line.charAt(pos),height,pos);
            }
        }
    }

    /**
     * @param c should be one of the following characters:
     *          '#',' ','G','P' or 'B'.
     * @param height the y coordinate on the board
     * @param  pos the x coordinate ont the board
     * @return A new Tile corresponding to the character on the Position x,y
     * @throws Exception if there is already one Player one the board
     */
    private Tile parseTile(char c, int height, int pos) throws Exception{
        switch(c){
             default: assert false;
            case '#': return new Wall(height,pos);
            case ' ': return new Floor(height,pos);
            case 'G': differenceBoxGoal--;
                return new Goal(height,pos);
            case 'P': if(hasPlayer) throw new Exception();
                        hasPlayer = true;
                        return new Player(height,pos);
            case 'B': differenceBoxGoal++;
                return new Box(height,pos);
        }
    }
}
