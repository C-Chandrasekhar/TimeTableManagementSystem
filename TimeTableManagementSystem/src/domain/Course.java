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
public class Course {
    private String name;
    private String id;
    private ArrayList<Instructor> instructors;
    
    public Course (String name , String id , ArrayList<Instructor> ins){
        this.name=name;
        this.id=id;
        this.instructors=ins;
    }
    
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    
    public ArrayList <Instructor> getInstructors(){
        return instructors;
    }
    
    public String toString(){ 
        return name; 
    }
}
