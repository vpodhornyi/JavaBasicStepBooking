package model;

import java.io.Serializable;
import java.util.Optional;

public abstract class Ticket extends Id implements Serializable {
  private final Double cost;
  private Person owner;
  private final Flight flight;

  public Ticket(Double cost, Flight flight) {
    this.cost = cost;
    this.flight = flight;
  }

  public Optional<Person> getOwner(){
    return Optional.of(owner);
  }

  public void setOwner(Person person){
    this.owner = person;
  }

  public Double getCost() {
    return this.cost;
  }

  public Flight getFlight() {
    return this.flight;
  }
}
