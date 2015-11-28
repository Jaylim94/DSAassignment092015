/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import adt.PlayerListInterface;
import entity.Player;

/**
 *
 * @author Jaylim
 */
public class PlayerList<T> implements PlayerListInterface<T> {

    private int counter;
    private Node head;

    // Default constructor
    public PlayerList() {
        head = new Node(null);
        counter = 0;
    }

    // appends the specified element to the end of this list.
    public void add(T data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
        }

        Node temp = new Node(data);
        Node current = head;

        // Let's check for NPE before iterate over crunchifyCurrent
        if (current != null) {

            // starting at the head node, crawl to the end of the list and then add element after last node
            while (current.getNext() != null) {
                current = current.getNext();
            }

            // the last node's "next" reference set to our new node
            current.setNext(temp);
        }

        // increment the number of elements variable
        incrementCounter();
    }

    private int getCounter() {
        return counter;
    }

    private void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    // inserts the specified element at the specified position in this list
    @Override
    public void addAtPos(T data, int index) {
        Node temp = new Node(data);
        Node curr = head;

        // Let's check for NPE before iterate over crunchifyCurrent
        if (curr != null) {
            // crawl to the requested index or the last element in the list, whichever comes first
            for (int i = 1; i < index && curr.getNext() != null; i++) {
                curr = curr.getNext();
            }
        }

        // set the new node's next-node reference to this node's next-node reference
        temp.setNext(curr.getNext());

        // now set this node's next-node reference to the new node
        curr.setNext(temp);

        // increment the number of elements variable
        incrementCounter();
    }

    public T get(int index) // returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index <= 0) {
            return null;
        }
        
        Node currNode = head.getNext();
        for(int i = 1;i<index;i++) {
            if(currNode.getNext() == null)
                return null;
            
            currNode = currNode.getNext();
        }
        return (T)currNode.getData();
    }

    // removes the element at the specified position in this list.
    public boolean remove(int index) {

        // if the index is out of range, exit
        if (index < 1 || index > size()) {
            return false;
        }

        Node curr = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (curr.getNext() == null) {
                    return false;
                }

                curr = curr.getNext();
            }
            curr.setNext(curr.getNext().getNext());

            // decrement the number of elements variable
            decrementCounter();
            return true;

        }
        return false;
    }

    // returns the number of elements in this list.
    public int size() {
        return getCounter();
    }
    
    public int toCompare(T p) {
        int i;
        Player player = (Player)p;
        for(i = 1;i<=size();i++) {
            Player p2 = ((Player)get(i));
            if(player.getTimeUsed() < p2.getTimeUsed())
                return i;
        }
        return -1;
    }
    
    public void display() {
        Node currNode = head.getNext();
        int count = 1;
        while(currNode != null && count <= 10) {
            Player currPlayer = (Player)currNode.getData();
            System.out.println("    " + count + ".  " + currPlayer.getTimeUsed());
            currNode = currNode.getNext();
            count++;
        }
    }
    
    private class Node<T> {

        // reference to the next node in the chain, or null if there isn't one.
        Node next;

        // data carried by this node. could be of any type you need.
        Object data;

        // Node constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        // another Node constructor if we want to specify the node to point to.
        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        // these methods should be self-explanatory
        public Object getData() {
            return data;
        }

        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }

    }
}
