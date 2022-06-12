import controller.UserController;
import dao.ListPersonDao;
import dao.PersonDao;
import model.Client;
import model.Person;
import service.ListUserService;

public class App {
  public static void main(String[] args) {
    Person client1 = new Client("Viktor", "111");
    Person client2 = new Client("Alex", "111");

    PersonDao personDao = new ListPersonDao();
    

    personDao.add(client1);
    personDao.add(client2);

    System.out.println(personDao);
//
    personDao.save();

//    Optional<List<User>> users = userDao.load();

//    users.get().forEach(System.out::println);

    Loop loop = new Loop(new UserController(new ListUserService(new ListPersonDao())));

//    loop.run();
  }
}
