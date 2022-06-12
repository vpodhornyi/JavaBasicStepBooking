package dao;

import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListPersonDao implements PersonDao {
  private final String FILE_NAME = "users.dat";
  private List<Person> persons = new ArrayList<>();

  public void add(Person person) {
    this.persons.add(person);
  }

  @Override
  public void delete(Person person) {

  }

  public void save() {
    this.save(persons, FILE_NAME);
  }

  public void load() {
    Optional<List<Person>> optionalPerson = this.load(FILE_NAME);

    optionalPerson.ifPresent(people -> this.persons = people);
  }

  @Override
  public String toString() {
    return "DefaultPersonDao{" +
        "person=[" + persons.stream().map(Person::toString).reduce("", (u1, u2) -> u1 + "\n" + u2) +
        "]}";
  }
}
