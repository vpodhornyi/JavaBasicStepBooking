package model;

import java.io.Serializable;
import java.util.Random;

public abstract class Id implements Serializable {
  private final String id;
  private static final int ID_LENGTH = 5;

  public Id() {
    this.id = this.getRandomString();
  }

  private String getRandomString() {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    Random random = new Random();

    return random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(ID_LENGTH)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }

  public String getId() {
    return this.id;
  }

  public static int getLength() {
    return ID_LENGTH;
  }
}
