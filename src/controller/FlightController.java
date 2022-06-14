package controller;

import model.Flight;
import model.Person;
import service.FlightService;
import view.ErrorView;
import view.FlightTable;

import java.util.List;
import java.util.Optional;

public class FlightController {

  private final FlightService flightService;

  public FlightController(FlightService flightService) {
    this.flightService = flightService;
  }

  public void createFlight() {

    flightService.add(null);
  }

  public void deleteFlight() {

    flightService.delete(null);
  }

  public void generateDataFLights(Person person, List<Flight> flights) {
    this.flightService.setFlights(flights);
  }

  public void printAllFlights() {

    Optional<List<Flight>> optionalFlights = flightService.findAll();

    if (optionalFlights.isPresent()) {

      List<Flight> flights = optionalFlights.get();

      if (flights.size() != 0) {
        FlightTable.showFlights(flights);
      } else {
        ErrorView.emptyFlightDataBAseError();
      }
    }
  }
}
