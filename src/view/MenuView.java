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

  public static int mainMenu(Scanner scanner, Person person) {
    printBorder(person.getWelcomeString() + " | ", "(1) Generate data, (2) Show flights, (3) Create person, (4) Booking flight, (5) Logout");
    return Helper.getNumberFromConsole("Enter menu number: ", 5, scanner);
  }
}
