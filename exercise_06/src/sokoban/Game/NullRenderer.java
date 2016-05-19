package sokoban.Game;

import sokoban.GameObjects.Tile;

/**
 *  This is the default class for the <code>RendererLocator</code>.
 * It follows the 'Null Pattern'.
 */
public class NullRenderer extends RendererLocator {

    public String render(Tile[][] board){
        return null;
    }
}
