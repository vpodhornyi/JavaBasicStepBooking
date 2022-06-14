package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Flight extends Id {
  City fromCity;
  City toCity;
  Airline airline;
  Airplane airplane;
  long time;
  Set<Ticket> tickets;

  public Flight(City fromCity, City toCity, Airline airline, Airplane airplane, long time) {
    super();
    this.fromCity = fromCity;
    this.toCity = toCity;
    this.airline = airline;
    this.airplane = airplane;
    this.time = time;
    this.tickets = new HashSet<>();
  }

  public void setTickets(Set<Ticket> tickets) {
    this.tickets = tickets;
  }

  public void addTicket(Ticket ticket) {
    this.tickets.add(ticket);
  }

  public Airplane getAirplane() {
    return airplane;
  }

  public City getFromCity() {
    return fromCity;
  }

  public City getToCity() {
    return toCity;
  }

  public Airline getAirline() {
    return airline;
  }

  public String getTime() {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(this.time));
  }

  public Set<Ticket> getTickets() {
    return new HashSet<>(this.tickets);
  }

  public Optional<Ticket> getFreeTicket() {
    return this.tickets.stream()
        .filter(Ticket::isNotBooking)
        .findFirst();
  }

  public long getCountOfFreeTickets() {

    return this.tickets.stream()
        .filter(Ticket::isNotBooking)
        .count();
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
