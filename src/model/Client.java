package model;

public class Client extends Person {
  public Client(String name, String password) {
    super(name, password);
  }

  @Override
  public boolean isClient() {
    return true;
  }

  @Override
  public boolean isEmployee() {
    return false;
  }

  @Override
  public boolean isAdmin() {
    return false;
  }


  @Override
  public String toString() {
    return "Client{" +
        "id='" + this.getId() + '\'' +
        ", name='" + this.getName() + '\'' +
        ", password='" + this.getPassword() + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Client client)) return false;

    return this.getId().equals(client.getId());
  }
}
