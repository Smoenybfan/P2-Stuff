package turtle;

public class ToCommand extends BlockCommand {

	private static final int ARG_NAME_INDEX = 0;
	
	public ToCommand(Token token) {
		super(token);
	}

	@Override
	public void execute(Turtle turtle) {
		if (!isTokenized()){
			tokenizeSubcommands();
			return;
		}
		super.execute(turtle);
	}
	
	public String getName() {
		return this.getArgument(ARG_NAME_INDEX);
	}
}
