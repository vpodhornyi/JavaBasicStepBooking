package model;

import java.io.Serializable;
import java.util.Random;

public abstract class Id  implements Serializable {
  private final String id;

  public Id() {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 20;
    Random random = new Random();

    this.id = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }

  public String getId() {
    return this.id;
  }
}
