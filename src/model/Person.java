package model;

import java.io.Serializable;
import java.util.*;

public abstract class Person extends Id implements Serializable {
  private final String name;
  private final String password;
  private Double account = 0.0;

  private final List<Ticket> tickets;

  public Person(String name, String password, Double account) {
    super();
    this.name = name;
    this.password = password;
    this.account = account;
    this.tickets = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public void reduceAccount(Double cost) {
    this.account -= cost;
  }

  public void increaseAccount(Double cost) {
    this.account += cost;
  }

  public Double getAccount() {
    return account;
  }

  public List<Ticket> getTickets() {
    return new ArrayList<>(this.tickets);
  }

  public void addTicket(Ticket ticket) {
    tickets.add(ticket);
    ticket.setOwner(this);
  }

  public Optional<Ticket> getTicketById(String id) {
    return this.tickets.stream()
        .filter(t -> t.getId().equals(id))
        .findFirst();
  }

  public void deleteTicket(Ticket ticket) {
    tickets.remove(ticket);
    ticket.setOwner(null);
  }

  public void removeBooking(Ticket ticket) {
    this.tickets.remove(ticket);
  }

  public boolean isClient() {
    return false;
  }

  public boolean isAdmin() {
    return false;
  }

  public String getRole() {
    return this.getClass().getSimpleName();
  }

  public String getWelcomeString() {
    StringBuilder str = new StringBuilder();
    str.append("Hello, ");
    str.append(this.name);
    str.append("(");
    str.append(this.getRole());
    str.append("); ");
    str.append("Ticket(s) = ");
    str.append(this.tickets.size());
    str.append("; Balance = ");
    str.append(this.account);

    return str.toString();
  }

  @Override
  public String toString() {
    return "Person{" +
        "id='" + this.getId() + '\'' +
        "name='" + name + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getId());
  }
}
