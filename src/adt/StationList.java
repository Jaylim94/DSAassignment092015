package adt;

import entity.Station;

public class StationList<T> implements StationListInterface<T>{
    private Node start;
    private Node end ;
    private int size;
    private int playerPosition;
    /* Constructor */
    public StationList()
    {
        start = null;
        end = null;
        size = 0;
        playerPosition = 0;
    }
    public void resetRacePath() {
        ((Station)getAtPosition(playerPosition)).updatePlayerPosition(false);
        playerPosition = 0;
    }
    public int getPlayerPosition() {
        return playerPosition;
    }
    public boolean isPlayerAtStarting() {
        return playerPosition == 0;
    }
    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }
    /* Function to get size of list */
    public int getSize()
    {
        return size;
    }
    /* Function to insert element at begining */
    public void insertAtStart(T val)
    {
        Node nptr = new Node(val, null, null);        
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            start.setLinkPrevious(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }
        size++;
    }
    /* Function to insert element at end */
    public void insertAtEnd(T val)
    {
        Node nptr = new Node(val, null, null);        
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            nptr.setLinkPrevious(end);
            end.setLinkNext(nptr);
            end = nptr;
        }
        size++;
    }
    /* Function to insert element at position */
    public void insertAtPosition(T val , int pos)
    {
        Node nptr = new Node(val, null, null);    
        if (pos == 1)
        {
            insertAtStart(val);
            return;
        }            
        Node ptr = start;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrevious(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrevious(nptr);
            }
            ptr = ptr.getLinkNext();            
        }
        size++ ;
    }
    public T getAtPosition(int pos){
        if(pos < 0){
            return null;
        }
        if(pos == 0){
            return (T)start.getData();
            
        }else{
            Node pointer = start.getLinkNext();
            for(int i = 1; i < pos; i ++){
                if(pointer.getLinkNext()== null)
                    return null;
                
                pointer = pointer.getLinkNext();
            }
            return (T) pointer.getData();
        }
    }
    /* Function to delete node at position */
    public void deleteAtPosition(int pos)
    {        
        if (pos == 1) 
        {
            if (size == 1)
            {
                start = null;
                end = null;
                size = 0;
                return; 
            }
            start = start.getLinkNext();
            start.setLinkPrevious(null);
            size--; 
            return ;
        }
        if (pos == size)
        {
            end = end.getLinkPrevious();
            end.setLinkNext(null);
            size-- ;
        }
        Node ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node p = ptr.getLinkPrevious();
                Node n = ptr.getLinkNext();
 
                p.setLinkNext(n);
                n.setLinkPrevious(p);
                size-- ;
                return;
            }
            ptr = ptr.getLinkNext();
        }        
    }    
    /* Function to display status of list */
    public void display()
    {
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null) 
        {
            System.out.print(((Station)start.getData()).display()+ "\n");
            return;
        }
        Node ptr;
        System.out.print(((Station)start.getData()).display()+ "\n");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null)
        {
            System.out.print(((Station)ptr.getData()).display()+ "\n");
            ptr = ptr.getLinkNext();
        }
        System.out.print(((Station)ptr.getData()).display()+ "\n");
    }
    public void updatePath(int rollDice) {
        T currStation = getAtPosition(playerPosition);
        T nextStation = getAtPosition(playerPosition + rollDice);
        
        ((Station)currStation).updatePlayerPosition(false);
        ((Station)nextStation).updatePlayerPosition(true);
        playerPosition+=rollDice;
    }
    
    class Node
{
    protected T data;
    protected Node next, prev;
 
    /* Constructor */
    public Node()
    {
        next = null;
        prev = null;
        data = null;
    }
    /* Constructor */
    public Node(T d, Node n, Node p)
    {
        data = d;
        next = n;
        prev = p;
    }
    /* Function to set link to next node */
    public void setLinkNext(Node n)
    {
        next = n;
    }
    /* Function to set link to previous node */
    public void setLinkPrevious(Node p)
    {
        prev = p;
    }    
    /* Funtion to get link to next node */
    public Node getLinkNext()
    {
        return next;
    }
    /* Function to get link to previous node */
    public Node getLinkPrevious()
    {
        return prev;
    }
    /* Function to set data to node */
    public void setData(T d)
    {
        data = d;
    }
    /* Function to get data from node */
    public T getData()
    {
        return data;
    }
    }
}
