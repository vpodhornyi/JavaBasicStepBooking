package exception;

public class NumberException  extends RuntimeException {
  public NumberException() {
    super("Number is not correct");
  }
}
