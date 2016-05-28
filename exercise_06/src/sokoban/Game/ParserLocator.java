package sokoban.Game;
import sokoban.GameObjects.*;
import sokoban.Exceptions.*;
import java.io.FileNotFoundException;

/**
 * This class provides the required type of a Parser that the game needs.
 * It has a static variable 'instance' that defines what kind of a Parser
 * the actual game is using. When the type isn't defined it is set to the
 * default that is the <code>NullParser</code> following the Null Pattern.
 * All kinds of Parsers should extend this class.
 *
 * The only method that this class demands from its subclasses is {@link #parse(String) parse}.
 * How the subclasses parse the String they are given is up to them.
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
