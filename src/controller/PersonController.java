package controller;

import model.Employee;
import model.Person;
import model.Ticket;
import service.PersonService;

import java.util.List;
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

    List<Person> optionalFlight = personService.findAll();
  }
}
