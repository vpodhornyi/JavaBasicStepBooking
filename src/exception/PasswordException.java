package exception;

public class PasswordException extends RuntimeException {
  public PasswordException() {
    super("Password is not correct");
  }
}
