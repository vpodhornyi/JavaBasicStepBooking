import exception.NumberException;
import model.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Generator {
  private Set<Ticket> generateTickets(Flight flight) {
    Airplane airplane = flight.getAirplane();
    int baseSeats = airplane.getBaseSeats();
    int businessSeats = airplane.getBusinessSeats();

    Set<Ticket> tickets = new HashSet<>();

    for (int i = 0; i < baseSeats; i++) {
      tickets.add(new BaseTicket(flight));
    }

    for (int i = 0; i < businessSeats; i++) {
      tickets.add(new BusinessTicket(flight));
    }

    return tickets;
  }

  private City getRandomCity() {
    City[] values = City.values();
    int ln = values.length;

    return values[new Random().nextInt(ln)];
  }

  private Airline getRandomAirline() {
    Airline[] values = Airline.values();
    int ln = values.length;

    return values[new Random().nextInt(ln)];
  }

  private Airplane getRandomAirplane() {
    Airplane[] values = Airplane.values();
    int ln = values.length;

    return values[new Random().nextInt(ln)];
  }

  private long getRandomDate(int countDays) {
    long startMillis = new Date().getTime();
    long endMillis = new Date(startMillis + TimeUnit.DAYS.toMillis(1) * countDays).getTime();

    return ThreadLocalRandom.current().nextLong(startMillis, endMillis);
  }

  public List<Flight> generateFlights(Map<String, String> data) {
    List<Flight> flights = new ArrayList<>();
    final String FIELD_COUNT_FLIGHTS = "countFlights";
    final String FIELD_COUNT_DAYS = "countDays";

    try {
      int countFlights = Integer.parseInt(data.get(FIELD_COUNT_FLIGHTS));
      int countDays = Integer.parseInt(data.get(FIELD_COUNT_DAYS));

      for (int i = 0; i < countFlights; i++) {
        City fromCity = getRandomCity();
        City toCity;
        do {
          toCity = getRandomCity();
        } while (fromCity.equals(toCity));

        Flight flight = new Flight(fromCity, toCity, getRandomAirline(), getRandomAirplane(), getRandomDate(countDays));
        flights.add(flight);
        flight.setTickets(generateTickets(flight));
      }

    } catch (Exception e) {
      throw new NumberException();
    }

    return flights;
  }
}
