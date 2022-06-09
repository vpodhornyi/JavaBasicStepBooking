package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Savable<User> {

  void add(User user);

  void delete(User user);

  default void save() {
  }

  default Optional<List<User>> load() {
    return Optional.empty();
  }
}
