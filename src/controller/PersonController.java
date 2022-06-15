package controller;

import exception.*;
import model.Person;
import model.Ticket;
import service.PersonService;
import view.ConsoleView;
import view.SuccessView;
import view.Table;

import java.util.*;

public class PersonController {
  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  public void createPerson(Scanner scanner) {
    Map<String, String> data = ConsoleView.getNamePasswordAccount(scanner);
    personService.add(data);
    SuccessView.personCreateSuccess();
  }

  public void deletePerson(Scanner scanner) {
    Map<String, String> data = ConsoleView.getName(scanner);
    personService.delete(data);
    SuccessView.personDeleteSuccess();
  }

  public void printAllPersons() {
    List<Person> people = personService.findAll();

    if (people.size() != 0) {
      Table.printPeople(people);
      return;
    }

    throw new EmptyException();
  }

  public void printOwnTickets(Person person) {
    List<Ticket> tickets = person.getTickets();

    if (tickets.size() != 0) {
      Table.printTickets(tickets);
      return;
    }

    throw new EmptyException();
  }

  public void printOtherPersonTickets(Scanner scanner) {
    Map<String, String> data = ConsoleView.getName(scanner);
    this.printOwnTickets(this.personService.findByName(data));
  }

  public void unbookingTicketForHimself(Scanner scanner, Person person) throws FlightException {
    Map<String, String> data = ConsoleView.getTicketId(scanner);
    this.personService.unbooking(person, data);
  }

  public void unbookingTicketForClient(Scanner scanner) throws FlightException {
    Map<String, String> data = ConsoleView.getName(scanner);
    Person person = this.personService.findByName(data);
    this.unbookingTicketForHimself(scanner, person);
  }

  public Person login(Scanner scanner) {
    Map<String, String> data = ConsoleView.getNamePassword(scanner);

    return this.personService.login(data);
  }
}
