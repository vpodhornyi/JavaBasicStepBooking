package model;

public class Client extends Person {
  public Client(String name, String password, Double account) {
    super(name, password, account);
  }

  public boolean isClient() {
    return true;
  }

  @Override
  public String toString() {
    return "Client{" +
        "id='" + this.getId() + '\'' +
        ", name='" + this.getName() + '\'' +
        ", password='" + this.getPassword() + '\'' +
        ", tickets='" + this.getTickets() + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Client client)) return false;

    return this.getName().equals(client.getName());
  }
}
