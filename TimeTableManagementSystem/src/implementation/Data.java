
package implementation;

import domain.Course;
import domain.Department;
import domain.Instructor;
import domain.MeetingTime;
import domain.Room;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private ArrayList<Room> rooms;
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<Department> departments;
    private ArrayList<MeetingTime> meetingTimes;
    private int numberOfClasses=0;
    
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    public ArrayList<Instructor> getInstructors(){
        return instructors;
    }
    public ArrayList<Department> getDepartments(){
        return departments;
    }
    public ArrayList <Course> getCourses(){
        return courses;
    }
    public ArrayList<MeetingTime> getMeetinTimes(){
        return meetingTimes;
    }
    public int getNumberOfClasses(){
        return numberOfClasses;
    }
    
    public Data (){
        initialise();
    }
    
    private Data initialise(){
        //initialising all data or taking input of all data
        Room room1 = new Room("gs1", 50);
        Room room2 = new Room("gs2", 60);
        Room room3 = new Room("gs3", 70);
        
        rooms= new ArrayList<Room>(Arrays.asList(room1 , room2 , room3));
        
        MeetingTime time1 = new MeetingTime("mon1" , "mon 8-9");
        MeetingTime time2 = new MeetingTime("mon2" , "mon 9-10");
        MeetingTime time3 = new MeetingTime("tue3" , "mon 9-10");
     
    }
}
