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

  public static Map<String, String> getNamePasswordAccount(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter name: ");
    String name = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    System.out.print("Enter balance account: ");
    String account = scanner.nextLine();

    data.put("name", name);
    data.put("password", password);
    data.put("account", account);

    return data;
  }

  public static Map<String, String> getName(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter name: ");
    String name = scanner.nextLine();

    data.put("name", name);

    return data;
  }

  public static Map<String, String> getMinCost(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter min cost: ");
    String cost = scanner.nextLine();

    data.put("cost", cost);

    return data;
  }

  public static Map<String, String> getFlightId(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter flight ID: ");
    String id = scanner.nextLine();

    data.put("id", id);

    return data;
  }

  public static Map<String, String> getTicketId(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter ticket ID: ");
    String id = scanner.nextLine();

    data.put("id", id);

    return data;
  }

  public static Map<String, String> getDate(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter start day yyyy-MM-dd ID: ");
    String startDay = scanner.nextLine();
    System.out.print("Enter end day yyyy-MM-dd ID: ");
    String endDay = scanner.nextLine();

    data.put("startDay", startDay);
    data.put("endDay", endDay);

    return data;
  }

  public static Map<String, String> getFlightIdClientName(Scanner scanner) {
    Map<String, String> data = new HashMap<>();
    System.out.print("Enter name: ");
    String name = scanner.nextLine();
    System.out.print("Enter flight ID: ");
    String id = scanner.nextLine();

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



}
