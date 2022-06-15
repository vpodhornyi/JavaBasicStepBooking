package exception;

public class EmptyException extends RuntimeException {
  public EmptyException() {
    super("No data to show");
  }
}
