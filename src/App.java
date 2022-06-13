import dao.FlightDao;
import dao.ListFlightDao;
import dao.ListPersonDao;
import dao.PersonDao;
import model.*;
import service.FlightService;
import service.ListFlightService;
import service.ListPersonService;
import service.PersonService;
import view.FlightTable;

import java.util.*;


public class App {


  public static void main(String[] args) {

/*    // Person example

    Person client1 = new Client("Viktor", "111");
//    Person client2 = new Employee("Alex", "111");
//    Person client3 = new Admin("admin", "admin");
//
    PersonDao personDao = new ListPersonDao();
    PersonService personService = new ListPersonService(personDao);

//    personDao.add(client1);
//    personDao.add(client2);
//    personDao.add(client3);
//
//    personDao.save();

    personDao.load();

    personService.findAll().forEach(System.out::println);

    // Flight example

    Flight flight = new Flight(City.Barcelona, City.Berlin, Airline.AlaskaAirlines, Airplane.AIRBUS_A310, new Date());

    Ticket ticket1 = new BaseTicket(flight);
    Ticket ticket2 = new BaseTicket(flight);
    Ticket ticket3 = new BaseTicket(flight);
    Ticket ticket4 = new BaseTicket(flight);

//    System.out.println(flight);

    FlightDao flightDao = new ListFlightDao();
    FlightService flightService = new ListFlightService(flightDao);

//    flightDao.add(flight);

//    flightDao.save();


    flightDao.load();

    flightService.findAll().forEach(System.out::println);

    Optional<Person> optionalPerson = personService.findById("aUDHCIp");
    Optional<Flight> flightOptional = flightService.findById("XAbfs1t");

    if (optionalPerson.isPresent()) {
      Person person = optionalPerson.get();
      System.out.println(person);

      if (flightOptional.isPresent()) {
        Flight flight1 = flightOptional.get();
        System.out.println(flight);

        Optional<Ticket> optionalTicket = flight1.getFreeTicket();

        if (optionalTicket.isPresent()) {
          Ticket ticket = optionalTicket.get();

          person.booking(ticket);
        }
      }
      System.out.println(person);
    }
*/

    Generator generator = new Generator();

    List<Flight> flights = generator.generateFlights(1001, 100);

//    flights.forEach(System.out::println);

    FlightTable.showFlights(flights);

  }


}
