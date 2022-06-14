package service;

import model.Flight;
import model.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DefaultService<T> {
  String FIELD_ID = "id";
  String FIELD_NAME = "name";
  String FIELD_PASSWORD = "password";

  void add(Map<String, String> data);

  Optional<List<T>> findAll();

  T findById(Map<String, String> data);

  void delete(Map<String, String> data);

  default void save() {
  }

  default void load() {
  }
}
