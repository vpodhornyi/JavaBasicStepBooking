import controller.FlightController;
import controller.PersonController;
import dao.ListFlightDao;
import dao.ListPersonDao;
import exception.*;
import helper.Helper;
import model.*;
import service.ListFlightService;
import service.ListPersonService;
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
    this.flightController = new FlightController(new ListFlightService(new ListFlightDao()));
    ListPersonDao listPersonDao = new ListPersonDao();
    ListPersonService listPersonService = new ListPersonService(listPersonDao);
    this.personController = new PersonController(listPersonService);
    this.generator = new Generator();

    // create Admin
    listPersonDao.add(new Admin("root", "root"));
  }

  private void booking() throws NumberException {
    while (true) {
      try {
        int menuNumber = MenuView.bookingChoose(this.scanner);

        switch (menuNumber) {
          case 1:
            System.out.println("book");
            Ticket ticket = this.flightController.getTicketByFlightId(this.scanner);
            this.person.booking(ticket);

            break;
          case 2:

            break;
          case 3:
            return;
          default:
        }
      } catch (NumberException | FlightException e) {
        Helper.printBorder(e.getMessage(), '*');
      }
    }
  }

  private void session() {
    while (true) {
      try {
        int menuNumber = MenuView.mainMenu(this.scanner, this.person);
        switch (menuNumber) {
          case 1:
            List<Flight> flights = this.generator.generateFlights(10, 120);
            this.flightController.generateDataFLights(this.person, flights);
            break;
          case 2:
            this.flightController.printAllFlights();
            break;
          case 4:
            this.booking();
            break;
          case 5:
            return;
        }
      } catch (NumberException | EmptyException e) {
        Helper.printBorder(e.getMessage(), '*');
      }
    }
  }

  public void run() {
    while (true) {
      try {
//        int menuNumber = MenuView.loginMenu(this.scanner);
        int menuNumber = 1;

        if (menuNumber == 1) {
          this.person = this.personController.login();
          this.session();

        } else if (menuNumber == 2) {
          break;
        }
      } catch (NameException | PasswordException | NumberException e) {
        Helper.printBorder(e.getMessage(), '*');
      }
    }
  }
}
