package dao;

import model.Flight;
import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListFlightDao implements FlightDao{
  private final String FILE_NAME = "flights.dat";
  private List<Flight> flights = new ArrayList<>();

  @Override
  public void add(Person user) {

  }

  @Override
  public void delete(Person user) {

  }

  public void save() {
    this.save(flights, FILE_NAME);
  }

  public void load() {
    Optional<List<Flight>> optionalPerson = this.load(FILE_NAME);

    optionalPerson.ifPresent(people -> this.flights = people);
  }

  @Override
  public String toString() {
    return "ListFlightDao{" +
        "flight=[" + flights.stream().map(Flight::toString).reduce("", (u1, u2) -> u1 + "\n" + u2) +
        "]}";
  }
}
