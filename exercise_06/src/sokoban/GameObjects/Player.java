package sokoban.GameObjects;

import sokoban.Moves.Move;

/**
 * The player is a special type of a Box
 * It holds the position which inherits from the Box class
 * and a floor Tile, which is the Tile where the player is currently on (Which is either a Floor or a Goal)
 * which also inherits from the Box Class
 *
 * As a Box the Player is Stored in a Tile[][] array which represents the board of the game
 * It is used in the class SokobanParser to create the board and by the class Game which
 * then modifies it.
 *
 * The Player is capable of moving around. He can move around as long as there is a free Floor or Goal next to him
 * (Moves are horizontal and vertical). If Box is next to him he can move and move the Box as long as there is
 * space to do so. If there's a Wall he can't move.
 *
 * The move method is ther rdo dispatch the command so to finally know to move in which direction
 * The move methods to actually move the Player around all inherit from the Box class
 *
 * @see Box
 */

public class Player extends Box{

    public Player(int x, int y){
        super(x,y);
    }

    public void move(Move move, Tile[][] board){
        move.execute(this,board);
    }

    @Override
    public String toString(){
        return "P";
    }

    public Tile getFloor(){
        return this.floor;
    }

    public void setFloor(Tile tile){
        this.floor = tile;
    }

}