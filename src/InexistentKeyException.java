/**
 * This class implements the exception thrown remove.
 * 
 * @author Tala Buwadi, tbuwadi
 *
 */
public class InexistentKeyException extends RuntimeException {
	public InexistentKeyException() {
		super("Error: Inexistent Key.");
	}
}
