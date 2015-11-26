package adt;

public interface StationInterface<T> {
    
  public void addAtStart(T newEntry);
  
  public void addAtEnd(T entry);
  
  public void addAtPosition(T entry, int position);

  public T getPosition(int position);

  public void removePosition(int position);

  //public void clear();

  public int getLength();

  public boolean isEmpty();

  public void showResult();
}
