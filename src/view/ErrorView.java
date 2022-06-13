package view;

import helper.Helper;

public class ErrorView {
  private static void printBorder(String str) {
    int ln = str.length() + 4;

    System.out.println(Helper.charRepeat(ln, '-'));
    System.out.println("- " + str + " -");
    System.out.println(Helper.charRepeat(ln, '-'));
  }

  public static void nameError() {
    printBorder("Name is not correct");
  }

  public static void passwordError() {
    printBorder("Password is not correct");
  }

  public static void menuNumberError() {
    printBorder("Menu number is not correct");
  }

}
