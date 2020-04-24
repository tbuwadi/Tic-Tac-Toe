/**
 * This class implements the exception thrown by put.
 * 
 * @author Tala Buwadi, tbuwadi
 *
 */
public class DuplicatedKeyException extends RuntimeException {
	public DuplicatedKeyException() {
		super("Error: Key already in Dictionary.");
	}
}
