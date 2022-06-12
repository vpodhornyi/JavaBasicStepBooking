package service;

import dao.FlightDao;
import model.Flight;
import model.Ticket;

import java.util.List;
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
  public List<Flight> findAll() {
    return this.flightDao.findAll();
  }

  @Override
  public Optional<Flight> findById(String id) {
    return this.flightDao.findById(id);
  }

  public void delete(Flight flight) {
    this.flightDao.delete(flight);
  }

  public Ticket getFreeTicket(){
    return null;
  }

  public void save(){
    this.flightDao.save();
  }

  public void load() {
    this.flightDao.load();
  }
}
