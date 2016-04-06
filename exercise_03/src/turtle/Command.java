package turtle;

/**
 * Interface for the commands to be executed
 */
public interface Command {
    /**
     * Executes the command
     * @param turtle the Turtle which is moved by the execution of the Program
     */
   public void execute(Turtle turtle);
}
