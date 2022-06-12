package model;

import java.util.Optional;

public class BaseTicket extends Ticket {
  private Double cost;
  private Flight flight;
  private Person owner;

  public BaseTicket(Double cost, Flight flight) {
    this.cost = cost;
    this.flight = flight;
  }

  @Override
  public Optional<Person> getOwner() {
    return Optional.of(owner);
  }

  @Override
  public void setOwner(Person person) {
    this.owner = person;
  }
}
