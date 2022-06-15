package model;

public enum City {
  Delhi("Delhi"),
  Sendai("Sendai"),
  Baku("Baku"),
  Vancouver("Vancouver"),
  Dubai("Dubai"),
  Lisbon("Lisbon"),
  LosAngeles("Los Angeles"),
  Rome("Rome"),
  Sydney("Sydney"),
  Ankara("Ankara"),
  Barcelona("Barcelona"),
  Singapore("Singapore"),
  Toronto("Toronto"),
  HongKong("Hong Kong"),
  NewYorkCity("New York City"),
  London("London"),
  Paris("Paris"),
  RioDeJaneiro("Rio De Janeiro"),
  BuenosAires("Buenos Aires"),
  Mumbai("Mumbai"),
  MexicoCity("Mexico City"),
  SaoPaulo("Sao Paulo"),
  Dhaka("Dhaka"),
  Shanghai("Shanghai"),
  Berlin("Berlin"),
  Kyiv("Kyiv"),
  Madrid("Madrid"),
  Bucharest("Bucharest"),
  Vienna("Vienna"),
  Hamburg("Hamburg"),
  Warsaw("Warsaw"),
  Budapest("Budapest"),
  Tokyo("Tokyo");

  private final String name;

  City(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
