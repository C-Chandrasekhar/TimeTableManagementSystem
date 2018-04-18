
package domain;



public class Class {
    private int id;
    private Course course;
    private Department department;
    private Instructor instructor;
    private MeetingTime meetingTime;
    private Room room;
    
    public Class (int id , Department dpt , Course course){
        this.id=id;
        this.course=course;
        this.department=dpt;
    }
    
    public void setMeetingTime(MeetingTime meetingTime){
        this.meetingTime=meetingTime;
    }
    
    public void setRoom(Room room){
        this.room=room;
    }
    
    public void setInstructor(Instructor instructor){
        
       // System.out.println("inside set Instructor in base class");
        this.instructor=instructor;
    }
    
    public int getId(){
        return id;
    }
    
    public Course getCourse(){
        return course;
    }
    
    public Instructor getInstructor (){
        return instructor;
    }
    
    public Room getRoom(){
        return room;
    }
    
    public MeetingTime getMeetingTime() {
        return meetingTime;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public String toString (){
        return "["+department.getName()+", " +
                course.getId()+", "+ room.getId()+"," + instructor.getId()+"," + meetingTime.getId() +"]";
    }
    
}
