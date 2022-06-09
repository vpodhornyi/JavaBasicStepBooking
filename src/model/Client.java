package model;

public class Client extends User {
  public Client(String name, String password) {
    super(name, password);
  }


  @Override
  public String toString() {
    return "Client{" +
        "name='" + this.getName() + '\'' +
        ", password='" + this.getPassword() + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    Client client = (Client) o;
    return this.getName().equals(client.getName());
  }
}
