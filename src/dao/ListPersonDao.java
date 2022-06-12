package dao;

import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListPersonDao implements PersonDao {
  private final String FILE_NAME = "people.dat";
  private List<Person> people;

  public ListPersonDao() {
    this.people = new ArrayList<>();
  }

  @Override
  public void add(Person person) {
    this.people.add(person);
  }

  @Override
  public List<Person> findAll() {
    return new ArrayList<>(this.people);
  }

  @Override
  public Optional<Person> findById(String id) {
    return this.people.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();
  }

  @Override
  public void delete(Person person) {

  }

  public void save() {
    this.save(people, FILE_NAME);
  }

  public void load() {
    Optional<List<Person>> optionalPerson = this.load(FILE_NAME);

    optionalPerson.ifPresent(people -> this.people = people);
  }

  @Override
  public String toString() {
    return "DefaultPersonDao{" +
        "person=[" + people.stream().map(Person::toString).reduce("", (u1, u2) -> u1 + "\n" + u2) +
        "]}";
  }
}
