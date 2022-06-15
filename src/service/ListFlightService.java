package service;

import dao.FlightDao;
import exception.*;
import model.Flight;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ListFlightService implements FlightService {

  private final FlightDao flightDao;

  public ListFlightService(FlightDao flightDao) {
    this.flightDao = flightDao;
  }

  public void add(Map<String, String> data) {
    this.flightDao.add(null);
  }

  @Override
  public List<Flight> findAll() {

    Optional<List<Flight>> optionalFlight = this.flightDao.findAll();

    if (optionalFlight.isPresent()) return optionalFlight.get();

    throw new EmptyException();
  }

  @Override
  public Flight findById(Map<String, String> data) {

    Optional<Flight> optionalFlight = this.flightDao.findById(data.get(FIELD_ID));

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

  public void save() {
    this.flightDao.save();
  }

  public void load() {
    this.flightDao.load();
  }
}
