package turtle;

public class Token {
	private String name;
	private String arguments;
	
	private boolean invariant(){
		return name != null && !name.isEmpty();
	}
	
	public Token(String name) {
		assert name != null;
		if (name.isEmpty())
			throw new ProgramSyntaxException("Tokenizing error: name can't be empty");
		this.setToken(name);
		assert invariant();
	}

	public String getName() {
		assert invariant();
		return name;
	}

	public void setToken(String token) {
		this.name = token;
		assert invariant();
	}

	public String getArguments() {
		assert invariant();
		return arguments;
	}

	public void setArguments(String args) {
		this.arguments = args;
		assert invariant();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Token))
			return false;
		Token token = (Token) obj;
		return (token.name.equals(this.name)) && token.arguments.equals(this.arguments);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 1;
		hash = hash * prime + name.hashCode();
		return hash;
	}
	
}
