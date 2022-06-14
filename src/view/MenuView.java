package view;

import exception.NumberException;
import helper.Helper;

import java.util.Scanner;

public class MenuView {

  private static void printBorder(String str) {
    int ln = str.length() + 6;

    System.out.println(Helper.charRepeat(ln, '-'));
    System.out.println("Menu: " + str + "");
    System.out.println(Helper.charRepeat(ln, '-'));
  }

  public static int loginMenu(Scanner scanner) {
    printBorder("(1) Login, (2) Exit");

    return Helper.getNumberFromConsole("Enter menu number: ", 2, scanner);
  }

  public static int mainMenu(Scanner scanner) {
    printBorder("(1) Generate data, (2) Show flights, (3) Create person, (4) Booking flight");
    return Helper.getNumberFromConsole("Enter menu number: ", 2, scanner);
  }
}
