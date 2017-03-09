package egen.exception;

public class AppException extends Exception {

	private static final long serialVersionUID = 8610411474913804588L;
	public AppException(String msg){
		super(msg);
	}
	public AppException(String msg, Throwable cause){
		super(msg,cause);
	}
}
