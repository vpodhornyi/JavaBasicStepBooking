package exception;

public class TimeException extends RuntimeException{
  public TimeException() {
    super("Time is not correct");
  }
}
