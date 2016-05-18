package sokoban.Game;

import sokoban.GameObjects.Tile;

/**
 * Created by smoen on 18.05.2016.
 */
public class NullRenderer extends RendererLocator {

    public String render(Tile[][] board){
        return null;
    }
}
