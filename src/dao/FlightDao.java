package dao;

import model.Flight;

public interface FlightDao extends DefaultDao<Flight> {

  default public void save() {
  }

  default public void load() {
  }
}
