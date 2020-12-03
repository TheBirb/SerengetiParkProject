package Exceptions;

@SuppressWarnings("serial")
public class CaptureErrorException extends Exception {
	public CaptureErrorException() {
		
	}
	public CaptureErrorException(String mess) {
		super(mess);
	}
}
