import controller.FlightController;
import controller.PersonController;
import dao.ListFlightDao;
import dao.ListPersonDao;
import exception.EmptyException;
import exception.NameException;
import exception.NumberException;
import exception.PasswordException;
import helper.Helper;
import model.*;
import service.ListFlightService;
import service.ListPersonService;
import view.MenuView;

import java.util.*;


public class App {

  private final Scanner scanner;
  private final FlightController flightController;
  private final PersonController personController;

  private final Generator generator;


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

  private void session(Person person) {
    while (true) {
      try {
        int menuNumber = MenuView.mainMenu(this.scanner);
        switch (menuNumber) {
          case 1:
            List<Flight> flights = this.generator.generateFlights(100, 120);
            this.flightController.generateDataFLights(person, flights);
            break;
          case 2:
            this.flightController.printAllFlights();
            break;
          default:
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
        int menuNumber = MenuView.loginMenu(this.scanner);

        if (menuNumber == 1) {
          Person person = this.personController.login();
          this.session(person);

        } else if (menuNumber == 2) {
          break;
        }
      } catch (NameException | PasswordException e) {
        Helper.printBorder(e.getMessage(), '*');
      }
    }
  }
}
