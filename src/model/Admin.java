package model;

public class Admin extends Person{

  public Admin(String name, String password, Double account) {
    super(name, password, account);
  }

  public boolean isAdmin(){
    return true;
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
