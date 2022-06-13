package model;

public enum Airplane {
  ATR_42("ATR 42", 2),
  ATR_72("ATR 72", 3),
  AIRBUS_A220("Airbus A220", 7),
  AIRBUS_A300("Airbus A300", 5),
  AIRBUS_A310("Airbus A310", 9),
  AIRBUS_A318("Airbus A318", 3),
  AIRBUS_A319("Airbus A319", 4),
  AIRBUS_A320("Airbus A320", 3),
  BOEING_737("Boeing 737", 10),
  BOEING_747("Boeing 737", 11),
  BOEING_777("Boeing 737", 12),
  BOEING_787("Boeing 737", 15);

  private final String name;
  private final int seats;

  Airplane(String name, int countPassengers) {
    this.name = name;
    this.seats = countPassengers;
  }

  public String getName() {
    return this.name;
  }

  public int getSeats() {return this.seats;}
}
