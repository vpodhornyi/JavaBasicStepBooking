package model;

public enum Airplane {
  ATR_42("ATR 42", 2, 5),
  ATR_72("ATR 72", 3, 4),
  AIRBUS_A220("Airbus A220", 7, 6),
  AIRBUS_A300("Airbus A300", 5, 7),
  AIRBUS_A310("Airbus A310", 9, 3),
  AIRBUS_A318("Airbus A318", 3, 0),
  AIRBUS_A319("Airbus A319", 4, 10),
  AIRBUS_A320("Airbus A320", 3, 2),
  BOEING_737("Boeing 737", 10, 0),
  BOEING_747("Boeing 737", 11, 15),
  BOEING_777("Boeing 737", 12, 5),
  BOEING_787("Boeing 737", 15, 1);

  private final String name;
  private final int baseSeats;
  private final int businessSeats;

  Airplane(String name, int baseSeats, int businessSeats) {
    this.name = name;
    this.baseSeats = baseSeats;
    this.businessSeats = businessSeats;
  }

  public String getName() {
    return this.name;
  }

  public int getBaseSeats() {return this.baseSeats;}
  public int getBusinessSeats() {return this.businessSeats;}
}
