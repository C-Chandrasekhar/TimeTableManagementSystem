
package implementation;

import domain.Course;
import domain.Department;
import domain.Instructor;
import domain.InstructorFix;
import domain.MeetingTime;
import domain.Room;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    
    private ArrayList<Room> rooms;
    private ArrayList<Room> labRooms;
    
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<Department> departments;
    private ArrayList<MeetingTime> meetingTimes;
    private ArrayList<MeetingTime> labMeetingTimes;
    private int numberOfClasses=0;
     ///implementing fix instructor
    private ArrayList<InstructorFix> instructorsFix;
    
    
    public Data () {
        initialise();
    }
    
    private Data initialise() {
        //initialising all data or taking input of all data
        //System.out.println("Inside Data initilization class");
       
        setRooms();
        setLabRooms();
        setMeetingTimes();
        setLabMeetingTimes();
        
        Instructor inst1 = new Instructor("inst_id1", "inst_name1");
        Instructor inst2 = new Instructor("inst_id2", "inst_name2");
        Instructor inst3 = new Instructor("inst_id3", "inst_name3");
        Instructor inst4 = new Instructor("inst_id4", "inst_name4");
        instructors = new ArrayList<Instructor> (Arrays.asList(inst1 , inst2, inst3, inst4));
        
        Course course1= new Course("c_name1" , "course_id1" , new ArrayList<Instructor> (Arrays.asList(inst1 , inst2)), 4,"no");
        Course course2= new Course("c_name2" , "course_id2" , new ArrayList<Instructor> (Arrays.asList(inst1 , inst3)), 3, "no");
        Course course3= new Course("c_name3" , "course_id3" , new ArrayList<Instructor> (Arrays.asList(inst2, inst4)), 3, "no");
        Course course4= new Course("c_name4" , "course_id4" , new ArrayList<Instructor> (Arrays.asList(inst1)), 3, "no");
        Course course5= new Course("c_name5" , "course_id5" , new ArrayList<Instructor> (Arrays.asList(inst3 , inst2)), 4, "no");
        Course course6= new Course("c_name6" , "course_id6" , new ArrayList<Instructor> (Arrays.asList(inst1 , inst4)), 3, "yes");
        Course course7= new Course("c_name7" , "course_id7" , new ArrayList<Instructor> (Arrays.asList(inst1 , inst2)),3 ,"no");
        
        courses = new ArrayList<Course>(Arrays.asList(course1 , course2, course3, course4, course5, course6, course7));
        
        Department dept1= new Department("CSE",55 , new ArrayList<Course> (Arrays.asList(course1 , course2 , course4, course7)));
        Department dept2= new Department("IT",65 , new ArrayList<Course> (Arrays.asList(course3 , course4, course5)));
        Department dept3= new Department("ECE",45 , new ArrayList<Course> (Arrays.asList(course1 ,course2,course6, course7)));
        departments = new ArrayList<Department> (Arrays.asList(dept1, dept2, dept3));
        
        InstructorFix instFix1 = new InstructorFix(dept1, course1,inst1);
        InstructorFix instFix2 = new InstructorFix(dept1, course2,inst3);
        InstructorFix instFix3 = new InstructorFix(dept1, course4,inst1);
        InstructorFix instFix4 = new InstructorFix(dept1, course7,inst2);
        
        InstructorFix instFix5 = new InstructorFix(dept2, course3,inst4);
        InstructorFix instFix6 = new InstructorFix(dept2, course4,inst1);
        InstructorFix instFix7 = new InstructorFix(dept2, course5,inst3);
       
        InstructorFix instFix9  = new InstructorFix(dept3, course7,inst2);
        InstructorFix instFix10 = new InstructorFix(dept3, course2,inst3);
        InstructorFix instFix11 = new InstructorFix(dept3, course6,inst1);
        InstructorFix instFix12 = new InstructorFix(dept3, course1,inst2);
        
        instructorsFix = new ArrayList<InstructorFix> (Arrays.asList(instFix1 , instFix2, instFix3, 
                instFix4,instFix5 , instFix6, instFix7, instFix9, instFix10 , instFix11, instFix12));
        
        for (int i=0;i<departments.size(); i++){
            numberOfClasses += departments.get(i).getCourses().size();
        }
        return this;
    }
    
    private void setMeetingTimes(){
        ArrayList<String> list1= new ArrayList<String>(Arrays.asList("1","2","3","4","5"));
        ArrayList<String> list2= new ArrayList<String>(Arrays.asList("a","b","c","d","e","f","g","h","i","j"));
        
        meetingTimes= new ArrayList<MeetingTime>();
        for (int i=0;i<5;i++){
            for (int j=0;j<10;j++){
                MeetingTime meetingTime= new MeetingTime(list1.get(i)+list2.get(j));
                meetingTimes.add(meetingTime);
            }
        }
    }
    
    private void setLabMeetingTimes(){
        ArrayList<String> list1= new ArrayList<String>(Arrays.asList("1","2","3","4","5"));
        ArrayList<String> list2= new ArrayList<String>(Arrays.asList("a","b","c","g","h"));
        
        labMeetingTimes= new ArrayList<MeetingTime>();
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                MeetingTime meetingTime= new MeetingTime(list1.get(i)+list2.get(j));
                labMeetingTimes.add(meetingTime);
            }
        }
    }
    
    private void setRooms(){
         Room room1 = new Room("gs1", 100);
        Room room2 = new Room("gs2", 100);
        Room room3 = new Room("gs3", 100);
        Room room4 = new Room("gs4", 100);
        Room room5 = new Room("gs5", 100);
        Room room6 = new Room("gs6", 100);
        Room room7 = new Room("gs7", 100);
        Room room8 = new Room("gs8", 100);
        rooms= new ArrayList<Room>(Arrays.asList(room1 , room2 , room3,room4 , room5 , room6,room7 , room8));
    }
    private void setLabRooms(){
        Room room1= new Room("UGlab", 110);
        Room room2= new Room("PGlab", 110);
        Room room3= new Room("networkslab", 110);
        labRooms= new ArrayList<Room>(Arrays.asList(room1, room2 , room3));
    }
    
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    public ArrayList<Room> getLabRooms(){
        return labRooms;
    }
    public ArrayList<Instructor> getInstructors(){
        return instructors;
    }
    public ArrayList<InstructorFix> getInstructorsFix(){
        return instructorsFix;
    }
    public ArrayList<Instructor> getInstructorsFix(Course course , Department department){
        
        return null;
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
    public ArrayList<MeetingTime> getLabMeetingTimes(){
        return labMeetingTimes;
    }
    public int getNumberOfClasses(){
        return numberOfClasses;
    }
}
