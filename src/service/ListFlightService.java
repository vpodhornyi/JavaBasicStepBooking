package service;

import dao.FlightDao;
import model.Flight;

import java.util.Optional;

public class ListFlightService implements FlightService {

  private final FlightDao flightDao;

  public ListFlightService(FlightDao flightDao) {
    this.flightDao = flightDao;
  }

  public void add(Flight flight) {
    this.flightDao.add(flight);
  }

  @Override
  public Optional<Flight> findAll() {
    return Optional.empty();
  }

  @Override
  public Optional<Flight> findById(String id) {
    return Optional.empty();
  }

  public void delete(Flight flight) {
    this.flightDao.delete(flight);
  }

  public void save(){
    this.flightDao.save();
  }

  public void load() {
    this.flightDao.load();
  }
}
