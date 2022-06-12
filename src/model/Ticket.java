package model;

import java.util.Optional;

public abstract class Ticket extends Id {
  public abstract Optional<Person> getOwner();
  public abstract void setOwner(Person person);
}
