import controller.PersonController;
import dao.ListPersonDao;
import dao.PersonDao;
import model.Client;
import model.Person;
import service.ListPersonService;

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

    Loop loop = new Loop(new PersonController(new ListPersonService(new ListPersonDao())));

//    loop.run();
  }
}
