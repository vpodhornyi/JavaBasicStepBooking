package model;

public class BusinessTicket extends Ticket{
  public BusinessTicket(Flight flight) {
    super(flight, 185.0);
  }

  public boolean isBusiness(){
    return true;
  }
}
