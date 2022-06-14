package service;

import model.Employee;
import model.Person;
import model.Ticket;

import java.util.Map;
import java.util.Optional;

public interface PersonService extends DefaultService<Person> {

  Person login(Map<String, String> data);
  Optional<Person> findByName(String name);
  public void booking(Person person, Ticket ticket);
  public void booking(Employee employee, Person client, Ticket ticket);
}
