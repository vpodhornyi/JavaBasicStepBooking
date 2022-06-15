package view;

import helper.Helper;
import model.Person;

import java.util.Scanner;

public class MenuView {

  private static void printBorder(String str1, String str2) {
    int ln = str2.length() + 6;

    System.out.println(Helper.charRepeat(ln, '-'));
    System.out.print(str1);
    System.out.println("Menu: " + str2);
    System.out.println(Helper.charRepeat(ln, '-'));
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
