package service;

import dao.PersonDao;
import exception.*;
import model.Client;
import model.Flight;
import model.Person;
import model.Ticket;
import view.SuccessView;
import view.Table;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ListPersonService implements PersonService {
  private final PersonDao personDao;

  public ListPersonService(PersonDao uerDao) {
    this.personDao = uerDao;
  }

  @Override
  public void add(Map<String, String> data) {
    Optional<Person> optionalPerson = this.personDao.findByName(data.get(FIELD_NAME));

    if (optionalPerson.isPresent()) throw new PersonNameException();

    try {
      Double account = Double.parseDouble(data.get(FIELD_ACCOUNT));
      personDao.add(new Client(data.get(FIELD_NAME), data.get(FIELD_PASSWORD), account));

    } catch (Exception e) {
      throw new AccountException();
    }
  }

  @Override
  public void delete(Map<String, String> data) {
    Optional<Person> optionalPerson = this.personDao.findByName(data.get(FIELD_NAME));

    if (optionalPerson.isPresent()) {

      Person person = optionalPerson.get();
      List<Ticket> tickets = person.getTickets();
      tickets.forEach(Ticket::deleteOwner);
      this.personDao.delete(person);
      return;
    }

    throw new NameException();
  }

  @Override
  public List<Person> findAll() {
    Optional<List<Person>> optionalPeople = this.personDao.findAll();

    if (optionalPeople.isPresent()) {

      List<Person> people = optionalPeople.get();

      if (people.size() == 0) throw new EmptyException();

      return people;
    }
    throw new EmptyException();
  }

  @Override
  public Person findById(Map<String, String> data) {
    Optional<Person> optionalPerson = this.personDao.findById(data.get(FIELD_ID));

    if (optionalPerson.isPresent()) return optionalPerson.get();

    throw new PersonNameException();
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

  public Person findByName(Map<String, String> data) {
    Optional<Person> optionalPerson = this.personDao.findByName(data.get(FIELD_NAME));

    if (optionalPerson.isPresent()) return optionalPerson.get();

    throw new PersonNotExistException();
  }

  @Override
  public void unbooking(Person person, Map<String, String> data) {
    Optional<Ticket> optionalTicket = person.getTicketById(data.get(FIELD_ID));

    if (optionalTicket.isPresent()) {
      Ticket ticket = optionalTicket.get();
      person.deleteTicket(ticket);
      person.increaseAccount(ticket.getCost());

      SuccessView.unbookingSuccess();

      return;
    }
    throw new TicketNotExist();
  }

  public void save() {
    this.personDao.save();
  }

  public void load() {
    this.personDao.load();
  }
}
