import controller.UserController;
import dao.ListUserDao;
import dao.UserDao;
import model.Client;
import model.User;
import service.ListUserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class App {
  public static void main(String[] args) {
    User client1 = new Client("Viktor", "111");
    User client2 = new Client("Alex", "111");

    UserDao userDao = new ListUserDao();

    userDao.add(client1);
    userDao.add(client2);

//    System.out.println(userDao);
//
    userDao.save();

//    Optional<List<User>> users = userDao.load();

//    users.get().forEach(System.out::println);

    Loop loop = new Loop(new UserController(new ListUserService(new ListUserDao())));


    try {
      loop.run();

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
