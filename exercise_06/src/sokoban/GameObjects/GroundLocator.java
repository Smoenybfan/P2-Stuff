package sokoban.GameObjects;

/**
 * This class provides the required type of ground Tile that
 * some Gameobject is standing on. The variable instance defines what kind of a
 * Groundtile is actual. When the type isn't defined it is set to a <code>floor</code>
 */
public abstract class GroundLocator extends Tile{
    private static GroundLocator instance;
    private static int x;
    private static int y;

    public GroundLocator(int x, int y){
        super(x,y);
        this.x=x;
        this.y=y;
    }

    public static GroundLocator instance(){
        if(instance==null){
            instance = groundLocatorDefault();
        }
        return instance;
    }

    public static void setGroundLocator(GroundLocator groundLocator){
        instance = groundLocator;
    }

    private static GroundLocator groundLocatorDefault() {
        return new Floor(x,y);
    }
}
