package service;

import model.Person;

import java.util.Optional;

public interface DefaultService<T> {
  void add(T obj);

  Optional<T> get(String id);

  void delete(T obj);

}
