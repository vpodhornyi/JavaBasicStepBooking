package controller;

import exception.NameException;
import exception.PasswordException;
import model.Person;
import service.PersonService;
import view.PersonView;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class PersonController {

  private final Scanner scanner;

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
    this.scanner = new Scanner(System.in);
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

    Optional<List<Person>> optionalFlight = personService.findAll();
  }

  public Person login() throws NameException, PasswordException {
    Map<String, String> loginData = PersonView.login(this.scanner);

    Optional<Person> optionalPerson = this.personService.findByName(loginData.get("name"));

    if (optionalPerson.isPresent()) {
      Person person = optionalPerson.get();
      String password = person.getPassword();

      if (password.equals(loginData.get("password"))) {
        return person;

      } else {
        throw new PasswordException();
      }

    } else {
      throw new NameException();
    }
  }
}
