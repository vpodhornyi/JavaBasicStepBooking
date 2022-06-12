package controller;

import model.Employee;
import model.Person;
import model.Ticket;
import service.PersonService;

public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  public void add(Person user) {
    personService.add(user);
  }

  public void clientBooking(Person person, Ticket ticket) {
    personService.booking(person, ticket);
  }

  public void employeeBooking(Employee employee, Person person, Ticket ticket) {
    personService.booking(employee, person, ticket);
  }
}
