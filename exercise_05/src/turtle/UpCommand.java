package turtle;

public class UpCommand extends SimpleCommand {

	private static final int[] EXPECTED_VARIABLES_COUNT = new int[]{1,2};
	private static final int ARG_MOVES_INDEX = 0;
	
	public UpCommand(Token token) {
		super(EXPECTED_VARIABLES_COUNT, token);
	}
	
	@Override
	public void execute(Turtle turtle) {
		turtle.moveUp(getInt(ARG_MOVES_INDEX));
	}
}
