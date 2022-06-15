package view;

public enum HeaderTicketsTable {
  NUMBER("№"),
  ID("Ticket ID"),
  CITY_FROM("From"),
  CITY_TO("To"),
  DATE("Date"),
  AIRLINE("Airline"),
  AIRPLANE("Airplane"),
  FLIGHT("Flight ID"),
  TICKET_TYPE("Ticket type"),
  COST("Cost");

  private final String name;

  HeaderTicketsTable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
