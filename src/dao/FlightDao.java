package dao;

import model.Flight;

import java.util.List;

public interface FlightDao extends DefaultDao<Flight> {

  void setFlights(List<Flight> flight);

  default public void save() {
  }

  default public void load() {
  }
}
