
package domain;

import java.util.ArrayList;

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
    public String toString(){
        return name;
    }
}
