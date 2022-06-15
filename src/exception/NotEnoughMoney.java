package exception;

public class NotEnoughMoney extends RuntimeException{
  public NotEnoughMoney() {
    super("Not enough money in the account");
  }
}
