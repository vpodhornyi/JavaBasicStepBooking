package service;

import model.Person;

import java.util.List;
import java.util.Optional;

public interface DefaultService<T> {
  void add(T obj);

  Optional<List<T>> findAll();

  Optional<T> findById(String id);

  void delete(T obj);

  default void save(){}
  default void load(){}
}
