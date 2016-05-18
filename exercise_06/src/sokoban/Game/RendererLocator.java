package sokoban.Game;

import sokoban.Exceptions.RenderException;
import sokoban.GameObjects.Tile;

/**
 * Created by smoen on 18.05.2016.
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
