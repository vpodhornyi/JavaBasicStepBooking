package service;

import dao.PersonDao;
import model.Person;
import model.Ticket;

import java.util.Optional;

public class ListPersonService implements PersonService {
  private final PersonDao personDao;

  public ListPersonService(PersonDao uerDao) {
    this.personDao = uerDao;
  }

  @Override
  public void add(Person user) {
    personDao.add(user);
  }

  @Override
  public Optional<Person> get(String id) {
    return Optional.empty();
  }

  @Override
  public void delete(Person person) {

  }
}
