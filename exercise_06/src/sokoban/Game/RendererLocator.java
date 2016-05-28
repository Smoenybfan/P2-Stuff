package sokoban.Game;

import sokoban.Exceptions.RenderException;
import sokoban.GameObjects.Tile;

/**
 *This class provides the required type of a Renderer a game asks for.
 * It has the variable instance, that says what kind of a Renderer is required
 * at the moment. Further it has some method that help to provide the required service.
 * The default value is a NullRenderer that follows the 'Null Pattern'
 * All kinds of Renderer should extend this class.
 *
 * The only method that this class demands from its subclasses is {@link #render(Tile[][])} Tile[]][) parse}.
 * How the subclasses parse the String they are given is up to them.
 */
public abstract class RendererLocator implements IRenderer {
    private static RendererLocator instance;

    public static IRenderer instance(){
        if(instance==null){
            instance = defaultRendererLocator();
        }
        return instance;
    }

    public static void setRendererLocator(RendererLocator rendererLocator){
        instance = rendererLocator;
    }

    private static RendererLocator defaultRendererLocator() {
        return new NullRenderer();
    }

    public abstract String render(Tile[][] board) throws RenderException;

}
