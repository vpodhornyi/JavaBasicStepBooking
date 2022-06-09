package controller;

import model.User;
import service.UserService;

public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  public void add(User user) {
    userService.add(user);
  }
}
