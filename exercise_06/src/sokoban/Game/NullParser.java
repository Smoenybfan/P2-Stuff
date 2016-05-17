package sokoban.Game;

import sokoban.GameObjects.Tile;

/**
 * This is the default class for the <code>ParserLocator</code>.
 * It follows the 'Null Pattern'. 
 */
public class NullParser extends ParserLocator {

    @Override
    public Tile[][] parse(String path) {
        return null;
    }
}
