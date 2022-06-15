import model.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

  private static final String FILE_NAME = "logs.txt";

  private static void save(String str) {
    File file = new File(FILE_NAME);

    try {
      FileWriter fileWriter = new FileWriter(file, true);
      fileWriter.write(str + '\n');
      fileWriter.flush();

    } catch (IOException e) {
      e.getMessage();
    }
  }

  public static void saveErrorLogs(Person person, String message) {
    save("Error: " + new Date() + "; Name: " + person.getName() + "; " + message);
  }

  public static void saveLoginErrorLogs(String message) {
    save("Login error: " + new Date() + "; " + message);
  }
}
