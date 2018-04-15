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
public class classString {
    
    private String departmentId=null;
    private String courseId=null;
    private String classId =null;
    private String instructorId = null;
    private String meetingTimeId = null;
    private String classroomId =null;
    //(classId , departmentId , courseId, instructorId , meetingTImeId, classroom_id)
    public classString(String classId , String departmentId , String courseId, String instructorId , String meetingTimeId , String classroomId){
        this.classId = classId;
        this.classroomId = classroomId;
        this.courseId = courseId;
        this.departmentId = departmentId;
        this.instructorId =instructorId;
        this.meetingTimeId =meetingTimeId;
    }
    
    public String getDepartmentId (){
        return departmentId;
    }
    
    public String getClassId(){
        return classId;
    }
    
    public String getClassroomId (){
        return classroomId;
    }
    public String getCourseId (){
        return courseId;
    }
    public String getInstructorId (){
        return instructorId;
    }
    public String getMeetingTimeId (){
        return meetingTimeId;
    }
    
}
