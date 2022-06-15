package model;

public class BaseTicket extends Ticket {
  public BaseTicket(Flight flight) {
    super(flight, 105.0, "base");
  }

  public boolean isBase(){
    return true;
  }

  public String getType(){
    return "base";
  }
}
