package controller;

import model.Flight;
import service.FlightService;

import java.util.List;
import java.util.Optional;

public class FlightController {

  private final FlightService flightService;

  public FlightController(FlightService flightService) {
    this.flightService = flightService;
  }

  public void createFlight(){

    flightService.add(null);
  }

  public void deleteFlight() {

    flightService.delete(null);
  }

  public void printAllFlights() {


  List<Flight> optionalFlight = flightService.findAll();
  }
}
