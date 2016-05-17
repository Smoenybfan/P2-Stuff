package sokoban.Game;

import sokoban.GameObjects.Tile;

/**
 * Created by smoen on 17.05.2016.
 */
public class NullParser extends ParserLocator {

    @Override
    public Tile[][] parse(String path) {
        return null;
    }
}
