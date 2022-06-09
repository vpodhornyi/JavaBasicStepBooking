package model;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable {
  private String name;
  private String password;

  public User(String name, String password) {
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
        "name='" + name + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return name.equals(user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
