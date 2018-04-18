
package implementation;

import DataBase.MySql;
import domain.*;
import java.sql.*;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Data {
    
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Room> labRooms = new ArrayList<Room>();
    private ArrayList<Instructor> instructors = new ArrayList<Instructor>();
    private ArrayList<Course> courses =  new ArrayList<Course>();
    private ArrayList<Department> departments = new ArrayList<Department>();
    private ArrayList<MeetingTime> meetingTimes = new ArrayList<MeetingTime>();
    private ArrayList<MeetingTime> labMeetingTimes = new ArrayList<MeetingTime>();
    private int numberOfClasses=0;
     ///implementing fix instructor
    private ArrayList<InstructorFix> instructorsFix = new ArrayList<InstructorFix>();
    
    
    public Data () {
        initialise();
    }
    
     private Data initialise() {
        //Taking input of all data from the database
       
        getRoomsData();
        getMeetingTimesData();
        setLabMeetingTimes();
        getInstructorsData();
        getCoursesData();
        getDepartmentsData();
        getInstructorFixData();
        
        for (int i=0;i<departments.size(); i++){
            numberOfClasses += departments.get(i).getCourses().size();
        }
        return this;
    }
     
    private void getRoomsData(){
        Connection conn= MySql.ConnectDB();
        Statement stat=null;
        ResultSet rs=null;
        
        String sql1="select * from classroom";
        try{
            stat=conn.createStatement();
            rs=stat.executeQuery(sql1);
             while(rs.next()){
                String isLab = rs.getString("islab");
                
                    String classId=rs.getString("classroom_id");
                    int capacity = Integer.parseInt(rs.getString("capacity"));
                    Room temp= new Room(classId , capacity);
                if(isLab.equals("no"))
                    rooms.add(temp);
                else 
                    labRooms.add(temp);
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error in getRooms in data class");
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void getMeetingTimesData(){
        Connection conn= MySql.ConnectDB();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select * from meetingtime";
        try{
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
             while(rs.next()){
                String meetingTimeName = rs.getString("meetingTimeName");
                String meetinTimeId=rs.getString("meetingTimeId");
                
                MeetingTime temp= new MeetingTime (meetinTimeId);
                meetingTimes.add(temp);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error in getMeetingtimes in data class");
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void getInstructorsData(){
        Connection conn= MySql.ConnectDB();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select * from instructor";
        try{
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
             while(rs.next()){
                String instructorName = rs.getString("instructorName");
                String instructorId=rs.getString("instructorId");
                
                Instructor temp= new Instructor(instructorName , instructorId);
               instructors.add(temp);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error in getInstructor in data class");
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void getCoursesData(){
        
        Connection conn= MySql.ConnectDB();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select * from course";
        try{
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            
             while(rs.next()){
                String courseName = rs.getString("courseName");
                String courseId=rs.getString("courseId");
                int number =Integer.parseInt(rs.getString("numberOfClassesPerWeek")); 
                String isLab = rs.getString("isLab");
                //System.out.println("course is "+courseName);
               Course temp= new Course(courseName , courseId ,number , isLab);
               courses.add(temp);
                 //System.out.println(courses.size());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error in getCoursesData in data class");
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void getInstructorFixData(){
        Connection conn= MySql.ConnectDB();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select * from dep_cour_ins";
        try{
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
             while(rs.next()){
                String departmentId = rs.getString("departmentId");
                Statement stat1 = conn.createStatement();
                String str="select * from department where departmentId='"+departmentId+"'";
                ResultSet res =stat1.executeQuery(str);
                
                Department depart=null;
                while(res.next()){
                    String departmentId1 = res.getString("departmentId");
                    int strength = Integer.parseInt(res.getString("strength"));
                    Statement stat2 = conn.createStatement();
                    String str2="select courseId from dep_cour_ins where departmentId='"+departmentId1+"'";
                    ResultSet res2=stat2.executeQuery(str2);
                    
                    ArrayList<Course> coursesData= new ArrayList<Course>();
                    while(res2.next()){
                        String courseId =res2.getString("courseId");
                        Statement stat3= conn.createStatement();
                        String str3="select * from course where courseId ='"+courseId+"'";
                        ResultSet res3=stat3.executeQuery(str3);
                        while(res3.next()){
                             String courseName = res3.getString("courseName");
                             String courseId1=res3.getString("courseId");
                             int number =Integer.parseInt(res3.getString("numberOfClassesPerWeek")); 
                             String isLab = res3.getString("isLab");
                             Course temp= new Course(courseName , courseId1 ,number , isLab);
                             coursesData.add(temp);
                        }
                    }
                    depart = new Department(departmentId, strength, coursesData);
                }
                
                
                String courseId=rs.getString("courseId");
                Statement stat4= conn.createStatement();
                String str4="select * from course where courseId ='"+courseId+"'";
                ResultSet res4=stat4.executeQuery(str4);
                
                Course cour=null;
                while(res4.next()){
                    String courseName = res4.getString("courseName");
                    String courseId1=res4.getString("courseId");
                    int number =Integer.parseInt(res4.getString("numberOfClassesPerWeek")); 
                    String isLab = res4.getString("isLab");
                    Course temp= new Course(courseName , courseId1 ,number , isLab);
                    cour=new Course(courseName, courseId1, number, isLab);
                }
                
                
                String instructorId = rs.getString("instructorId");
                Statement stat5=conn.createStatement();
                String str5="select * from instructor where instructorId='"+instructorId+"'";
                ResultSet res5=stat5.executeQuery(str5);
                
                Instructor ins=null;
                while(res5.next()){
                    String instructorName1 = res5.getString("instructorName");
                    String instructorId1 = res5.getString("instructorId");
                
                    ins= new Instructor(instructorId1, instructorName1);
                }
                
                InstructorFix inst=new InstructorFix(depart, cour, ins);
                 System.out.println(inst.getInstructorFix().getName());
                instructorsFix.add(inst);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error in instructorFixData in data class");
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void getDepartmentsData(){
        
        System.out.println("inside getDepartmentsData 1");
        Connection conn=MySql.ConnectDB();
        String str="select * from department";
        System.out.println("inside getDepartmentsData 2");
        
        try {
        Statement stat1 = conn.createStatement();
        ResultSet res =stat1.executeQuery(str);
        Department depart=null;
        System.out.println("inside getDepartmentsData 3");
        while(res.next()){
            String departmentId1 = res.getString("departmentId");
            int strength = Integer.parseInt(res.getString("strength"));
            
            System.out.println("inside getDepartmentsData 4");
            
            Statement stat2 = conn.createStatement();
            String str2="select courseId from dep_cour_ins where departmentId='"+departmentId1+"'";
            ResultSet res2=stat2.executeQuery(str2);
                    
            System.out.println("inside getDepartmentsData 5");
            
            ArrayList<Course> coursesData= new ArrayList<Course>();
            while(res2.next()){
                System.out.println("inside getDepartmentsData 6");
                
                String courseId =res2.getString("courseId");
                Statement stat3= conn.createStatement();
                String str3="select * from course where courseId ='"+courseId+"'";
                ResultSet res3=stat3.executeQuery(str3);
                
                System.out.println("inside getDepartmentsData 7");
                
                while(res3.next()){
                    System.out.println("inside getDepartmentsData 8");
                    String courseName = res3.getString("courseName");
                    String courseId1=res3.getString("courseId");
                    int number =Integer.parseInt(res3.getString("numberOfClassesPerWeek")); 
                    String isLab = res3.getString("isLab");
                    Course temp= new Course(courseName , courseId1 ,number , isLab);
                    
                    System.out.println("inside getDepartmentsData 9 " +courseName);
                    
                    coursesData.add(temp);
                }
            }
           depart = new Department(departmentId1 , strength, coursesData);
           departments.add(depart);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error in departmentData inside data class");
            JOptionPane.showMessageDialog(null, e);
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


// in the data class we will take all the input from the database to variables which are private
// and we write all the public functions to get access to data 