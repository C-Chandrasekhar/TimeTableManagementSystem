/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author chandrasekhar ch
 */
public class Room {
    private String id;
    private int capacity;
    
    public Room(String id, int capacity){
        this.id=id;
        this.capacity=capacity;
    }
    
    public String getId(){
        return id;
    }
    
    public int getCapacity(){
        return capacity;
    }
}
