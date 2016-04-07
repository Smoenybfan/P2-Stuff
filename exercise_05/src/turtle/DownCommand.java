package turtle;

public class DownCommand extends SimpleCommand {

	private static final int[] EXPECTED_VARIABLES_COUNT = new int[]{1,2};
	private static final int ARG_MOVES_INDEX = 0;
	
	public DownCommand(Token token) {
		super(EXPECTED_VARIABLES_COUNT, token);
	}

	@Override
	public void execute(Turtle turtle) {
		turtle.moveDown(getInt(ARG_MOVES_INDEX));
	}

}
