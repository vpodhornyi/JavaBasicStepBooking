package service;

import dao.FlightDao;
import dao.PersonDao;
import exception.FlightException;
import exception.FreeTicketException;
import exception.PersonNameException;
import exception.PersonNotExistException;
import model.Flight;
import model.Person;
import model.Ticket;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ListFlightService implements FlightService {

  private final FlightDao flightDao;
  private final PersonDao personDao;

  public ListFlightService(FlightDao flightDao, PersonDao personDao) {
    this.flightDao = flightDao;
    this.personDao = personDao;
  }

  public void add(Map<String, String> data) {

    this.flightDao.add(null);
  }

  @Override
  public Optional<List<Flight>> findAll() {
    return this.flightDao.findAll();
  }

  @Override
  public Flight findById(Map<String, String> data) {

    Optional<Flight> optionalFlight = this.flightDao.findById("data");

    if (optionalFlight.isPresent()) return optionalFlight.get();

    throw new FlightException();
  }

  @Override
  public void delete(Map<String, String> data) {
    this.flightDao.delete(null);
  }

  public void setFlights(List<Flight> flights) {
    this.flightDao.setFlights(flights);
  }

  @Override
  public void bookingTicket(Map<String, String> data, Person person) {
    Optional<Flight> optionalFlight = this.flightDao.findById(data.get(FIELD_ID));

    if (optionalFlight.isPresent()) {
      Flight flight = optionalFlight.get();

      Optional<Ticket> optionalTicket = flight.getFreeBaseTicket();

      if (optionalTicket.isPresent()) {
        Ticket ticket = optionalTicket.get();
        person.booking(ticket);
        return;
      }

      throw new FreeTicketException();
    }
    throw new FlightException();
  }

  @Override
  public void bookingTicket(Map<String, String> data) {
    Optional<Flight> optionalFlight = this.flightDao.findById(data.get(FIELD_ID));
    Optional<Person> optionalPerson = this.personDao.findByName(data.get(FIELD_NAME));

    if (optionalFlight.isPresent()) {
      Flight flight = optionalFlight.get();

      Optional<Ticket> optionalTicket = flight.getFreeBaseTicket();

      if (optionalTicket.isPresent()) {
        if (optionalPerson.isPresent()) {
          optionalPerson.get().booking(optionalTicket.get());
          return;
        }
        throw new PersonNotExistException();
      }
      throw new FreeTicketException();
    }
    throw new FlightException();
  }

  public void save() {
    this.flightDao.save();
  }

  public void load() {
    this.flightDao.load();
  }
}
