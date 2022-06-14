package model;

public class Admin extends Client{

  public Admin(String name, String password) {
    super(name, password);
  }

  @Override
  public String toString() {
    return "Admin{" +
        "id='" + this.getId() + '\'' +
        ", name='" + this.getName() + '\'' +
        ", password='" + this.getPassword() + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Admin admin)) return false;

    return this.getId().equals(admin.getId());
  }
}
