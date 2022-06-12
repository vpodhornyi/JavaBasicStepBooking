package model;

public enum Airplane {
  ATR_42("ATR 42", 10),
  ATR_72("ATR 72", 17),
  AIRBUS_A220("Airbus A220", 17),
  AIRBUS_A300("Airbus A300", 17),
  AIRBUS_A310("Airbus A310", 17),
  AIRBUS_A318("Airbus A318", 17),
  AIRBUS_A319("Airbus A319", 17),
  AIRBUS_A320("Airbus A320", 17),
  BOEING_737("Boeing 737", 17),
  BOEING_747("Boeing 737", 17),
  BOEING_777("Boeing 737", 17),
  BOEING_787("Boeing 737", 17);

  private final String name;
  private final int countPassengers;

  Airplane(String name, int countPassengers) {
    this.name = name;
    this.countPassengers = countPassengers;
  }
}
