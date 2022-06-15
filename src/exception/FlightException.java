package exception;

public class FlightException extends RuntimeException{
  public FlightException() {
    super("Flight with this ID doesn't exist");
  }
}
