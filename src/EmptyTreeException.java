/**
 * This class implements the exception thrown by smallest and largest.
 * 
 * @author Tala Buwadi, tbuwadi
 *
 */
public class EmptyTreeException extends RuntimeException {
	public EmptyTreeException() {
		super("Error: This Tree is Empty.");
	}
}
