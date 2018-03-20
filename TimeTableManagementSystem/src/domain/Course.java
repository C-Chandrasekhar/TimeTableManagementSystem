
package domain;

import java.util.ArrayList;


public class Course {
    private String name;
    private String id;
    private ArrayList<Instructor> instructors;
    private int numOfClassesPerWeek;
    private String isLab;
    
    public Course (String name , String id , ArrayList<Instructor> ins , int numOfClassesPerWeek, String isLab){
        this.name=name;
        this.id=id;
        this.instructors=ins;
        this.numOfClassesPerWeek=numOfClassesPerWeek;
        this.isLab=isLab;
    }
    
    public String getIsLab(){
        return isLab;
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
    
    public int getNumOfClassesPerWeek(){
        return numOfClassesPerWeek;
    }
    
    public String toString(){ 
        return name; 
    }
}
