package adt;

public class Node<T> {

  private T data; // entry in list
  private Node next, previous; // link to next node

    public Node() {
        next = null;
        previous = null;
        data = null;
    }

    public Node(T data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }


    public void setData(T data) {
      this.data = data;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    

    public T getData() {
      return data;
    }

    public Node getNext() {
      return next;
    }

    public Node getPrevious() {
        return previous;
    }

}
