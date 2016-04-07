package turtle;

public class RepeatCommand extends BlockCommand {

	private static final int ARG_REPEAT_COUNT_INDEX = 0;
	
	public RepeatCommand(Token token) {
		super(token);
	}
	
	@Override
	public void execute(Turtle turtle) {
		tokenizeSubcommands();
		for (int i = 0, repeat = this.getInt(ARG_REPEAT_COUNT_INDEX); i < repeat; i++) {
			super.execute(turtle);
		}
	}

}
