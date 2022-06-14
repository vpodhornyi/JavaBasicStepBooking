package service;

import dao.PersonDao;
import exception.NameException;
import exception.PasswordException;
import exception.PersonNameException;
import model.Client;
import model.Employee;
import model.Person;
import model.Ticket;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ListPersonService implements PersonService {
  private final String FIELD_NAME = "name";
  private final String FIELD_PASSWORD = "password";
  private final PersonDao personDao;

  public ListPersonService(PersonDao uerDao) {
    this.personDao = uerDao;
  }

  @Override
  public void add(Map<String, String> data) {
    Optional<Person> optionalPerson = this.personDao.findByName(data.get(FIELD_NAME));

    if (optionalPerson.isPresent()) throw new PersonNameException();

    personDao.add(new Client(data.get(FIELD_NAME), data.get(FIELD_PASSWORD)));
  }

  @Override
  public void delete(Map<String, String> data) {
    Optional<Person> optionalPerson = this.personDao.findByName(data.get(FIELD_NAME));

    if (optionalPerson.isPresent()) {

      Person person = optionalPerson.get();
      Set<Ticket> tickets = person.getTickets();
      tickets.forEach(Ticket::deleteOwner);
      this.personDao.delete(person);
      return;
    }

    throw new NameException();
  }

  @Override
  public Optional<List<Person>> findAll() {
    return this.personDao.findAll();
  }

  @Override
  public Optional<Person> findById(String id) {

    return this.personDao.findById(id);
  }

  @Override
  public Person login(Map<String, String> data) {

    Optional<Person> optionalPerson = this.personDao.findByName(data.get(FIELD_NAME));

    if (optionalPerson.isPresent()) {
      Person person = optionalPerson.get();
      String password = person.getPassword();

      if (password.equals(data.get(FIELD_PASSWORD))) return person;

      throw new PasswordException();
    }
    throw new NameException();
  }

  public Optional<Person> findByName(String name) {
    return this.personDao.findByName(name);
  }

  @Override
  public void booking(Person person, Ticket ticket) {
    person.booking(ticket);
  }

  @Override
  public void booking(Employee employee, Person person, Ticket ticket) {
    employee.booking(person, ticket);
  }

  public void save() {
    this.personDao.save();
  }

  public void load() {
    this.personDao.load();
  }
}
