package view;

import exception.NumberException;
import helper.Helper;
import model.Person;

import java.util.Scanner;

public class MenuView {

  private static void printBorder(String str1, String str2) {
    int ln = str1.length() + str2.length() + 6;

    System.out.println(Helper.charRepeat(ln, '-'));
    System.out.println(str1 + "Menu: " + str2);
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

  public static int ticketChoose(Scanner scanner) {
    printBorder("", "(1) Base, (2) Business, (3) Cansel");

    return Helper.getNumberFromConsole("Enter ticket number: ", 3, scanner);
  }

  public static int mainMenu(Scanner scanner, Person person) {
    printBorder(person.getWelcomeString() + " | ", "" +
        "(1) Generate data, " +
        "(2) Show flights, " +
        "(3) Create Client, " +
        "(4) Delete Client, " +
        "(5) Show Clients, " +
        "(6) Booking flight, " +
        "(7) Logout");
    return Helper.getNumberFromConsole("Enter menu number: ", 7, scanner);
  }
}
