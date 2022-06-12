package controller;

import model.Person;
import service.PersonService;

public class PersonController {

  private final PersonService userService;

  public PersonController(PersonService userService) {
    this.userService = userService;
  }

  public void add(Person user) {
    userService.add(user);
  }
}
