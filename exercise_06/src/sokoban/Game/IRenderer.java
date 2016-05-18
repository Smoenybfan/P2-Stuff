package sokoban.Game;

import sokoban.Exceptions.RenderException;
import sokoban.GameObjects.Tile;

/**
 * Created by smoen on 18.05.2016.
 */
public interface IRenderer {
    public String render(Tile[][] board) throws RenderException;
}
