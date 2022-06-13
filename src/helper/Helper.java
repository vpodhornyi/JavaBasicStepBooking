package helper;

public class Helper {

  public static String charRepeat(int length, char ch) {
    return String.valueOf(ch).repeat(Math.max(0, length));
  }
}
