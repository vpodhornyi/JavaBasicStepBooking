import controller.FlightController;
import controller.PersonController;
import dao.ListFlightDao;
import dao.ListPersonDao;
import exception.*;
import helper.Helper;
import model.*;
import service.ListFlightService;
import service.ListPersonService;
import view.ConsoleView;
import view.MenuView;

import java.util.*;

public class App {

  private Person person;
  private final Scanner scanner;
  private final Generator generator;
  private final FlightController flightController;
  private final PersonController personController;


  public App() {
    this.scanner = new Scanner(System.in);
    ListPersonDao listPersonDao = new ListPersonDao();
    ListPersonService listPersonService = new ListPersonService(listPersonDao);
    this.flightController = new FlightController(new ListFlightService(new ListFlightDao()), listPersonService);
    this.personController = new PersonController(listPersonService);
    this.generator = new Generator();

    // create Admin
    listPersonDao.add(new Admin("root", "root", 100_000.0));
  }

  private void booking() {
    while (true) {
      try {
        int menuNumber = MenuView.bookingChoose(this.scanner);

        switch (menuNumber) {
          case 1:
            this.flightController.bookingTicketForHimself(this.scanner, this.person);
            break;
          case 2:
            this.flightController.bookingTicketForClient(this.scanner);
            break;
          case 3:
            return;
          default:
        }
      } catch (NumberException | FlightException | FreeTicketException | PersonNotExistException | NotEnoughMoney e) {
        Helper.printBorder(e.getMessage(), '*');
        Logger.saveErrorLogs(this.person, e.getMessage());
      }
    }
  }

  private void unbooking() {
    while (true) {
      try {
        int menuNumber = MenuView.bookingChoose(this.scanner);

        switch (menuNumber) {
          case 1:
            this.personController.unbookingTicketForHimself(this.scanner, this.person);
            break;
          case 2:
            this.personController.unbookingTicketForClient(this.scanner);
            break;
          case 3:
            return;
          default:
        }
      } catch (NumberException | TicketNotExist e) {
        Helper.printBorder(e.getMessage(), '*');
        Logger.saveErrorLogs(this.person, e.getMessage());
      }
    }
  }

  public void printTickets() {
    while (true) {
      try {
        int menuNumber = MenuView.personChoose(this.scanner);

        switch (menuNumber) {
          case 1:
            this.personController.printOwnTickets(this.person);
            break;
          case 2:
            this.personController.printOtherPersonTickets(this.scanner);
            break;
          case 3:
            return;
          default:
        }
      } catch (NumberException | PersonNotExistException e) {
        Helper.printBorder(e.getMessage(), '*');
        Logger.saveErrorLogs(this.person, e.getMessage());
      }
    }
  }

  private void adminSession() {
    while (true) {
      try {
        int menuNumber = MenuView.mainMenuAdmin(this.scanner, this.person);
        switch (menuNumber) {
          case 1:
            Map<String, String> data = ConsoleView.getGeneratorFlightsData(this.scanner);
            List<Flight> flights = this.generator.generateFlights(data);
            this.flightController.generateDataFLights(flights);
            break;
          case 2:
            this.flightController.printAllFlights();
            break;
          case 3:
            this.flightController.printFlightsWithFilter(this.scanner);
            break;
          case 4:
            this.personController.createPerson(this.scanner);
            break;
          case 5:
            this.personController.deletePerson(this.scanner);
            break;
          case 6:
            this.personController.printAllPersons();
            break;
          case 7:
            this.booking();
            break;
          case 8:
            this.unbooking();
            break;
          case 9:
            this.printTickets();
            break;
          case 10:
            return;
        }
      } catch (NumberException | EmptyException | PersonNameException | NameException | CostException | TimeException e) {
        Helper.printBorder(e.getMessage(), '*');
        Logger.saveErrorLogs(this.person, e.getMessage());
      }
    }
  }

  private void clientSession() {
    while (true) {
      try {
        int menuNumber = MenuView.mainMenuClient(this.scanner, this.person);
        switch (menuNumber) {
          case 1:
            this.flightController.printAllFlights();
            break;
          case 2:
            this.flightController.printFlightsWithFilter(this.scanner);
            break;
          case 3:
            this.flightController.bookingTicketForHimself(this.scanner, this.person);
            break;
          case 4:
            this.personController.unbookingTicketForHimself(this.scanner, this.person);
            break;
          case 5:
            this.personController.printOwnTickets(this.person);
            break;
          case 6:
            return;
        }
      } catch (NumberException | EmptyException | FlightException | TicketNotExist | CostException | TimeException e) {
        Helper.printBorder(e.getMessage(), '*');
        Logger.saveErrorLogs(this.person, e.getMessage());
      }
    }
  }

  public void run() {
    while (true) {
      try {
        int menuNumber = MenuView.loginMenu(this.scanner);

        if (menuNumber == 1) {
          this.person = this.personController.login(this.scanner);

          if (person.isAdmin()) this.adminSession();
          if (person.isClient()) this.clientSession();

        } else if (menuNumber == 2) {
          break;
        }
      } catch (NameException | PasswordException | NumberException e) {
        Helper.printBorder(e.getMessage(), '*');
        Logger.saveLoginErrorLogs(e.getMessage());
      }
    }
  }
}
