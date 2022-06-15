package service;

import dao.FlightDao;
import exception.*;
import model.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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

  @Override
  public List<Flight> findAllWithCityFrom(City city) {
    Optional<List<Flight>> optionalFlights = this.flightDao.findAll();

    if (optionalFlights.isEmpty()) throw new EmptyException();

    List<Flight> list = optionalFlights.get().stream()
        .filter(f -> f.getFromCity().equals(city))
        .toList();

    if (list.size() == 0) throw new EmptyException();

    return list;
  }

  @Override
  public List<Flight> findAllWithCityTo(City city) {
    Optional<List<Flight>> optionalFlights = this.flightDao.findAll();

    if (optionalFlights.isEmpty()) throw new EmptyException();

    List<Flight> list = optionalFlights.get().stream()
        .filter(f -> f.getToCity().equals(city))
        .toList();

    if (list.size() == 0) throw new EmptyException();

    return list;
  }

  @Override
  public List<Flight> findAllWithCityFromTo(Map<String, City> data) {
    Optional<List<Flight>> optionalFlights = this.flightDao.findAll();

    if (optionalFlights.isEmpty()) throw new EmptyException();

    List<Flight> list = optionalFlights.get().stream()
        .filter(f -> f.getFromCity().equals(data.get(FIELD_FROM_CITY)) && f.getToCity().equals(data.get(FIELD_TO_CITY)))
        .toList();

    if (list.size() == 0) throw new EmptyException();

    return list;
  }

  @Override
  public List<Flight> findAllWithAirline(Airline airline) {
    Optional<List<Flight>> optionalFlights = this.flightDao.findAll();

    if (optionalFlights.isEmpty()) throw new EmptyException();

    List<Flight> list = optionalFlights.get().stream()
        .filter(f -> f.getAirline().equals(airline))
        .toList();

    if (list.size() == 0) throw new EmptyException();

    return list;
  }

  @Override
  public List<Flight> findAllWithAirplane(Airplane airplane) {
    Optional<List<Flight>> optionalFlights = this.flightDao.findAll();

    if (optionalFlights.isEmpty()) throw new EmptyException();

    List<Flight> list = optionalFlights.get().stream()
        .filter(f -> f.getAirplane().equals(airplane))
        .toList();

    if (list.size() == 0) throw new EmptyException();

    return list;
  }

  @Override
  public List<Flight> findAllWithMinCost(Map<String, String> data) {
    try {
      double cost = Double.parseDouble(data.get(FIELD_COST));

      if (cost < 1) throw new CostException();

      Optional<List<Flight>> optionalFlights = this.flightDao.findAll();

      if (optionalFlights.isEmpty()) throw new EmptyException();

      List<Flight> list = optionalFlights.get().stream()
          .filter(f -> {
            Optional<Ticket> optionalTicket = f.getFreeBaseTicket();

            if (optionalTicket.isEmpty()) throw new EmptyException();

            return optionalTicket.get().getCost() < cost;
          })
          .toList();

      if (list.size() == 0) throw new EmptyException();

      return list;

    } catch (EmptyException e) {
      throw new EmptyException();

    } catch (Exception e) {
      throw new CostException();
    }
  }

  @Override
  public List<Flight> findAllWithTime(Map<String, String> data) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      long startDay = sdf.parse(data.get(FIELD_START_DAY)).getTime();
      long endDay = sdf.parse(data.get(FIELD_END_DAY)).getTime();

      Optional<List<Flight>> optionalFlights = this.flightDao.findAll();

      if (optionalFlights.isEmpty()) throw new EmptyException();

      List<Flight> list = optionalFlights.get().stream()
          .filter(f -> f.getTime() > startDay && f.getTime() < endDay)
          .toList();

      if (list.size() == 0) throw new EmptyException();

      return list;

    } catch (Exception e) {
      throw new TimeException();
    }
  }

  public void save() {
    this.flightDao.save();
  }

  public void load() {
    this.flightDao.load();
  }
}
