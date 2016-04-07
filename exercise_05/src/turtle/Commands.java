package turtle;

import java.util.HashMap;

/**
 * The <code>Commands</code> enumeration holds a list of all valid command names and
 * maps each command name to a subclass of {@link Command}.
 * It can further, for each command name, create an object of the 
 * corresponding type. 
 */
enum Commands implements CommandsFactory {
	UP {
		@Override
		public Command create(Token token) {
			return new UpCommand(token);
		}
	},
	
	DOWN {
		@Override
		public Command create(Token token) {
			return new DownCommand(token);
		}
	},
	
	LEFT {
		@Override
		public Command create(Token token) {
			return new LeftCommand(token);
		}
	},
	
	RIGHT {
		@Override
		public Command create(Token token) {
			return new RightCommand(token);
		}
	},
	
	JUMP {
		@Override
		public Command create(Token token) {
			return new JumpCommand(token);
		}
	},
	
	REPEAT {
		@Override
		public Command create(Token token) {
			return new RepeatCommand(token);
		}
	},
	
	COLOR {
		@Override
		public Command create(Token token) {
			return new ColorCommand(token);
		}
	},
	
	TO {
		private HashMap<String,Command> customCommands = new HashMap<String,Command> ();
		
		@Override
		public Command create(Token token) {
			assert token != null;
			
			if (isExists(token)){
				return customCommands.get(token.getName());
			}
			
			if (!token.getName().toUpperCase().equals(TO.name()))
				throw new UnknownCommandException("Unknown command: " + token.getName());
			
			return makeCustomCommand(token);
		}
		
		/**
		 * Checks by token name if custom command is already defined and returns true,
		 * otherwise false.
		 * <p>
		 * <b>token must not be null</b>
		 * @param token - <code>Token</code> of possible custom command
		 * @return true if command already defined, otherwise false
		 */
		private boolean isExists(Token token) {
			assert token != null;
			return customCommands.containsKey(token.getName());
		}
		
		/**
		 * Instantiates a new custom command and puts it in <code>HashMap</code>
		 * of known and defined commands. Execution of newly created command
		 * takes two steps. First call of {@link Command#execute(Turtle)} tokenizes
		 * command's subroutine and all next calls actually execute it.
		 * <p>
		 * <b>token must not be null</b>
		 * @param token - <code>Token</code> object of <code>Commands.TO</code> command
		 * 			to be used to create new custom one.
		 * @return <code>Command</code> object of new defined custom command.
		 */
		private Command makeCustomCommand(Token token){
			assert token != null;
			ToCommand command = new ToCommand(token);
			customCommands.put(command.getName(), command);
			return command;
		}
	};
	
	/**
	 * Creates a corresponding type of <code>Command</code> object. If passed token
	 * doesn't matches any predefined command, algorithm tries to find out if command
	 * is user-defined. If yes, returns custom command, otherwise throws exception.
	 * <p>
	 * <b>token must not be null</b>, otherwise behavior is undefined.
	 * 
	 * @param token - <code>Token</code> object to be used to create
	 * 		<code>Command</code> by it's name.
	 * @return <code>Command</code> object of special type based on passed <code>Token</code>
	 * 			or user defined command if it exists.
	 * @throws ProgramSyntaxException in case of unknown command
	 */
	public static Command createCommand(Token token) {
		assert token != null;
		try {
			return Commands.valueOf(token.getName().toUpperCase()).create(token);
		} catch (IllegalArgumentException e){
			try {
				return TO.create(token);
			} catch (UnknownCommandException e1){
				throw new ProgramSyntaxException(e1.getMessage());
			}
		}
	}
	
	
}
