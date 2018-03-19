
package implementation;

import domain.Course;
import domain.Department;
import domain.Class;
import domain.InstructorFix;
import java.util.ArrayList;


public class Schedule {
    private ArrayList<Class> classes;
    private ArrayList<InstructorFix> instructorsFix;
    private Data data;
    private int classNumber=0;
    
    private int numberOfConflicts=0;
    private boolean isFitnessChanged= true;
    private double fitness=-1;
    
    
    public Schedule(Data data){
        this.data=data;
        classes= new ArrayList<Class>(data.getNumberOfClasses());
    } 
    public Data getData(){
        return data;
    }
    
    public Schedule initialise(){
        ArrayList<Department> dept=new ArrayList<Department> (data.getDepartments());
        for (int i=0;i<dept.size();i++){
            ArrayList<Course> course= new ArrayList<Course> (dept.get(i).getCourses());
           
            for (int j=0;j<course.size();j++){
                //<h1>a loop for number of classes for each course</h1>
               Class newClass = new Class(classNumber++ , dept.get(i), course.get(j));
               
               newClass.setMeetingTime(data.getMeetingTimes().get((int)(data.getMeetingTimes().size() * Math.random())));
               newClass.setInstructor(data.getInstructors().get((int)(data.getInstructors().size()* Math.random())));
               
               
              instructorsFix=data.getInstructorsFix();
              for (int ite=0;ite<instructorsFix.size();ite++){
                  if(instructorsFix.get(ite).getDepartmentFix()== dept.get(i) 
                          && instructorsFix.get(ite).getCourseFix()== course.get(j) )
                       newClass.setInstructor(instructorsFix.get(ite).getInstructorFix());
              }
              

//               newClass.setInstructor(data.getInstructorsFix(course.get(j), dept.get(i)).get((int)
//                       (data.getInstructorsFix(course.get(j), dept.get(i)).size()* Math.random())));
//               
               
               newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
               classes.add(newClass);
               
            }
            
        }
        return this;
    }
    
    public ArrayList<Class> getClasses(){
        isFitnessChanged= true;
        return classes;
    }
    
    public int getNumberOfConflicts(){
        return numberOfConflicts;
    }
    
    public double getFitness(){
        if( isFitnessChanged == true){
            fitness= calculateFitness();
            isFitnessChanged= false;
        }
        return fitness;
    }
    
    public double calculateFitness(){
        numberOfConflicts=0;
        for (int i=0;i<classes.size(); i++){
            Class x= classes.get(i);
            if(x.getRoom().getCapacity() < x.getDepartment().getCapacity())
                numberOfConflicts++;
            
            for (int j=0;j<classes.size();j++){
                Class y = classes.get(j);
                if(y.getMeetingTime() == x.getMeetingTime() && y.getId()!= x.getId()){
                    if(x.getRoom()== y.getRoom())
                        numberOfConflicts++;
                    if(x.getInstructor()== y.getInstructor())
                        numberOfConflicts++;
                }
            }
        }
        return 1/(double)(numberOfConflicts+1) ;
    }
    
    public String toString(){
        String s=new String();
        for (int i=0;i<classes.size()-1 ; i++)
            s=s+classes.get(i).toString()+",";
        s=s+classes.get(classes.size() -1).toString();
        
        return s;
    } 
}
