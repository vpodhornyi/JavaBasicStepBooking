package dao;

import model.Flight;
import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListFlightDao implements FlightDao {
  private final String FILE_NAME = "flights.dat";
  private List<Flight> flights;

  public ListFlightDao() {
    this.flights = new ArrayList<>();
  }

  @Override
  public void add(Flight flight) {
    this.flights.add(flight);
  }

  @Override
  public List<Flight> findAll() {
    return new ArrayList<>(this.flights);
  }

  @Override
  public Optional<Flight> findById(String id) {
    return this.flights.stream()
        .filter(f -> f.getId().equals(id))
        .findFirst();
  }

  @Override
  public void delete(Flight flight) {
    this.flights.remove(flight);
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
        "flight=[" + flights.stream().map(Flight::toString).reduce("", (f1, f2) -> f1 + "\n" + f2) +
        "]}";
  }
}
