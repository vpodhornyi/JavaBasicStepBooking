package test;

import dao.ListFlightDao;
import exception.EmptyException;
import model.Airline;
import model.Airplane;
import model.City;
import model.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.FlightService;
import service.ListFlightService;

import java.util.Date;

public class FlightServiceTest {

  private final FlightService flightService;
  private final ListFlightDao flightDao;
  private final Flight testFlight;

  public FlightServiceTest() {
    this.flightDao = new ListFlightDao();
    this.flightService = new ListFlightService(this.flightDao);
    Flight flight = new Flight(City.MexicoCity, City.Berlin, Airline.AlaskaAirlines, Airplane.AIRBUS_A220,
       new Date().getTime());
    this.testFlight = flight;
    flightDao.add(flight);
  }

  @Test
  public void findAll() {
    Assertions.assertEquals(1, this.flightService.findAll().size());
  }

  @Test
  public void findAllEmptyError() {
    try {
      this.flightDao.delete(this.testFlight);
      this.flightService.findAll();

    } catch (EmptyException e) {
      String expect = "No data to show";
      Assertions.assertEquals(expect, e.getMessage());
    }
  }
}
