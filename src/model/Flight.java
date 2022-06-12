package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Flight extends Id {
  City fromCity;
  City toCity;
  Airline airline;
  Airplane airplane;
  Date time;
  Set<Ticket> tickets;

  public Flight(City fromCity, City toCity, Airline airline, Airplane airplane, Date time) {
    super();
    this.fromCity = fromCity;
    this.toCity = toCity;
    this.airline = airline;
    this.airplane = airplane;
    this.time = time;
    this.tickets = new HashSet<>();
  }

  public void addTicket(Ticket ticket) {
    this.tickets.add(ticket);
  }

  public Optional<Ticket> getFreeTicket() {
    return this.tickets.stream()
        .filter(Ticket::isNotBooking)
        .findFirst();
  }

  @Override
  public String toString() {
    return "Flight{" +
        "id=" + this.getId() +
        ", fromCity=" + fromCity +
        ", toCity=" + toCity +
        ", airline=" + airline.getName() +
        ", airplane=" + airplane.getName() +
        ", time=" + time +
        ", tickets=" + tickets.size() +
        '}';
  }
}
