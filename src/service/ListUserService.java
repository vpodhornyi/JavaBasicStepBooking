package service;

import dao.UserDao;
import model.User;

public class ListUserService implements UserService {
  private final UserDao userDao;

  public ListUserService(UserDao uerDao) {
    this.userDao = uerDao;
  }

  @Override
  public void add(User user) {
    userDao.add(user);
  }

  @Override
  public void delete() {

  }
}
