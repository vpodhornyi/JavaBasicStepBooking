package service;

import model.Flight;
import model.Person;
import model.Ticket;

import java.util.List;
import java.util.Map;

public interface FlightService extends DefaultService<Flight> {

  void setFlights(List<Flight> flightList);
}
