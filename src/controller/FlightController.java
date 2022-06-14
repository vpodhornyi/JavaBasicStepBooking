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

  public Flight getFlightById(Scanner scanner) throws FlightException {
    String id = ConsoleView.string(scanner, "Enter flight id :");
    Optional<Flight> optionalFlight = this.flightService.findById(id);

    if (optionalFlight.isPresent()) return optionalFlight.get();

    throw new FlightException();
  }

  public Ticket getTicketByFlightId(Scanner scanner) throws FlightException {
    String id = ConsoleView.string(scanner, "Enter flight id :");
    Optional<Flight> optionalFlight = this.flightService.findById(id);

    if (optionalFlight.isPresent()) {
      Flight flight = optionalFlight.get();

      Optional<Ticket> optionalTicket = flight.getFreeTicket();

      if (optionalTicket.isPresent()) return optionalTicket.get();

      throw new FreeTicketException();
    }
    throw new FlightException();
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
