package helper;

import exception.NumberException;

import java.util.Scanner;

public class Helper {

  public static String charRepeat(int length, char ch) {
    return String.valueOf(ch).repeat(Math.max(0, length));
  }

  public static int getNumberFromConsole(String str, int max, Scanner scanner) {
    System.out.print(str);
    String line = scanner.nextLine();
    int n;

    try {
      n = Integer.parseInt(line);

    } catch (RuntimeException e) {
      throw new NumberException();
    }

    if (n < 1 || n > max) throw new NumberException();

    return n;
  }

  public static void printBorder(String str, Character ch) {
    int ln = str.length() + 4;

    System.out.println(charRepeat(ln, ch));
    System.out.println("- " + str + " -");
    System.out.println(charRepeat(ln, ch));
  }
}
