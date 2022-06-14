package view;

public enum HeaderPersonTable {
  NUMBER("№"),
  NAME("Name"),
  PASSWORD("Password"),
  ROLE("Role"),
  COUNT_TICKETS("Count tickets"),
  ACCOUNT_BALANCE("Account balance");

  private final String name;

  HeaderPersonTable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
