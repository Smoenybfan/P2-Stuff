package turtle;

import java.util.List;

public abstract class BlockCommand extends AbstractCommand {

	private static final int VARIABLES_COUNT = 2;
	private static final char OPEN_BRACKET = ProgramParser.BLOCK_BRACKET_OPEN;
	private static final char CLOSE_BRACKET = ProgramParser.BLOCK_BRACKET_CLOSE;
	private static final int ARG_BLOCK_INDEX = 1;
	
	private static final String VALIDITY_REGEX =
			"\\w+\\s*\\"+OPEN_BRACKET+"(?s).*\\"+CLOSE_BRACKET;
	
	private List<Token> tokens;
	private boolean tokenized = false;
	
	public BlockCommand(Token token) {
		super(new int[]{VARIABLES_COUNT}, extractArguments(token));
	}

	@Override
	public void execute(Turtle turtle) {
		for (Token token : tokens){
			Commands.createCommand(token).execute(turtle);
		}
	}
	
	protected void tokenizeSubcommands(){
		if (tokenized)
			throw new IllegalStateException("Subcommands already tokenized");
		ProgramParser parser = new ProgramParser();
		tokens = parser.tokenizeProgram(getArgument(ARG_BLOCK_INDEX));
		tokenized = true;
	}
	
	protected boolean isTokenized(){
		return tokenized;
	}
	
	private static String[] extractArguments(Token token){
		assert token != null;
		
		String argv = token.getArguments();
		assert argv != null;
		
		if (argv.isEmpty())
			throw new ProgramSyntaxException("command expects only non-empty argument");
		
		if (!argv.matches(VALIDITY_REGEX))
			throw new ProgramSyntaxException("command argument is invalid, received "+argv);
		
		int blockStartIndex = argv.indexOf(CLOSE_BRACKET);
		
		String[] arguments = new String[VARIABLES_COUNT];
		arguments[0] = argv.substring(0,blockStartIndex-1).trim();
		arguments[1] = argv.substring(blockStartIndex+1, argv.length()-1).trim();
		
		return arguments;
	}
}
