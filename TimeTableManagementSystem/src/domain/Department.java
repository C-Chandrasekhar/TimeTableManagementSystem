/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author chandrasekhar ch
 */
public class Department {
    private String name;
    private int capacity;
    private ArrayList <Course> courses;
    
    public Department (String name ,int capacity ,ArrayList<Course> courses){
        this.name =name;
        this.courses=courses;
        this.capacity=capacity;
    }
    
    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
    public ArrayList <Course> getCourses(){
        return courses;
    }
    
}
