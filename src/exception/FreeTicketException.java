package exception;

public class FreeTicketException extends RuntimeException{
  public FreeTicketException() {
    super("This flight doesn't have free tickets");
  }
}
