package dao;

import model.Person;

public interface PersonDao extends DefaultDao<Person> {

  default public void save() {
  }

  default public void load() {
  }
}
