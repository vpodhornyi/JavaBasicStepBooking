package model;

import java.io.Serializable;
import java.util.Optional;

public abstract class Ticket extends Id implements Serializable {
  private Person owner = null;
  private final Flight flight;
  private final Double cost;
  private final String type;

  public Ticket(Flight flight, Double cost, String type) {
    this.flight = flight;
    int costPercent = flight.getAirline().getCostPercent();
    this.cost = cost + ((cost * costPercent) / 100);
    this.type = type;
    this.flight.addTicket(this);
  }

  public boolean isBooking() {
    return this.owner != null;
  }

  public boolean isNotBooking() {
    return this.owner == null;
  }

  public Optional<Person> getOwner() {
    return Optional.of(owner);
  }

  public void deleteOwner() {
    this.owner = null;
  }

  public void setOwner(Person person) {
    this.owner = person;
  }

  public Flight getFlight() {
    return this.flight;
  }


  public Double getCost() {
    return cost;
  }

  public boolean isBase() {
    return false;
  }

  public boolean isBusiness() {
    return false;
  }

  public String getType(){
   return this.type;
  }

  @Override
  public String toString() {
    return "Ticket{" +
        ", booking=" + (this.getOwner().isPresent() ? "true" : "false") +
        ", flight=" + flight.getId() +
        '}';
  }
}
