package service;

import model.Flight;

import java.util.List;

public interface FlightService extends DefaultService<Flight> {

  public void setFlights(List<Flight> flightList);
}
