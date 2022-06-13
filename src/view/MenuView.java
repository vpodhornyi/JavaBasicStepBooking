package view;

import helper.Helper;

import java.util.Scanner;

public class MenuView {

  private static void printBorder(String str) {
    int ln = str.length() + 6;

    System.out.println("Menu: " + str + "");
    System.out.println(Helper.charRepeat(ln, '-'));
  }

  public static int loginMenu(Scanner scanner) {

    String[] menuArr = new String[]{"Login", "Exit"};
    String menu = "(1) Login, (2) Exit";
    printBorder(menu);

    System.out.println("Enter menu number: ");
    scanner.nextLine();


    return 2;
  }
}
