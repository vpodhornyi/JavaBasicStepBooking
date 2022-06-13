package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonView {

  public static Map<String, String> login(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter name: ");
    String name = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    data.put("name", name);
    data.put("password", password);

    return data;
  }

}
