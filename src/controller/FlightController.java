package controller;

import exception.EmptyException;
import exception.FlightException;
import exception.FreeTicketException;
import exception.NotEnoughMoney;
import model.City;
import model.Flight;
import model.Person;
import model.Ticket;
import service.FlightService;
import service.PersonService;
import view.ConsoleView;
import view.MenuView;
import view.SuccessView;
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

  private void reduceAccount(Person person, Ticket ticket) {
    double account = person.getAccount();
    double cost = ticket.getCost();

    if (account < cost) throw new NotEnoughMoney();

    person.reduceAccount(cost);
  }

  private void bookingTicket(Flight flight, Person person, Scanner scanner) {
    Optional<Ticket> freeBaseTicket = flight.getFreeBaseTicket();
    Optional<Ticket> freeBusinessTicket = flight.getFreeBusinessTicket();

    if (freeBaseTicket.isPresent() && freeBusinessTicket.isPresent()) {
      int num = MenuView.ticketChoose(scanner);
      final int BASE_TICKET = 1;
      final int BUSINESS_TICKET = 2;


      if (num == BASE_TICKET) {
        Ticket baseTicket = freeBaseTicket.get();
        this.reduceAccount(person, baseTicket);
        person.addTicket(baseTicket);
      }
      if (num == BUSINESS_TICKET) {
        Ticket businessTicket = freeBusinessTicket.get();
        this.reduceAccount(person, businessTicket);
        person.addTicket(businessTicket);
      }

    } else if (freeBaseTicket.isPresent()) {
      Ticket baseTicket = freeBaseTicket.get();
      this.reduceAccount(person, baseTicket);
      person.addTicket(baseTicket);

    } else if (freeBusinessTicket.isPresent()) {
      Ticket businessTicket = freeBusinessTicket.get();
      this.reduceAccount(person, businessTicket);
      person.addTicket(businessTicket);

    } else {
      throw new FreeTicketException();
    }
    SuccessView.bookingSuccess();
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
    SuccessView.flightsDataGenerateSuccess();
  }

  public void printAllFlights() {
    List<Flight> flights = flightService.findAll();

    if (flights.size() != 0) {
      Table.printFlights(flights);
      return;
    }

    throw new EmptyException();
  }

  public void printFlightsWithFilter(Scanner scanner) {
    int filterNum = MenuView.flightFilterChoose(scanner);

    switch (filterNum) {
      case 1:
        Table.printFlights(this.flightService.findAllWithCityFrom(MenuView.citiesChoose(scanner)));
        break;
      case 2:
        Table.printFlights(this.flightService.findAllWithCityTo(MenuView.citiesChoose(scanner)));
        break;
     case 3:
       Table.printFlights(this.flightService.findAllWithCityFromTo(MenuView.citiesFromToChoose(scanner)));
        break;
      case 4:
        Table.printFlights(this.flightService.findAllWithAirline(MenuView.airlineChoose(scanner)));
        break;
      case 5:
        Table.printFlights(this.flightService.findAllWithAirplane(MenuView.airplaneChoose(scanner)));
        break;
      case 6:
        Table.printFlights(this.flightService.findAllWithMinCost(ConsoleView.getMinCost(scanner)));
        break;
      case 7:
        Table.printFlights(this.flightService.findAllWithTime(ConsoleView.getDate(scanner)));
      case 8:
        return;
    }
  }

  public void saveToFile() {
    this.flightService.save();
  }

  public void loadFromFile() {
    this.flightService.load();
  }
}
