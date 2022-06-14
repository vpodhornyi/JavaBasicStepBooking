package service;

import model.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DefaultService<T> {
  void add(Map<String, String> data);

  Optional<List<T>> findAll();

  Optional<T> findById(String id);

  void delete(Map<String, String> data);

  default void save(){}
  default void load(){}
}
