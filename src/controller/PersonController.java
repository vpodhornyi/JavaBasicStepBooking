package controller;

import exception.EmptyException;
import exception.NameException;
import exception.PasswordException;
import exception.PersonNameException;
import model.Client;
import model.Flight;
import model.Person;
import service.PersonService;
import view.ConsoleView;
import view.Table;

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

  public void printAllPersons() {
    List<Person> people = personService.findAll();

    if (people.size() != 0) {
      Table.showPeople(people);
      return;
    }

    throw new EmptyException();
  }

  public Person login(Scanner scanner) {
    Map<String, String> data = ConsoleView.getNamePassword(scanner);

    return this.personService.login(data);
  }
}
