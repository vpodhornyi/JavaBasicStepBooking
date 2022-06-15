package exception;

public class PersonNotExistException extends RuntimeException{
  public PersonNotExistException() {
    super("Client with this name doesn't exist");
  }
}
