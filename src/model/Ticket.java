package model;

import java.io.Serializable;
import java.util.Optional;

public abstract class Ticket extends Id implements Serializable {
  public abstract Optional<Person> getOwner();

  public abstract void setOwner(Person person);
}
