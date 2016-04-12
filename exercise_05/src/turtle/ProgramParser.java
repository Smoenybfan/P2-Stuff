package turtle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ProgramParser tokenizes a set of commands from a string program.
 * <p>
 * The parser accepts all possible commands, while they should fit some criterion.
 * The name of the command and the arguments are separated by any number of spaces.
 * Also, there can be any number of spaces before or after a command.
 * Each command ends with <code>COMMAND_DELIMITER</code> character.
 * <p>
 * The name of a command is case insensitive. So <code>left 10;</code>, 
 * <code>LeFt 10;</code> and <code>LEFT 10;</code> are all valid commands.
 * <p>
 * Each command is translated into a <code>Token</code> object using
 * <code>ProgramParser#tokenizeCommand(String command)</code> method.
 * <code>Token</code>s are used to create <code>Command</code> objects
 * based on the mappings specified in {@link Commands}.  
 */
public class ProgramParser {
	
	private static final char COMMAND_DELIMITER = ';';
	public static final char BLOCK_BRACKET_OPEN = '{';
	public static final char BLOCK_BRACKET_CLOSE = '}';
	public static final char SPACE = ' ';
	
	private static final String TOKEN_SPLIT_REGEX = "\\s\\w*(\\s*(?s).*)|;";
	
	/**
	 * Tokenizes a whole program. <b>Program must not be null.</b>
	 * As first step, tries to split program into command blocks and then
	 * tokenizes them. May throw <code>ProgramSyntaxException</code> exception
	 * if something went wrong during splitting or tokenizing process.
	 * 
	 * @param program <code>String</code> representation of turtle program to be tokenized
	 * @return <code>List</code> containing corresponding Tokens of commands.
	 * @see ProgramParser#split
	 * @see ProgramParser#tokenizeCommand
	 */
	public List<Token> tokenizeProgram(String program) {
		assert program != null;
		
		String[] commandBlocks = split(program);
		List<Token> tokens = new LinkedList<Token>();
		
		for (String command : commandBlocks) {
			tokens.add(tokenizeCommand(command));
		}
		return tokens;
	}
	
	/**
	 * Splits turtle program into command blocks. <b>Program must not be null</b>,
	 * otherwise behavior is undefined.
	 * <p>
	 * Algorithm goes through only first level blocks and splits commands separated
	 * with <code>COMMAND_DELIMITER</code> into strings and returns them as array
	 * Also it simply validates syntax correctness by counting the number of open and
	 * close brackets. Their number must be equal. Each open bracket mean,
	 * that somewhere later in program there must be a pair bracket.
	 * While iterating through all program characters splitter puts brackets
	 * in the stack to validate pair. If any inconsistencies are found
	 * <code>ProgrammSyntaxException</code> is thrown.
	 * 
	 * @param program - string representation of turtle program, inputed by user 
	 * @return <code>String[]</code> array, containing splitted first level commands
	 * 			as it's elements
	 * @throws ProgramSyntaxException if program's syntax is invalid. Most often it means,
	 * 			that there are problems with open/close brackets.
	 */
	protected String[] split(String program) {
		assert program != null;
		
		ArrayList<String> blocks = new ArrayList<String>();
		Stack<Character> brackets = new Stack<Character>();
		
		char currentChar;
		int blockStartIndex = 0;
		
		for (int i = 0, length = program.length(); i < length;i++) {
			currentChar = program.charAt(i);
			switch (currentChar){			
				case BLOCK_BRACKET_OPEN: {
					brackets.push(currentChar);
					break;
				}
				case BLOCK_BRACKET_CLOSE: {
					if (brackets.isEmpty())
						throw new ProgramSyntaxException("Close bracket found, that was never opened at '"+ i +"' position");	
					if (brackets.lastElement().charValue() != BLOCK_BRACKET_OPEN)
						throw new ProgramSyntaxException("Close bracket found, but wasn't opened, at '"+ i +"' position");
					brackets.pop();
					break;
				}
				case COMMAND_DELIMITER: {
					if (brackets.isEmpty()){
						blocks.add(program.substring(blockStartIndex, ++i));
						blockStartIndex = i;
						while (blockStartIndex<length-1&& program.charAt(blockStartIndex)==' ' ){
							blockStartIndex++;
						}
					}
					break;
				}
			}
		}
		if (!brackets.isEmpty())
			throw new ProgramSyntaxException("Incorrect number of block brackets, left: "+brackets.toString());
		return blocks.toArray(new String[blocks.size()]);
	}
	
	/**
	 * Tokenizes one single command. <b>Command must not be null and must not start or end with SPACE.</b>
	 * As result creates new <code>Token</code> object containing splitted command name
	 * and command arguments in <code>String</code> representation. 
	 * <ul>
	 * Input command should fit several criterion:
	 * <li>should not be empty</li>
	 * <li>should end with <code>COMMAND_DELIMITER</code></li>
	 * <li>should contain only one <code>COMMAND_DELIMITER</code></li>
	 * Otherwise <code>ProgramSyntaxException</code> is thrown
	 * </ul>
	 * 
	 * @param command - <code>String</code> command to be tokenized
	 * @return <code>Token</code> object containing tokenized command
	 * @throws ProgramSyntaxException in case there were any tokenizing errors as described above
	 */
	protected Token tokenizeCommand(String command) {
		assert command != null;
		assert !command.startsWith(""+SPACE);
		assert !command.endsWith(""+SPACE);
	
		if (command.isEmpty())
			throw new ProgramSyntaxException("Tokenizing error: command can't be empty");
		
		if (!command.endsWith(""+COMMAND_DELIMITER))
			throw new ProgramSyntaxException("Tokenizing error: command must end with '"+COMMAND_DELIMITER+"'");
		
		String[] tokenArray = command.split(TOKEN_SPLIT_REGEX);
		
		if (tokenArray.length != 1)
			throw new ProgramSyntaxException("Tokenizing error: was unable to extract command token");
		
		Token token = new Token(tokenArray[0]);
		String params = command.substring(token.getName().length(), command.length()-1).trim();
		token.setArguments(params);
		
		return token;
	}
}
