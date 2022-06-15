package exception;

public class TicketNotExist extends RuntimeException{
  public TicketNotExist() {
    super("Ticket with this ID doesn't exist");
  }
}
