package adt;

public interface StationListInterface <T>{
    
    public void resetRacePath();
    
    public int getPlayerPosition();
    
    public boolean isPlayerAtStarting();
    
    public int getSize();
    
    public boolean isEmpty();
    
    public void insertAtStart(T val);
    
    public void insertAtEnd(T val);
    
    public void insertAtPosition(T val , int pos);
    
    public T getAtPosition(int pos);
    
    public void deleteAtPosition(int pos);
    
    public void display(); 
    
    public void updatePath(int rollDice);
}
