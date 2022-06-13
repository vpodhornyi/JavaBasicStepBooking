package helper;

import view.ErrorView;

import java.util.Scanner;

public class Helper {

  public static String charRepeat(int length, char ch) {
    return String.valueOf(ch).repeat(Math.max(0, length));
  }

  private int getNumberFromConsole(String str, int max, Scanner scanner) {
    System.out.print(str);
    int n;
    while ((n = scanner.hasNextInt() ? scanner.nextInt() : -1) == -1 || n < 1 || n > max) {
      ErrorView.menuNumberError();
      scanner.nextLine();
    }
    return n;
  }
}
