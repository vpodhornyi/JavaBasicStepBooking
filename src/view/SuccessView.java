package view;

import helper.Helper;

public class SuccessView {
  public static void bookingSuccess(){
    Helper.printBorder("Ticket successful booking", '+');
  }
  public static void unbookingSuccess(){
    Helper.printBorder("Ticket successful unhooking", '+');
  }
}
