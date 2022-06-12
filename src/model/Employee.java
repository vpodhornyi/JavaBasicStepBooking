package model;

public class Employee extends Client {
  public Employee(String name, String password) {
    super(name, password);
  }

  public void removeBooking(Person person, Ticket ticket) {
    person.booking(ticket);
  }

  public Client createClient(String name, String password) {
    return new Client(name, password);
  }


  @Override
  public String toString() {
    return "Employee{" +
        "id='" + this.getId() + '\'' +
        ", name='" + this.getName() + '\'' +
        ", password='" + this.getPassword() + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Employee employee)) return false;

    return this.getId().equals(employee.getId());
  }
}
