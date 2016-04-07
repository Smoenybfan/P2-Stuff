package turtle;

public class JumpCommand extends SimpleCommand {

	private static final int[] EXPECTED_VARIABLES_COUNT = new int[]{1,2};
	private static final int ARG_X_INDEX = 0;
	private static final int ARG_Y_INDEX = 1;
	
	public JumpCommand(Token token) {
		super(EXPECTED_VARIABLES_COUNT, token);
	}
	
	@Override
	public void execute(Turtle turtle) {
		turtle.moveTo(getInt(ARG_X_INDEX),getInt(ARG_Y_INDEX));
	}
}
