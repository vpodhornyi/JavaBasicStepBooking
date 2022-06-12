package model;

public enum Airline {
  AlaskaAirlines("Alaska Airlines"),
  AllegiantAir("Allegiant Air"),
  AmericanAirlines("American Airlines");
  private final String name;

  Airline(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
