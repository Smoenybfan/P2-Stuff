package sokoban.test;

import sokoban.entity.BoxEntity;
import sokoban.entity.BreakableWallEntity;
import sokoban.entity.ExplosiveEntity;
import sokoban.entity.PlayerEntity;
import sokoban.game.Game;
import sokoban.game.Point;
import sokoban.game.SokobanObjectProvider;
import sokoban.game.TestObjectProvider;
import sokoban.io.input.Action;
import sokoban.io.input.InputHandler;
import sokoban.io.output.Renderer;
import sokoban.parser.PlaintextParser;
import sokoban.tile.FloorTile;
import sokoban.tile.GoalTile;
import sokoban.tile.WallTile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public abstract class TestHelper {
    protected abstract Path levelPrefix();
    protected abstract Game getGame();

    private void setRendererAndHandler(Renderer renderer, InputHandler handler) {
        TestObjectProvider provider = new TestObjectProvider(handler);
        provider.setRenderer(renderer);
        SokobanObjectProvider.setProvider(provider);
    }

    protected Action
            UP = Action.MOVE_UP,
            DOWN = Action.MOVE_DOWN,
            LEFT = Action.MOVE_LEFT,
            RIGHT = Action.MOVE_RIGHT;

    private String readFile(String path) {
        File level = Paths.get(path).toFile();
        String levelText = "";
        try {
            FileReader reader = new FileReader(level);
            BufferedReader br = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
                builder.append('\n');
            }
            levelText = builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return levelText;
    }

    protected Game parseFromFile(String filename, Renderer renderer, InputHandler inputHandler) {
        String levelText = readFile(levelPrefix().resolve(filename).toString());
        setRendererAndHandler(renderer, inputHandler);
        return new PlaintextParser().makeGameFromText(levelText);
    }

    protected void assertBoxAt(int pos) {
        assertThat(getGame().entityAt(new Point(1, pos)), instanceOf(BoxEntity.class));
    }

    protected void assertNoEntityAt(int pos) {
        assertFalse(getGame().hasEntityAt(new Point(1, pos)));
    }

    protected void assertPlayerAt(int pos) {
        assertThat(getGame().entityAt(new Point(1, pos)), instanceOf(PlayerEntity.class));
    }

    protected void assertExplosiveAt(int pos) {
        assertThat(getGame().entityAt(new Point(1, pos)), instanceOf(ExplosiveEntity.class));
    }

    protected void assertBreakableAt(int pos) {
        assertThat(getGame().entityAt(new Point(1, pos)), instanceOf(BreakableWallEntity.class));
    }

    protected void assertFloorAt(int pos) {
        assertThat(getGame().tileAt(new Point(1, pos)), instanceOf(FloorTile.class));
    }

    protected void assertWallAt(int pos) {
        assertThat(getGame().tileAt(new Point(1, pos)), instanceOf(WallTile.class));
    }

    protected void assertGoalAt(int pos) {
        assertThat(getGame().tileAt(new Point(1, pos)), instanceOf(GoalTile.class));
    }
}
