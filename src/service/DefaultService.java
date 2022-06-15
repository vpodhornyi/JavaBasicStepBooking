package service;

import java.util.List;
import java.util.Map;

public interface DefaultService<T> {
  String FIELD_ID = "id";
  String FIELD_NAME = "name";
  String FIELD_PASSWORD = "password";
  String FIELD_ACCOUNT = "account";

  void add(Map<String, String> data);

  List<T> findAll();

  T findById(Map<String, String> data);

  void delete(Map<String, String> data);

  default void save() {
  }

  default void load() {
  }
}
