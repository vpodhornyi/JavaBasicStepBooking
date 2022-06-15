package view;

import helper.Helper;

public class SuccessView {
  public static void bookingSuccess(){
    Helper.printBorder("Ticket successful booking", '+');
  }
  public static void unbookingSuccess(){
    Helper.printBorder("Ticket successful unhooking", '+');
  }

  public static void personCreateSuccess(){
    Helper.printBorder("Person successful created", '+');
  }

  public static void personDeleteSuccess(){
    Helper.printBorder("Person successful created", '+');
  }

  public static void flightsDataGenerateSuccess(){
    Helper.printBorder("Flights successful generated", '+');
  }
}
