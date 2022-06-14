package service;

import model.Flight;
import model.Person;
import model.Ticket;

import java.util.List;
import java.util.Map;

public interface FlightService extends DefaultService<Flight> {

  public void setFlights(List<Flight> flightList);

  public void bookingTicket(Map<String, String> data, Person person);
  public void bookingTicket(Map<String, String> data);
}
