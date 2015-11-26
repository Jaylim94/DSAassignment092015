package adt;

public class LinkedList<T> implements StationInterface<T> {

  private Node<T> start = null;
  private Node<T> end = null;
  private int numberOfEntries = 0;

      public LinkedList() {
        start = null;
        numberOfEntries= 0;
        clear();
      }
      
      public final void clear() { //not in interface
        start = null;
        numberOfEntries = 0;
      }

      @Override
      public void addAtStart(T newEntry) {
        Node<T> newNode = new Node<T>();

        if (isEmpty()) {
          start = newNode;
        } else {
          Node<T> lastNode = getNodeAt(numberOfEntries);
          lastNode.setNext(newNode);
        }

        numberOfEntries++;
      }

      public void addAtEnd(T entry) {
          Node<T> eNode = new Node<T>();
          
          if(this.start == null){
              this.end = this.start = eNode;
          }else{
              eNode.setPrevious(this.end);
              this.end.setNext(eNode);
              this.end = eNode;
          }
          
          ++this.numberOfEntries;
       
      }

      public void removePosition(int position) {
        if (position == 1) {
            if (this.numberOfEntries == 1) {
                this.start = null;
                this.end = null;
                this.numberOfEntries = 0;
                return;
            }
            this.start = this.start.getNext();
            this.start.setPrevious(null);
            --this.numberOfEntries;
            return;
        }
        
        if (position == this.numberOfEntries) {
            this.end = this.end.getPrevious();
            this.end.setNext(null);
            --this.numberOfEntries;
        }
        
        Node cNode = this.start.getNext();
        
        for (int i = 2; i <= this.numberOfEntries; ++i) {
            if (i == position) {
                Node p = cNode.getPrevious();
                Node n = cNode.getNext();
                p.setNext(n);
                n.setPrevious(p);
                --this.numberOfEntries;
                return;
            }
            cNode = cNode.getNext();
        }
      }

      public void addAtPosition(T entry, int position) {
          Node<T> currentNode = new Node<T>();
          
          if(position == 1){
              this.addAtStart(entry);
          }
          
          Node nNode = this.start;
          
          for(int i = 2; i <=this.numberOfEntries; i++){
              if (i == position){
                  Node tempNode = nNode.getNext();
                  nNode.setNext(currentNode);
                  currentNode.setPrevious(tempNode);
                  currentNode.setNext(tempNode);
                  tempNode.setPrevious(currentNode);
              }
              nNode = nNode.getNext();
          }
          ++this.numberOfEntries;
      }

//  public T getEntry(int givenPosition) {
//    T result = null;
//
//    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
//      result = getNodeAt(givenPosition).getData();
//    }
//
//    return result;
//  }

//  public boolean contains(T anEntry) {
//    boolean found = false;
//    Node<T> currentNode = firstNode;
//
//    while (!found && (currentNode != null)) {
//      if (anEntry.equals(currentNode.getData())) {
//        found = true;
//      } else {
//        currentNode = currentNode.getNext();
//      }
//    }
//
//    return found;
//  }

//  public int getNumberOfEntries() {
//    return numberOfEntries;
//  }

  public boolean isEmpty() {
    boolean result;

    if (numberOfEntries == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
  }
//
//  public boolean isFull() {
//    return false;
//  }

  private Node<T> getNodeAt(int givenPosition) { //not inside interface
    Node<T> currentNode = start;

    // traverse the list to locate the desired node
    for (int counter = 1; counter < givenPosition; counter++) {
      currentNode = currentNode.getNext();
    }

    return currentNode;
  }
  
  
    public void showResult(){
        if (this.numberOfEntries == 0) {
            System.out.println("It is Empty");
            return;
        }
        
        if (this.start.getNext() == null) {
            System.out.print(((Station)this.start.getData()).display() + "\n");
            return;
        }
        
        System.out.print(((Station)this.start.getData()).display() + "\n");
        Node node = this.start.getNext();
        
        while (node.getNext() != null) {
            System.out.print(((Station)node.getData()).display() + "\n");
            node = node.getNext();
        }
        
        System.out.print(((Station)node.getData()).display() + "\n");
    }

    @Override
    public T getPosition(int position) {
        if(position < 0 ){
            return null;
        }else if(position == 0){
            return (T)this.start.getNext();
        }
        
        Node point = this.start.getNext();
        
        for(int i = 1; i < position; i++){
            if(point.getNext() == null){
                return null;
            }
            point = point.getNext();
        }
        
        return (T)point.getData();
    }

    @Override
    public int getLength() {
        return this.numberOfEntries;
    }

}
