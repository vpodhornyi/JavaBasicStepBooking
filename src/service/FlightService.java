package service;

import model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FlightService extends DefaultService<Flight> {

  void setFlights(List<Flight> flightList);

  List<Flight> findAllWithCityFrom(City city);
  List<Flight> findAllWithCityTo(City city);
  List<Flight> findAllWithCityFromTo(Map<String, City> data);
  List<Flight> findAllWithAirline(Airline airline);
  List<Flight> findAllWithAirplane(Airplane airplane);
  List<Flight> findAllWithMinCost(Map<String, String> data);
  List<Flight> findAllWithTime(Map<String, String> data);
}
