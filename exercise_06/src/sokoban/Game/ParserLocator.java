package sokoban.Game;
import sokoban.GameObjects.*;
import sokoban.Exceptions.*;
import java.io.FileNotFoundException;

/**
 * This class provides the required type of a SokobanParser that the game needs.
 * It has a static variable 'instance' that defines what kind of a SokobanParser
 * the actual game is using. When the type isn't defined it is set to the
 * default that is the <code>NullParser</code> following the Null Patern.
 * All kinds of SokobanParser should extend this class.
 */
public abstract class ParserLocator {
    private static ParserLocator instance;

    protected ParserLocator(){

    }

    public static ParserLocator instance(){
        if(instance==null){
            instance = defaultParserLocator();
        }
        return instance;
    }

    private static ParserLocator defaultParserLocator() {

        return new NullParser();
    }

    public static void setParserLocator(ParserLocator parserLocator){
        instance=parserLocator;
    }

    public abstract Tile[][] parse(String path) throws Exception;

}
