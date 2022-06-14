package service;

import model.Person;
import model.Ticket;

import java.util.Map;
import java.util.Optional;

public interface PersonService extends DefaultService<Person> {

  Person login(Map<String, String> data);
  Person findByName(Map<String, String> data);
  public void booking(Person person, Ticket ticket);
}
