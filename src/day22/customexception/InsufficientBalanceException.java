package day22.customexception;

public class InsufficientBalanceException  extends Exception {
	
	public InsufficientBalanceException(String message) {
		super(message);
	}
}
