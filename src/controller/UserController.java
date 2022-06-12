package controller;

import model.Person;
import service.UserService;

public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  public void add(Person user) {
    userService.add(user);
  }
}
