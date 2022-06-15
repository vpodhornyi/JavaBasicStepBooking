package model;

public enum Airline {
  AlaskaAirlines("Alaska Airlines", -10),
  AllegiantAir("Allegiant Air", 15),
  AmericanAirlines("American Airlines", 20);
  private final String name;
  private final int costPercent;

  Airline(String name, int costPercent) {
    this.name = name;
    this.costPercent = costPercent;
  }

  public String getName() {
    return this.name;
  }

  public int getCostPercent() {
    return costPercent;
  }
}
