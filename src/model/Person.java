package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Person extends Id implements Serializable {
  private final String name;
  private final String password;

  private final Set<Ticket> tickets;

  public Person(String name, String password) {
    super();
    this.name = name;
    this.password = password;
    this.tickets = new HashSet<>();
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public void booking(Ticket ticket){
    this.tickets.add(ticket);
  }

  public void removeBooking(Ticket ticket){
    this.tickets.remove(ticket);
  }

  public abstract boolean isClient();
  public abstract boolean isEmployee();
  public abstract boolean isAdmin();

  @Override
  public String toString() {
    return "Person{" +
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
