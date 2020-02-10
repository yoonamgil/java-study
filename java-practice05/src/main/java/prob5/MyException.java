package prob5;

public class MyException extends Exception{
	private static final long serialVersionUID= 1L;
	
	
	public MyException() {
		super("stack is empty");
	}
	
	public MyException(String m) {
		super(m);
	}
	
	
	
}
