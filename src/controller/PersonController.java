package controller;

import model.Employee;
import model.Person;
import model.Ticket;
import service.PersonService;

import java.util.Optional;

public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  public void createPerson() {

    personService.add(null);
  }

  public void clientBooking() {

    personService.booking(null, null);
  }

  public void employeeBooking() {

    personService.booking(null, null, null);
  }

  public void printAllPersons() {

    Optional<Person> optionalFlight = personService.findAll();
  }
}
