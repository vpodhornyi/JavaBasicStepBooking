package controller;

import exception.EmptyException;
import exception.FlightException;
import exception.FreeTicketException;
import model.Flight;
import model.Person;
import model.Ticket;
import service.FlightService;
import view.ConsoleView;
import view.FlightTable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

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

  public Flight getFlightById(Scanner scanner) {
    Map<String, String > data = ConsoleView.getFlightId(scanner);

    return this.flightService.findById(data);
  }

  public void bookingTicketForHimself(Scanner scanner, Person person) throws FlightException {
    Map<String, String > data = ConsoleView.getFlightId(scanner);
    this.flightService.bookingTicket(data, person);
  }

  public void bookingTicketForClient(Scanner scanner) throws FlightException {
    Map<String, String > data = ConsoleView.getFlightIdClientName(scanner);
    this.flightService.bookingTicket(data);
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
        return;
      }

      throw new EmptyException();
    }
  }
}
