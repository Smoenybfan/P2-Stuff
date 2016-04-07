package turtle;

public abstract class SimpleCommand extends AbstractCommand {

	private static final String ARGUMENTS_SPLIT_REGEX = "\\s*,\\s*";
	
	public SimpleCommand(int[] argc, Token token) {
		super(argc, extractArguments(token));
	}
	
	protected static String[] extractArguments(Token token) {
		assert token != null;
		String argv = token.getArguments();
		assert argv != null;
		
		return argv.split(ARGUMENTS_SPLIT_REGEX);
	}

}
