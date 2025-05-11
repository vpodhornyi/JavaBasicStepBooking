package view;

import utils.Helper;
import model.Airline;
import model.Airplane;
import model.City;
import model.Person;

import java.util.*;
import java.util.stream.IntStream;

public class MenuView {

  private static void printBorder(String str1, String str2) {
    int ln = str2.length() + 6;

    System.out.println(Helper.charRepeat(ln, '-'));
    System.out.print(str1);
    System.out.println("Menu: " + str2);
    System.out.println(Helper.charRepeat(ln, '-'));
  }

  private static String arrToMenuString(List<String> list) {
    String str = IntStream.range(0, list.size())
        .mapToObj(i -> "(" + (i + 1) + ") " + list.get(i) + ", ")
        .reduce("", (s1, s2) -> s1 + s2);
    return str.substring(0, str.length() - 2);
  }

  public static int loginMenu(Scanner scanner) {
    printBorder("", "(1) Login, (2) Exit");

    return Helper.getNumberFromConsole("Enter menu number: ", 2, scanner);
  }

  public static int bookingChoose(Scanner scanner) {
    printBorder("", "(1) For himself, (2) For Client, (3) Cansel");

    return Helper.getNumberFromConsole("Enter menu number: ", 3, scanner);
  }

  public static int personChoose(Scanner scanner) {
    printBorder("", "(1) Own, (2) Clint, (3) Cansel");

    return Helper.getNumberFromConsole("Enter menu number: ", 3, scanner);
  }

  public static int ticketChoose(Scanner scanner) {
    printBorder("", "(1) Base, (2) Business, (3) Cansel");

    return Helper.getNumberFromConsole("Enter ticket number: ", 3, scanner);
  }

  public static int flightFilterChoose(Scanner scanner) {
    List<String> arr = List.of("City from", "City to", "City from/to", "Airline",
        "Airplane", "Min cost", "Date from/to", "Cansel");
    printBorder("", arrToMenuString(arr));
    return Helper.getNumberFromConsole("Enter menu number: ", arr.size(), scanner);
  }

  public static City citiesChoose(Scanner scanner) {
    City[] values = City.values();
    List<String> list = Arrays.stream(City.values()).map(City::getName).toList();
    System.out.println(arrToMenuString(list));
    int index = Helper.getNumberFromConsole("Enter city number: ", list.size(), scanner);

    return values[index - 1];
  }
  public static Map<String, City> citiesFromToChoose(Scanner scanner) {
    City[] values = City.values();
    List<String> list = Arrays.stream(City.values()).map(City::getName).toList();
    System.out.println(arrToMenuString(list));
    int index1 = Helper.getNumberFromConsole("Enter 'From' city number: ", list.size(), scanner);
    int index2 = Helper.getNumberFromConsole("Enter 'To' city number: ", list.size(), scanner);

    Map<String, City> data = new HashMap<>();
    data.put("fromCity", values[index1 - 1]);
    data.put("toCity", values[index2 - 1]);

    return data;
  }

  public static Airline airlineChoose(Scanner scanner) {
    Airline[] values = Airline.values();
    List<String> list = Arrays.stream(Airline.values()).map(Airline::getName).toList();
    System.out.println(arrToMenuString(list));
    int index = Helper.getNumberFromConsole("Enter airline number: ", list.size(), scanner);

    return values[index - 1];
  }

  public static Airplane airplaneChoose(Scanner scanner) {
    Airplane[] values = Airplane.values();
    List<String> list = Arrays.stream(Airplane.values()).map(Airplane::getName).toList();
    System.out.println(arrToMenuString(list));
    int index = Helper.getNumberFromConsole("Enter airplane number: ", list.size(), scanner);

    return values[index - 1];
  }

  public static int mainMenuAdmin(Scanner scanner, Person person) {
    printBorder(person.getWelcomeString() + "\n", "" +
        "(1) Generate data, " +
        "(2) Show flights, " +
        "(3) Show flights (filter), " +
        "(4) Create Person, " +
        "(5) Delete Person, " +
        "(6) Show Persons, " +
        "(7) Booking, " +
        "(8) Unhooking, " +
        "(9) Show booking ticket(s), " +
//        "(10) Change person account, " +    TODO change person account
        "(10) Logout");
    return Helper.getNumberFromConsole("Enter menu number: ", 10, scanner);
  }

  public static int mainMenuClient(Scanner scanner, Person person) {
    printBorder(person.getWelcomeString() + "\n", "" +
        "(1) Show flights, " +
        "(2) Show flights (filter), " +
        "(3) Booking, " +
        "(4) Unhooking, " +
        "(5) Show booking ticket(s), " +
        "(6) Logout");
    return Helper.getNumberFromConsole("Enter menu number: ", 6, scanner);
  }
}
