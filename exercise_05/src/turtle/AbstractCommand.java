package turtle;

import java.util.Arrays;

public abstract class AbstractCommand implements Command {

	private final String[] arguments;
	
	public AbstractCommand(int[] argc, String[] argv){
		assert argc != null;
		assert argv != null;
		
		Arrays.sort(argc);
		
		if (Arrays.binarySearch(argc,argv.length) < 0)
			throw new ProgramSyntaxException("Wrong arguments number, expected "+Arrays.toString(argc)
					+ " but was "+argv.length + " "+ Arrays.toString(argv));
		
		this.arguments = argv;
	}
	
	protected String getArgument(int index) {
		assert index >= 0 && index < arguments.length;
		return arguments[index];
	}
	
	protected int getInt(int index){
		try {
			return Integer.parseInt(getArgument(index));
		}
		catch (NumberFormatException e){
			throw new ProgramSyntaxException("Argument "+index+" must be an integer but was "+ Arrays.toString(arguments));
		}
	}
	
	protected int getArgCount(){
		assert arguments != null;
		
		return arguments.length;
	}
	
	
}
