package turtle;

public class UnknownCommandException extends RuntimeException {
	private static final long serialVersionUID = -3550763497931790266L;

	public UnknownCommandException(String msg){
		super(msg);
	}
}
