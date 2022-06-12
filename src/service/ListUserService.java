package service;

import dao.PersonDao;
import model.Person;

public class ListUserService implements UserService {
  private final PersonDao userDao;

  public ListUserService(PersonDao uerDao) {
    this.userDao = uerDao;
  }

  @Override
  public void add(Person user) {
    userDao.add(user);
  }

  @Override
  public void delete() {

  }
}
