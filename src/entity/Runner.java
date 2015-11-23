package entity;

public class Runner {
  private static int nextNumber = 1000;
  private String name;
  private int number;

  public Runner(String name) {
    this.name = name;
    this.number = nextNumber++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public static int getNextNumber() {
    return nextNumber;
  }

  public static void setNextNumber(int nextNumber) {
    Runner.nextNumber = nextNumber;
  }
    
  @Override
  public String toString() {
    return String.format("No. %-10d %-20s", number, name);
  }
  
  
}
