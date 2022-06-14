package model;

import java.io.Serializable;
import java.util.Optional;

public abstract class Ticket extends Id implements Serializable {
  private Person owner = null;
  private final Flight flight;

  public Ticket(Flight flight) {
    this.flight = flight;
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

  @Override
  public String toString() {
    return "Ticket{" +
        ", booking=" + (this.getOwner().isPresent() ? "true" : "false") +
        ", flight=" + flight.getId() +
        '}';
  }
}
