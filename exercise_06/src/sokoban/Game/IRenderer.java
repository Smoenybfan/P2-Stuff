package sokoban.Game;

import sokoban.Exceptions.RenderException;
import sokoban.GameObjects.Tile;

/**
 * This Interface has the responsibility to call the right render Method
 * It is used by the <code>RendererLocator</code>.
 * @see RendererLocator
 */
public interface IRenderer {
    public String render(Tile[][] board) throws RenderException;
}
