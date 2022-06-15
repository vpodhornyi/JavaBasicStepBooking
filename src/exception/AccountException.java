package exception;

public class AccountException extends RuntimeException{
  public AccountException() {
    super("Account is not correct");
  }
}
