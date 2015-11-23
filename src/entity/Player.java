package entity;

public class Player {
  private static int nextNumber = 1000;
  private String name;
  private int number;

  public Player(){
      
  }
  
  public Player(String name) {
    this.name = name;
    this.number = nextNumber++;
  }

    public Player(int number, String name ) {
        this.name = name;
        this.number = number;
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
    Player.nextNumber = nextNumber;
  }
    
  @Override
  public String toString() {
    return String.format("No. %-10d %-20s", number, name);
  }
  
  
}
