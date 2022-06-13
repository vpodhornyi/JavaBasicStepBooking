import controller.FlightController;
import controller.PersonController;
import dao.FlightDao;
import dao.ListFlightDao;
import dao.ListPersonDao;
import dao.PersonDao;
import model.*;
import service.FlightService;
import service.ListFlightService;
import service.ListPersonService;

import java.util.*;


public class App {
  private final FlightController flightController;
  private final PersonController personController;

  public App() {

    this.flightController = new FlightController(new ListFlightService(new ListFlightDao()));
    ListPersonDao listPersonDao = new ListPersonDao();
    ListPersonService listPersonService = new ListPersonService(listPersonDao);
    this.personController = new PersonController(listPersonService);

    // create Admin
    listPersonDao.add(new Admin("root", "root"));
  }

  private void session(Person person) {
//    while (true) {
//
//      switch () {
//
//      }
//    }
  }

  public void run() {

    while (true) {
      Optional<Person> optionalPerson = this.personController.login();

      optionalPerson.ifPresent(this::session);
    }

  }
}
