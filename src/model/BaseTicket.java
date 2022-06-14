package model;

public class BaseTicket extends Ticket {
  public BaseTicket(Flight flight) {
    super(flight, 100.0);
  }

  public boolean isBase(){
    return true;
  }
}
