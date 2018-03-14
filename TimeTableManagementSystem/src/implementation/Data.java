
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
    
    
    public Data (){
        initialise();
    }
    
    private Data initialise(){
        //initialising all data or taking input of all data
        System.out.println("Inside Data initilization class");
        Room room1 = new Room("gs1", 50);
        Room room2 = new Room("gs2", 60);
        Room room3 = new Room("gs3", 70);
        rooms= new ArrayList<Room>(Arrays.asList(room1 , room2 , room3));
        
        MeetingTime time1 = new MeetingTime("mon1" , "mon 8-9");
        MeetingTime time2 = new MeetingTime("mon2" , "mon 9-10");
        MeetingTime time3 = new MeetingTime("tue2" , "mon 9-10");
        MeetingTime time4 = new MeetingTime("tue3" , "mon 10-11");
        meetingTimes = new ArrayList <MeetingTime> (Arrays.asList(time1 , time2 , time3 , time4));
        
        Instructor inst1 = new Instructor("id1", "name1");
        Instructor inst2 = new Instructor("id2", "name2");
        Instructor inst3 = new Instructor("id3", "name3");
        Instructor inst4 = new Instructor("id4", "name4");
        instructors = new ArrayList<Instructor> (Arrays.asList(inst1 , inst2, inst3, inst4));
        
        Course course1= new Course("cname1" , "cid1" , new ArrayList<Instructor> (Arrays.asList(inst1 , inst2)));
        Course course7= new Course("cname1" , "cid1" , new ArrayList<Instructor> (Arrays.asList(inst1 , inst2)));
        Course course2= new Course("cname2" , "cid2" , new ArrayList<Instructor> (Arrays.asList(inst1 , inst3)));
        Course course3= new Course("cname3" , "cid3" , new ArrayList<Instructor> (Arrays.asList(inst2, inst4)));
        Course course4= new Course("cname4" , "cid4" , new ArrayList<Instructor> (Arrays.asList(inst1)));
        Course course5= new Course("cname5" , "cid5" , new ArrayList<Instructor> (Arrays.asList(inst3 , inst2)));
        Course course6= new Course("cname6" , "cid6" , new ArrayList<Instructor> (Arrays.asList(inst1 , inst4)));
        courses = new ArrayList<Course>(Arrays.asList(course1 , course2, course3, course4, course5, course6, course7));
        
        Department dept1= new Department("CSE",55 , new ArrayList<Course> (Arrays.asList(course1 , course2 , course4, course7)));
        Department dept2= new Department("IT",65 , new ArrayList<Course> (Arrays.asList(course3 , course4, course5)));
        Department dept3= new Department("cse",45 , new ArrayList<Course> (Arrays.asList(course1 ,course2,course6, course7)));
        departments = new ArrayList<Department> (Arrays.asList(dept1, dept2, dept3));
        
        for (int i=0;i<departments.size(); i++){
            numberOfClasses += departments.get(i).getCourses().size();
        }
        return this;
    }
    
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
    public ArrayList<MeetingTime> getMeetingTimes(){
        return meetingTimes;
    }
    public int getNumberOfClasses(){
        return numberOfClasses;
    }
}
