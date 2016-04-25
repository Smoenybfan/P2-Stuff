package sokoban.Moves;

import sokoban.GameObjects.Player;
import sokoban.GameObjects.Tile;

/**
 * This interface has the responsibility to call the right move method
 * This interface is used in the Classes Box,Player and Game, to move
 * The Player or a Box according to the Move Object
 *
 */

public interface Move {
    public void execute(Player player, Tile[][] board);
}
