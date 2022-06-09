package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListUserDao implements UserDao {
  private final String FILE_NAME = "users.dat";
  private List<User> users = new ArrayList<>();

  public void add(User user) {
    this.users.add(user);
  }

  @Override
  public void delete(User user) {

  }

  @Override
  public void save() {
    this.save(users, FILE_NAME);
  }

  @Override
  public Optional<List<User>> load() {
    return this.load(FILE_NAME);
  }

  @Override
  public String toString() {
    return "DefaultUserDao{" +
        "users=[" + users.stream().map(User::toString).reduce("", (u1, u2) -> u1 + "\n" + u2) +
        "]}";
  }
}
