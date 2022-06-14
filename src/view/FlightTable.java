package view;

import model.Flight;
import helper.Helper;
import model.Id;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class FlightTable {
  public static void showFlights(List<Flight> flights) {

    if (flights.size() == 0) return;

    HeaderFlightTable[] header = HeaderFlightTable.values();

    List<Integer> maxes = new ArrayList<>();
    maxes.add(String.valueOf(flights.size()).length());
    maxes.add(Id.getLength());
    maxes.add(flights.stream()
        .max(Comparator.comparingInt(f -> f.getTime().length()))
        .get().getTime().length());
    maxes.add(flights.stream()
        .max(Comparator.comparingInt(f -> f.getFromCity().getName().length()))
        .get().getFromCity().getName().length());
    maxes.add(flights.stream()
        .max(Comparator.comparingInt(f -> f.getToCity().getName().length()))
        .get().getToCity().getName().length());
    maxes.add(flights.stream()
        .max(Comparator.comparingInt(f -> f.getAirline().getName().length()))
        .get().getAirline().getName().length());
    maxes.add(flights.stream()
        .max(Comparator.comparingInt(f -> f.getAirplane().getName().length()))
        .get().getAirplane().getName().length());
    maxes.add(String.valueOf(flights.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getCountOfFreeTickets()).length()))
        .get().getCountOfFreeTickets()).length());
    maxes.add(String.valueOf(flights.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getCountOfFreeTickets()).length()))
        .get().getCountOfFreeTickets()).length());


    String headerStr = IntStream.range(0, header.length)
        .mapToObj(i -> {
          String h = header[i].getName();
          int hln = h.length();
          int max = maxes.get(i);
          return "| " + h + (hln > max ? " " : Helper.charRepeat((max - hln) + 1, ' '));
        })
        .reduce("", (s1, s2) -> s1 + s2) + "|";

    System.out.println(Helper.charRepeat(headerStr.length(), '*'));
    System.out.println(headerStr);
    System.out.println(Helper.charRepeat(headerStr.length(), '*'));

    IntStream.range(0, flights.size()).forEach(i -> {
      Flight flight = flights.get(i);
      StringBuilder str = new StringBuilder();
      String separator = " | ";

      str.append("| ")
          .append(i + 1)
          .append(Helper.charRepeat(maxes.get(0) - String.valueOf(i + 1).length(), ' '));

      str.append(separator)
          .append(flight.getId())
          .append(Helper.charRepeat(maxes.get(1) - flight.getId().length(), ' '));

      str.append(separator)
          .append(flight.getTime())
          .append(Helper.charRepeat(maxes.get(2) - flight.getTime().length(), ' '));

      str.append(separator)
          .append(flight.getFromCity().getName())
          .append(Helper.charRepeat(maxes.get(3) - flight.getFromCity().getName().length(), ' '));

      str.append(separator)
          .append(flight.getToCity().getName())
          .append(Helper.charRepeat(maxes.get(4) - flight.getToCity().getName().length(), ' '));

      str.append(separator)
          .append(flight.getAirline().getName())
          .append(Helper.charRepeat(maxes.get(5) - flight.getAirline().getName().length(), ' '));

      str.append(separator)
          .append(flight.getAirplane().getName())
          .append(Helper.charRepeat(maxes.get(6) - flight.getAirplane().getName().length(), ' '));

      str.append(separator)
          .append(flight.getCountOfFreeTickets())
          .append(Helper.charRepeat((maxes.get(7) > header[7].getName().length() ? maxes.get(7) : header[7].getName().length())
              - String.valueOf(flight.getCountOfFreeTickets()).length(), ' '));

      str.append(separator)
          .append(flight.getCountOfFreeTickets())
          .append(Helper.charRepeat((maxes.get(8) > header[8].getName().length() ? maxes.get(8) : header[8].getName().length())
              - String.valueOf(flight.getCountOfFreeTickets()).length(), ' '));

      str.append(" |");

      System.out.println(str);

      System.out.println(Helper.charRepeat(headerStr.length(), '-'));
    });
  }
}
