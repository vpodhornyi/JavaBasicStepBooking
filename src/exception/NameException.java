package exception;

public class NameException extends RuntimeException {
  public NameException() {
    super("Name is not correct");
  }
}
