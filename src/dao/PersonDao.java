package dao;

import model.Person;
import model.Ticket;

public interface PersonDao extends DefaultDao<Person> {

  default public void save() {
  }

  default public void load() {
  }
}
