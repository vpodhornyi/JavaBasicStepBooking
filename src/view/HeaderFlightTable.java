package view;

public enum HeaderFlightTable {
  NUMBER("№"),
  ID("ID"),
  DATE("Date"),
  CITY_FROM("From"),
  CITY_TO("To"),
  AIRLINE("Airline"),
  AIRPLANE("Airplane"),
  FREE_BASE_TICKETS("Free base tickets"),
  BASE_COST("Cost"),
  FREE_BUSINESS_TICKETS("Free business tickets"),
  BUSINESS_COST("Cost");

  private final String name;

  HeaderFlightTable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
