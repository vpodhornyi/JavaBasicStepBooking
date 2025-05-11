package view;

import model.Flight;
import utils.Helper;
import model.Id;
import model.Person;
import model.Ticket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Table {

  public static void printFlights(List<Flight> flights) {

    if (flights.size() == 0) return;

    HeaderFlightTable[] header = HeaderFlightTable.values();

    List<Integer> maxes = new ArrayList<>();
    maxes.add(String.valueOf(flights.size()).length());
    maxes.add(Id.getLength());
    maxes.add(flights.stream()
        .max(Comparator.comparingInt(f -> f.getStringTime().length()))
        .get().getStringTime().length());
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
        .max(Comparator.comparingInt(f -> String.valueOf(f.getCountOfFreeBaseTickets()).length()))
        .get().getCountOfFreeBaseTickets()).length());
    maxes.add(String.valueOf(flights.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getFreeBaseTicketCost()).length()))
        .get().getFreeBaseTicketCost()).length());
    maxes.add(String.valueOf(flights.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getCountOfFreeBusinessTickets()).length()))
        .get().getCountOfFreeBusinessTickets()).length());
    maxes.add(String.valueOf(flights.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getFreeBusinessTicketCost()).length()))
        .get().getFreeBusinessTicketCost()).length());

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
          .append(flight.getStringTime())
          .append(Helper.charRepeat(headerLn.get(2) - flight.getStringTime().length(), ' '));

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
          .append(flight.getCountOfFreeBaseTickets())
          .append(Helper.charRepeat(headerLn.get(7) - String.valueOf(flight.getCountOfFreeBaseTickets()).length(), ' '));

      str.append(separator)
          .append(flight.getFreeBaseTicketCost())
          .append(Helper.charRepeat(headerLn.get(8) - String.valueOf(flight.getFreeBaseTicketCost()).length(), ' '));

      str.append(separator)
          .append(flight.getCountOfFreeBusinessTickets())
          .append(Helper.charRepeat(headerLn.get(9) - String.valueOf(flight.getCountOfFreeBusinessTickets()).length(), ' '));

      str.append(separator)
          .append(flight.getFreeBusinessTicketCost())
          .append(Helper.charRepeat(headerLn.get(10) - String.valueOf(flight.getFreeBusinessTicketCost()).length(), ' '));

      str.append(" |");

      System.out.println(str);

      System.out.println(Helper.charRepeat(headerStr.length(), '-'));
    });
  }

  public static void printPeople(List<Person> people) {

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

  public static void  printTickets(List<Ticket> tickets) {

    if (tickets.size() == 0) return;

    HeaderTicketsTable[] header = HeaderTicketsTable.values();

    List<Integer> maxes = new ArrayList<>();

    maxes.add(String.valueOf(tickets.size()).length());
    maxes.add(Id.getLength());
    maxes.add(tickets.stream()
        .max(Comparator.comparingInt(f -> f.getFlight().getFromCity().getName().length()))
        .get().getFlight().getFromCity().getName().length());
    maxes.add(tickets.stream()
        .max(Comparator.comparingInt(f -> f.getFlight().getToCity().getName().length()))
        .get().getFlight().getToCity().getName().length());
    maxes.add(tickets.stream()
        .max(Comparator.comparingInt(f -> f.getFlight().getStringTime().length()))
        .get().getFlight().getStringTime().length());
    maxes.add(tickets.stream()
        .max(Comparator.comparingInt(f -> f.getFlight().getAirline().getName().length()))
        .get().getFlight().getAirline().getName().length());
    maxes.add(tickets.stream()
        .max(Comparator.comparingInt(f -> f.getFlight().getAirplane().getName().length()))
        .get().getFlight().getAirplane().getName().length());
    maxes.add(Id.getLength());
    maxes.add(tickets.stream()
        .max(Comparator.comparingInt(f -> f.getType().length()))
        .get().getType().length());
    maxes.add(String.valueOf(tickets.stream()
        .max(Comparator.comparingInt(f -> String.valueOf(f.getCost()).length()))
        .get().getCost()).length());


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

    IntStream.range(0, tickets.size()).forEach(i -> {
      Ticket ticket = tickets.get(i);
      StringBuilder str = new StringBuilder();
      String separator = " | ";

      str.append("| ")
          .append(i + 1)
          .append(Helper.charRepeat(maxes.get(0) - String.valueOf(i + 1).length(), ' '));

      str.append(separator)
          .append(ticket.getId())
          .append(Helper.charRepeat(headerLn.get(1) - ticket.getId().length(), ' '));

      str.append(separator)
          .append(ticket.getFlight().getFromCity().getName())
          .append(Helper.charRepeat(headerLn.get(2) - ticket.getFlight().getFromCity().getName().length(), ' '));

      str.append(separator)
          .append(ticket.getFlight().getToCity().getName())
          .append(Helper.charRepeat(headerLn.get(3) - ticket.getFlight().getToCity().getName().length(), ' '));

      str.append(separator)
          .append(ticket.getFlight().getStringTime())
          .append(Helper.charRepeat(headerLn.get(4) - ticket.getFlight().getStringTime().length(), ' '));

      str.append(separator)
          .append(ticket.getFlight().getAirline().getName())
          .append(Helper.charRepeat(headerLn.get(5) - ticket.getFlight().getAirline().getName().length(), ' '));

      str.append(separator)
          .append(ticket.getFlight().getAirplane().getName())
          .append(Helper.charRepeat(headerLn.get(6) - ticket.getFlight().getAirplane().getName().length(), ' '));

      str.append(separator)
          .append(ticket.getFlight().getId())
          .append(Helper.charRepeat(headerLn.get(7) - ticket.getFlight().getId().length(), ' '));

      str.append(separator)
          .append(ticket.getType())
          .append(Helper.charRepeat(headerLn.get(8) - ticket.getType().length(), ' '));

      str.append(separator)
          .append(ticket.getCost())
          .append(Helper.charRepeat(headerLn.get(9) - String.valueOf(ticket.getCost()).length(), ' '));

      str.append(" |");

      System.out.println(str);

      System.out.println(Helper.charRepeat(headerStr.length(), '-'));
    });
  }
}
