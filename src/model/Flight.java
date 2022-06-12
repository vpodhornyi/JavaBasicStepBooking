package model;

import java.util.Date;
import java.util.Set;

public class Flight {
  String serial;
  City fromCity;
  City toCity;
  Airline airline;
  Airplane airplane;
  Date time;
  Set<Ticket> tickets;

  public Flight(City fromCity, City toCity, Airline airline, Airplane airplane, Date time) {
    this.serial = "";
    this.fromCity = fromCity;
    this.toCity = toCity;
    this.airline = airline;
    this.airplane = airplane;
    this.time = time;

    this.tickets = null;
  }
}
