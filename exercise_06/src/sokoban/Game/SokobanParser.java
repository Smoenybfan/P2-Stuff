package sokoban.Game;

import sokoban.Exceptions.BoxGoalException;
import sokoban.Exceptions.CouldNotIdentifyCharacterException;
import sokoban.Exceptions.InvalidSizeException;
import sokoban.Exceptions.MultiplePlayerException;
import sokoban.GameObjects.*;

import java.io.*;

/**
 * The SokobanParser takes an input String, reads the File from that String
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
 * A "P" character represents the player (also a tile), there must be only one player
 * A "B" character represents a Box tile
 * A "#" character represents a Wall tile
 * A "G" character represents a Goal tile (where the player have to put the boxes)
 * A "O" character represents a Bomb tile
 * A "X" character represents a BreakableWall tile
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

public class SokobanParser extends ParserLocator{

    private boolean hasPlayer;
    private int differenceBoxGoal = 0;

    public SokobanParser(){}

    /**
     * This method parses a level from a file which is located at the passed over path
     * @param path should be the path to a file which should have a ".sok" extension and should not be null.
     *             Should fulfill the terms described in the class comment.
     * @return a board (actually a Tile[][] array) filled with the appropriate Tiles
     * @throws java.io.FileNotFoundException if the file couldn't be found
     * @throws java.io.IOException if the reader couldn't read something from the file
     * @throws NumberFormatException if the height or the width couldn't be parsed
     * @throws InvalidSizeException if the width or the height equals to 0
     * @throws MultiplePlayerException if there is more than one Player one the board
     * @throws BoxGoalException if there aren't as many boxes as goals
     * @throws IndexOutOfBoundsException if the height or the width aren't correct
     * @throws CouldNotIdentifyCharacterException if there was a not identifiable character in the file
     */
    @Override
    public Tile[][] parse(String path) throws FileNotFoundException, IOException, NumberFormatException,
            InvalidSizeException, MultiplePlayerException, BoxGoalException, CouldNotIdentifyCharacterException{
        assert path != null;
        assert path.split("\\.")[1].equals("sok");
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file.toString()));
        int[] size = parseSize(reader);
        if(size[0] == 0 || size[1] == 0) throw new InvalidSizeException();
        Tile[][] board = new Tile[size[0]][size[1]];
        hasPlayer = false;
        parseBoard(board, reader);
        if(differenceBoxGoal != 0) throw new BoxGoalException();
        return board;
    }

    /**
     * This method parses the Size of the board meaning the height an the width
     * @param reader BufferedReader with a the File which contains the Board, it should not be null
     * @return integer array : the first element is the height and the second is the width of the board
     * @throws java.io.IOException if the reader couldn't read the first line
     * @throws NumberFormatException if the height or the width couldn't be parsed
     */
    private int[] parseSize(BufferedReader reader) throws IOException, NumberFormatException{
        assert reader != null;
        String size = reader.readLine();
        String[] splitedSize = size.split("\\s");
        return new int[] {Integer.parseInt(splitedSize[1]),Integer.parseInt(splitedSize[0])};
    }

    /**
     * This method parses the board meaning it parses every tile and puts it into the board (2-dimensional array)
     * @param board should be an empty Tile[][] array (all elements are null) and not null
     * @param reader BufferedReader with a the File which contains the Board, it should not be null
     * @throws MultiplePlayerException if there is more than one Player one the board
     * @throws java.io.IOException if the reader couldn't read a line
     */
    private void parseBoard(Tile[][] board, BufferedReader reader) throws MultiplePlayerException,
            IOException, CouldNotIdentifyCharacterException{
        assert board != null;
        assert reader != null;
        for(int height = 0; height < board.length; height++){
            String line = reader.readLine();
            for(int pos = 0; pos < board[0].length; pos++){
                board[height][pos] = newTile(line.charAt(pos),height,pos);
            }
        }
    }

    /**
     * This method parses a Tile from a given character c
     * @param c should be one of the following characters:
     *          '#',' ','G','P','X','O' or 'B', else an exception is thrown
     * @param height the y coordinate on the board, should be positive
     * @param  pos the x coordinate ont the board, should be positive
     * @return A new Tile corresponding to the character on the Position y,x
     * @throws MultiplePlayerException if there is already one Player one the board
     * @throws CouldNotIdentifyCharacterException if a c is not one of the above characters
     */
    private Tile newTile(char c, int height, int pos) throws MultiplePlayerException, CouldNotIdentifyCharacterException{
        assert height >= 0; // Need to be >= Because else the ExceptionHandling doesn't work properly
        assert pos >= 0;
        switch(c){
            default: throw new CouldNotIdentifyCharacterException();
            case '#': return new Wall(height,pos);
            case ' ': return new Floor(height,pos);
            case 'G': differenceBoxGoal--;
                return new Goal(height,pos);
            case 'P': if(hasPlayer) throw new MultiplePlayerException();
                        hasPlayer = true;
                        return new Player(height,pos);
            case 'B': differenceBoxGoal++;
                        return new Box(height,pos);
            case 'X': return new BreakableWall(height, pos);
            case 'O': return new Bomb(height, pos);
        }
    }

    public String toString(){
        return "Has player: " + hasPlayer + " Box-Goal Difference: " + differenceBoxGoal;
    }
}
