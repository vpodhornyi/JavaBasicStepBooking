package service;

import model.Employee;
import model.Person;
import model.Ticket;

public interface PersonService extends DefaultService<Person> {
  public void booking(Person person, Ticket ticket);
  public void booking(Employee employee, Person client, Ticket ticket);
}
