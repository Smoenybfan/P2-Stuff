package turtle;

/**
 * This interface is here to be abel to put all different kind of Commands
 * in one Array or one ArrayList
 *
 * A Command has only one method that must be implemented which is execute.
 *
 * It is used in the Class CommandParser where an ArrayList of the parsed Commands
 * will be created and the passed on to an instance of BoardMaker.
 */
public interface Command {
    /**
     * Executes the command
     * @param turtle the Turtle which is moved by the execution of the Program
     */
   public void execute(Turtle turtle);
}
