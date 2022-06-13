package view;

import model.Flight;
import helper.Helper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class FlightTable {
  public static void showFlights(List<Flight> flights) {



    HeaderFlightTable[] header = HeaderFlightTable.values();

    List<Integer> maxes = new ArrayList<>();
    maxes.add(String.valueOf(flights.size()).length());
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
    maxes.add(flights.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getTickets().size()).length()))
        .get().getAirplane().getName().length());
    maxes.add(flights.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getTickets().size()).length()))
        .get().getAirplane().getName().length());


    String headerStr = IntStream.range(0, header.length)
        .mapToObj(i -> {
          String h = header[i].getName();
          int hln = h.length();
          int max = maxes.get(i);
          return "| " + h + (hln > max ? "" : Helper.charRepeat((max - hln) + (i == 0 ? 0 : 2), ' ')) + " ";
        })
        .reduce("", (s1, s2) -> s1 + s2) + "|";

    System.out.println(Helper.charRepeat(headerStr.length(), '*'));
    System.out.println(headerStr);
    System.out.println(Helper.charRepeat(headerStr.length(), '*'));

    IntStream.range(0, flights.size()).forEach(i -> {
      Flight flight = flights.get(i);
      StringBuilder str = new StringBuilder();

      str.append("| ")
          .append(i + 1)
          .append(Helper.charRepeat(maxes.get(0) - String.valueOf(i + 1).length(), ' '));

      str.append(" |  ")
          .append(flight.getTime())
          .append(Helper.charRepeat(maxes.get(1) - flight.getTime().length(), ' '));

      str.append("  |  ")
          .append(flight.getFromCity().getName())
          .append(Helper.charRepeat(maxes.get(2) - flight.getFromCity().getName().length(), ' '));

      str.append("  |  ")
          .append(flight.getToCity().getName())
          .append(Helper.charRepeat(maxes.get(3) - flight.getToCity().getName().length(), ' '));

      str.append("  |  ")
          .append(flight.getAirline().getName())
          .append(Helper.charRepeat(maxes.get(4) - flight.getAirline().getName().length(), ' '));

      str.append("  |  ")
          .append(flight.getAirplane().getName())
          .append(Helper.charRepeat(maxes.get(5) - flight.getAirplane().getName().length(), ' '));

      str.append("  | ")
          .append(flight.getTickets().size())
          .append(Helper.charRepeat((maxes.get(6) > header[6].getName().length() ? maxes.get(6) : header[6].getName().length())
              - String.valueOf(flight.getTickets().size()).length(), ' '));

      str.append(" | ")
          .append(flight.getTickets().size())
          .append(Helper.charRepeat((maxes.get(7) > header[7].getName().length() ? maxes.get(7) : header[7].getName().length())


      - String.valueOf(flight.getTickets().size()).length(), ' '));

      str.append(" |");

      System.out.println(str);

      System.out.println(Helper.charRepeat(headerStr.length(), '-'));
    });
  }
}
