package view;

public enum HeaderFlightTable {
  ID("№"),
  DATE("Date"),
  CITY_FROM("From"),
  CITY_TO("To"),
  AIRLINE("Airline"),
  AIRPLANE("Airplane"),
  FREE_BASE_TICKETS("Free base tickets"),
  FREE_BUSINESS_TICKETS("Free business tickets");

  private final String name;

  HeaderFlightTable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
