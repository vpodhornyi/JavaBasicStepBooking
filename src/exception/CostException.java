package exception;

public class CostException extends RuntimeException {
  public CostException() {
    super("Cost is not correct");
  }
}
