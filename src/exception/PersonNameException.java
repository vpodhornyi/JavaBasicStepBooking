package exception;

public class PersonNameException extends RuntimeException{
  public PersonNameException() {
    super("Entered name is exist (name must be uniq)");
  }
}
