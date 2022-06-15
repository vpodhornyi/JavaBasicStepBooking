package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {

  public static Map<String, String> getNamePassword(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter name: ");
    String name = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    data.put("name", name);
    data.put("password", password);

    return data;
  }

  public static Map<String, String> getName(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter name: ");
    String name = scanner.nextLine();

    data.put("name", name);

    return data;
  }

  public static Map<String, String> getFlightId(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter flight ID: ");
    String id = scanner.nextLine();

    data.put("id", id);

    return data;
  }

  public static Map<String, String> getFlightIdClientName(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter flight ID: ");
    String id = scanner.nextLine();
    System.out.print("Enter name: ");
    String name = scanner.nextLine();

    data.put("id", id);
    data.put("name", name);

    return data;
  }

  public static Map<String, String> getGeneratorFlightsData(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter count flights: ");
    String countFlights = scanner.nextLine();
    System.out.print("Enter count days: ");
    String countDays = scanner.nextLine();

    data.put("countFlights", countFlights);
    data.put("countDays", countDays);

    return data;
  }

  public static String string(Scanner scanner, String str) {
    System.out.print(str);
    return scanner.nextLine();
  }
}
