package tp_mock;

public class CompteInexistantException extends Exception {
	private static final long serialVersionUID = 1L;

	public CompteInexistantException() {
		super();
	}

	public CompteInexistantException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompteInexistantException(String message) {
		super(message);
	}

	public CompteInexistantException(Throwable cause) {
		super(cause);
	}	
}
