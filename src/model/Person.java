package model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Person extends Id implements Serializable {
  private final String name;
  private final String password;

  public Person(String name, String password) {
    super();
    this.name = name;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + this.getId() + '\'' +
        "name='" + name + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person person)) return false;

    return this.getId().equals(person.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getId());
  }
}
