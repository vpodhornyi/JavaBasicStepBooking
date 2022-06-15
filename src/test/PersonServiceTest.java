package test;

import dao.ListPersonDao;
import dao.PersonDao;
import exception.*;
import model.Admin;
import model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.ListPersonService;
import service.PersonService;

import java.util.HashMap;
import java.util.Map;

public class PersonServiceTest {

  private PersonService personService;
  private PersonDao personDao;

  private Person testPerson;

  public PersonServiceTest() {
    this.personDao = new ListPersonDao();
    this.personService = new ListPersonService(this.personDao);

    Person admin = new Admin("root", "root", 100_000.0);
    this.testPerson = admin;
    this.personDao.add(admin);
  }

  @Test
  public void add() {
    int expect = 2;
    Map<String, String> data = new HashMap<>();
    data.put("name", "viktor");
    data.put("password", "1111");
    data.put("account", "500");
    this.personService.add(data);
    Assertions.assertEquals(expect, this.personService.findAll().size());
  }

  @Test
  public void addUserExistError() {
    try {
      Map<String, String> data = new HashMap<>();
      data.put("name", "root");
      data.put("password", "1111");
      data.put("account", "500");
      this.personService.add(data);

    } catch (PersonNameException e) {
      String expect = "Entered name is exist (name must be uniq)";
      Assertions.assertEquals(expect, e.getMessage());
    }
  }

  @Test
  public void addAccountError() {
    try {
      Map<String, String> data = new HashMap<>();
      data.put("name", "viktor");
      data.put("password", "1111");
      data.put("account", "notNumber");
      this.personService.add(data);

    } catch (AccountException e) {
      String expect = "Account is not correct";
      Assertions.assertEquals(expect, e.getMessage());
    }
  }

  @Test
  public void delete() {
    int expect = 2;
    Map<String, String> data = new HashMap<>();
    data.put("name", "viktor");
    data.put("password", "1111");
    data.put("account", "500");
    this.personService.add(data);
    Assertions.assertEquals(expect, this.personService.findAll().size());
    this.personService.delete(data);
    Assertions.assertEquals(expect - 1, this.personService.findAll().size());
  }

  @Test
  public void deleteUserNotExistError() {
    try {
      int expect = 2;
      Map<String, String> data = new HashMap<>();
      data.put("name", "viktor");
      data.put("password", "1111");
      data.put("account", "500");
      Map<String, String> data2 = new HashMap<>();
      data.put("name", "bob");
      this.personService.add(data);
      Assertions.assertEquals(expect, this.personService.findAll().size());
      this.personService.delete(data2);
      Assertions.assertEquals(expect - 1, this.personService.findAll().size());

    } catch (NameException e) {
      String expect = "Name is not correct";
      Assertions.assertEquals(expect, e.getMessage());
    }
  }

  @Test
  public void findAll() {
    Assertions.assertEquals(1, this.personService.findAll().size());
  }

  @Test
  public void findAllEmptyError() {
    try {
      Map<String, String> data = new HashMap<>();
      data.put("name", "root");
      this.personService.delete(data);
      this.personService.findAll();

    } catch (EmptyException e) {
      String expect = "No data to show";
      Assertions.assertEquals(expect, e.getMessage());
    }
  }

  @Test
  public void findById() {
    Map<String, String> data2 = new HashMap<>();
    data2.put("id", this.testPerson.getId());
    Person person2 = this.personService.findById(data2);

    Assertions.assertEquals(this.testPerson, person2);
  }

  @Test
  public void findByIdError() {
    try {
      Map<String, String> data2 = new HashMap<>();
      data2.put("id", "sqsxdw");
      this.personService.findById(data2);

    } catch (PersonNameException e) {
      String expect = "Entered name is exist (name must be uniq)";
      Assertions.assertEquals(expect, e.getMessage());
    }
  }

  @Test
  public void login() {
    Map<String, String> data2 = new HashMap<>();
    data2.put("name", "root");
    data2.put("password", "root");
    Person person2 = this.personService.login(data2);

    Assertions.assertEquals(this.testPerson, person2);
  }

  @Test
  public void loginNameError() {
    try {
      Map<String, String> data2 = new HashMap<>();
      data2.put("name", "notRoot");
      data2.put("password", "root");
      this.personService.login(data2);

    } catch (NameException e) {
      String expect = "Name is not correct";
      Assertions.assertEquals(expect, e.getMessage());
    }
  }

  @Test
  public void loginPasswordError() {
    try {
      Map<String, String> data2 = new HashMap<>();
      data2.put("name", "root");
      data2.put("password", "notRootPassword");
      this.personService.login(data2);

    } catch (PasswordException e) {
      String expect = "Password is not correct";
      Assertions.assertEquals(expect, e.getMessage());
    }
  }

  @Test
  public void findByName() {
    Map<String, String> data = new HashMap<>();
    data.put("name", "root");
    Person person = this.personService.findByName(data);

    Assertions.assertEquals(person, this.testPerson);
  }

  @Test
  public void findByNameError() {
    try {
      Map<String, String> data2 = new HashMap<>();
      data2.put("name", "noName");
      this.personService.findByName(data2);

    } catch (PersonNotExistException e) {
      String expect = "Client with this name doesn't exist";
      Assertions.assertEquals(expect, e.getMessage());
    }
  }
}
