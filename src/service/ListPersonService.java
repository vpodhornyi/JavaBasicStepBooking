package service;

import dao.PersonDao;
import model.Employee;
import model.Person;
import model.Ticket;

import java.util.List;
import java.util.Optional;

public class ListPersonService implements PersonService {
  private final PersonDao personDao;

  public ListPersonService(PersonDao uerDao) {
    this.personDao = uerDao;
  }

  public void add(Person person) {
    personDao.add(person);
  }

  public List<Person> findAll() {
    return this.personDao.findAll();
  }

  public Optional<Person> findById(String id) {

    return this.personDao.findById(id);
  }

  public void delete(Person person) {
    this.personDao.delete(person);
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
