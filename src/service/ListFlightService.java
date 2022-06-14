package service;

import dao.FlightDao;
import model.Flight;
import model.Ticket;

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
  public Optional<List<Flight>> findAll() {
    return this.flightDao.findAll();
  }

  @Override
  public Optional<Flight> findById(String id) {
    return this.flightDao.findById(id);
  }

  @Override
  public void delete(Map<String, String> data) {
    this.flightDao.delete(null);
  }

  public Ticket getFreeTicket() {
    return null;
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
