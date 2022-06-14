package dao;

import model.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Optional;

public interface DefaultDao<T> {
  void add(T obj);

  Optional<List<T>> findAll();

  Optional<T> findById(String id);

  void delete(T obj);

  default void save(List<T> list, String fileName) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
      oos.writeObject(list);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  default Optional<List<T>> load(String fileName) {
    try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(fileName))) {

      return Optional.ofNullable((List<T>) oos.readObject());

    } catch (Exception e) {
      System.out.println("load - " + e.getMessage());
    }
    return Optional.empty();
  }
}
