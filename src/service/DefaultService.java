package service;

import java.util.List;
import java.util.Map;

public interface DefaultService<T> {
  String FIELD_ID = "id";
  String FIELD_NAME = "name";
  String FIELD_PASSWORD = "password";
  String FIELD_ACCOUNT = "account";
  String FIELD_COST = "cost";
  String FIELD_FROM_CITY = "fromCity";
  String FIELD_TO_CITY = "toCity";
  String FIELD_START_DAY = "startDay";
  String FIELD_END_DAY = "endDay";

  void add(Map<String, String> data);

  List<T> findAll();

  T findById(Map<String, String> data);

  void delete(Map<String, String> data);

  default void save() {
  }

  default void load() {
  }
}
