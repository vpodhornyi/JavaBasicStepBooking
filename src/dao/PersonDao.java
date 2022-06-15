package dao;

import model.Person;
import model.Ticket;

import java.util.Optional;

public interface PersonDao extends DefaultDao<Person> {

  Optional<Person> findByName(String name);

  default public void save() {
  }

  default public void load() {
  }
}
