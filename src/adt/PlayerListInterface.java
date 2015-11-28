/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Jaylim
 */
public interface PlayerListInterface<T> {
    public void add(T data);
    
    public void addAtPos(T data, int index);
    
    public T get(int index);
    
    public boolean remove(int index);
    
    public int size();
    
    public int toCompare(T data);
    
    public void display();
}
