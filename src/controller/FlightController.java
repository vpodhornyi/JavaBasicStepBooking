package controller;

import exception.EmptyException;
import exception.FlightException;
import exception.FreeTicketException;
import model.Flight;
import model.Person;
import model.Ticket;
import service.FlightService;
import service.PersonService;
import view.ConsoleView;
import view.MenuView;
import view.Table;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class FlightController {
  private final FlightService flightService;
  private final PersonService personService;

  public FlightController(FlightService flightService, PersonService personService) {

    this.flightService = flightService;
    this.personService = personService;
  }

  private void bookingTicket(Flight flight, Person person, Scanner scanner) {
    Optional<Ticket> freeBaseTicket = flight.getFreeBaseTicket();
    Optional<Ticket> freeBusinessTicket = flight.getFreeBusinessTicket();

    if (freeBaseTicket.isPresent() && freeBusinessTicket.isPresent()) {
      int num = MenuView.ticketChoose(scanner);
      final int BASE_TICKET = 1;
      final int BUSINESS_TICKET = 2;

      if (num == BASE_TICKET) person.booking(freeBaseTicket.get());
      if (num == BUSINESS_TICKET) person.booking(freeBusinessTicket.get());

    } else if (freeBaseTicket.isPresent()) {
      person.booking(freeBaseTicket.get());

    } else if (freeBusinessTicket.isPresent()) {
      person.booking(freeBusinessTicket.get());

    } else {
      throw new FreeTicketException();
    }
  }

  public void bookingTicketForClient(Scanner scanner) throws FlightException {
    Map<String, String> data = ConsoleView.getFlightIdClientName(scanner);
    Flight flight = this.flightService.findById(data);
    Person person = this.personService.findByName(data);
    this.bookingTicket(flight, person, scanner);
  }

  public void bookingTicketForHimself(Scanner scanner, Person person) throws FlightException {
    Map<String, String> dataFlightId = ConsoleView.getFlightId(scanner);
    Flight flight = this.flightService.findById(dataFlightId);
    this.bookingTicket(flight, person, scanner);
  }

  public void generateDataFLights(List<Flight> flights) {
    this.flightService.setFlights(flights);
  }

  public void printAllFlights() {
    List<Flight> flights = flightService.findAll();

    if (flights.size() != 0) {
      Table.showFlights(flights);
      return;
    }

    throw new EmptyException();
  }
}
