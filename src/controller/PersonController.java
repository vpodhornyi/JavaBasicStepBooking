package controller;

import exception.NameException;
import exception.PasswordException;
import exception.PersonNameException;
import model.Client;
import model.Person;
import service.PersonService;
import view.ConsoleView;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class PersonController {
  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  public void createPerson(Scanner scanner) {
    Map<String, String> data = ConsoleView.getNamePassword(scanner);

    personService.add(data);
  }

  public void deletePerson(Scanner scanner) {
    Map<String, String> data = ConsoleView.getName(scanner);

    personService.delete(data);
  }

  public void bookingForHimself() {

    personService.booking(null, null);
  }

  public void bookingForOtherPerson() {

    personService.booking(null, null);
  }

  public void printAllPersons() {
    Optional<List<Person>> optionalFlight = personService.findAll();
  }

  public Person login(Scanner scanner) {
    Map<String, String> data = ConsoleView.getNamePassword(scanner);

    return this.personService.login(data);
  }
}
