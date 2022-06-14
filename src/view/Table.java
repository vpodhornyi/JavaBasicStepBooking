package view;

import model.Flight;
import helper.Helper;
import model.Id;
import model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Table {

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

   List<Integer>headerLn =  new ArrayList<>();

    String headerStr = IntStream.range(0, header.length)
        .mapToObj(i -> {
          String h = header[i].getName();
          int hln = h.length();
          int max = maxes.get(i);
          String str =  "| " + h + (hln > max ? " " : Helper.charRepeat((max - hln) + 1, ' '));
          headerLn.add(str.length() - 3);
          return str;
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
          .append(Helper.charRepeat(headerLn.get(1) - flight.getId().length(), ' '));

      str.append(separator)
          .append(flight.getTime())
          .append(Helper.charRepeat(headerLn.get(2) - flight.getTime().length(), ' '));

      str.append(separator)
          .append(flight.getFromCity().getName())
          .append(Helper.charRepeat(headerLn.get(3) - flight.getFromCity().getName().length(), ' '));

      str.append(separator)
          .append(flight.getToCity().getName())
          .append(Helper.charRepeat(headerLn.get(4) - flight.getToCity().getName().length(), ' '));

      str.append(separator)
          .append(flight.getAirline().getName())
          .append(Helper.charRepeat(headerLn.get(5) - flight.getAirline().getName().length(), ' '));

      str.append(separator)
          .append(flight.getAirplane().getName())
          .append(Helper.charRepeat(headerLn.get(6) - flight.getAirplane().getName().length(), ' '));

      str.append(separator)
          .append(flight.getCountOfFreeTickets())
          .append(Helper.charRepeat(headerLn.get(7) - String.valueOf(flight.getCountOfFreeTickets()).length(), ' '));

      str.append(separator)
          .append(flight.getCountOfFreeTickets())
          .append(Helper.charRepeat(headerLn.get(8) - String.valueOf(flight.getCountOfFreeTickets()).length(), ' '));

      str.append(" |");

      System.out.println(str);

      System.out.println(Helper.charRepeat(headerStr.length(), '-'));
    });
  }

  public static void showPeople(List<Person> people) {

    if (people.size() == 0) return;

    HeaderPersonTable[] header = HeaderPersonTable.values();

    List<Integer> maxes = new ArrayList<>();

    maxes.add(String.valueOf(people.size()).length());
    maxes.add(people.stream()
        .max(Comparator.comparingInt(f -> f.getName().length()))
        .get().getName().length());
    maxes.add(people.stream()
        .max(Comparator.comparingInt(f -> f.getPassword().length()))
        .get().getPassword().length());
    maxes.add(people.stream()
        .max(Comparator.comparingInt(f -> f.getRole().length()))
        .get().getRole().length());
    maxes.add(String.valueOf(people.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getTickets().size()).length()))
        .get().getTickets().size()).length());
    maxes.add(String.valueOf(people.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getTickets().size()).length()))
        .get().getTickets().size()).length());

    List<Integer>headerLn =  new ArrayList<>();

    String headerStr = IntStream.range(0, header.length)
        .mapToObj(i -> {
          String h = header[i].getName();
          int hln = h.length();
          int max = maxes.get(i);
          String str =  "| " + h + (hln > max ? " " : Helper.charRepeat((max - hln) + 1, ' '));
          headerLn.add(str.length() - 3);
          return str;
        })
        .reduce("", (s1, s2) -> s1 + s2) + "|";

    System.out.println(Helper.charRepeat(headerStr.length(), '*'));
    System.out.println(headerStr);
    System.out.println(Helper.charRepeat(headerStr.length(), '*'));

    IntStream.range(0, people.size()).forEach(i -> {
      Person person = people.get(i);
      StringBuilder str = new StringBuilder();
      String separator = " | ";

      str.append("| ")
          .append(i + 1)
          .append(Helper.charRepeat(maxes.get(0) - String.valueOf(i + 1).length(), ' '));

      str.append(separator)
          .append(person.getName())
          .append(Helper.charRepeat(headerLn.get(1) - person.getName().length(), ' '));

      str.append(separator)
          .append(person.getPassword())
          .append(Helper.charRepeat(headerLn.get(2) - person.getPassword().length(), ' '));

      str.append(separator)
          .append(person.getRole())
          .append(Helper.charRepeat(headerLn.get(3) - person.getRole().length(), ' '));

      str.append(separator)
          .append(person.getTickets().size())
          .append(Helper.charRepeat(headerLn.get(4) - String.valueOf(person.getTickets().size()).length(), ' '));

      str.append(separator)
          .append(person.getAccount())
          .append(Helper.charRepeat(headerLn.get(5) - String.valueOf(person.getAccount()).length(), ' '));
      str.append(" |");

      System.out.println(str);

      System.out.println(Helper.charRepeat(headerStr.length(), '-'));
    });
  }
}
