import model.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Generator {
  private Set<Ticket> generateTickets(Flight flight) {
    Airplane airplane = flight.getAirplane();
    int seats = airplane.getSeats();

    Set<Ticket> tickets = new HashSet<>();

    for (int i = 0; i < seats; i++) {
      tickets.add(new BaseTicket(flight));
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

  public List<Flight> generateFlights(int countFlights, int countDays) {
    List<Flight> flights = new ArrayList<>();

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

    return flights;
  }
}
