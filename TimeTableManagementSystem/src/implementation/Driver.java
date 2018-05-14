/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;
import DataBase.MySql;
import domain.Instructor;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author chandrasekhar ch
 */
public class Driver {
     public static final int POPULATION_SIZE=9;
     public static final double MUTATION_RATE= 0.1;
     public static final double CROSSOVER_RATE=0.9;
     public static final int SELECTION_SIZE=3;
     public static final int NUM=1;
     
     private int scheduleNumb=0;
     private Data data;
     
    public static void main(String args []){
        
//        Driver driver= new Driver();
//        driver.data=new Data();
//        driver.printAvailableData();
//        
//        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
//        Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitness();
//        
//        int t=0;
//        while(population.getSchedules().get(0).getFitness()!=1.0){
//            population = geneticAlgorithm.evolve(population).sortByFitness();
//            t++;
//        }
//        System.out.println("while loop runned for " + t);
//        
//         driver.printTimeTable(population.getSchedules().get(0));
//         driver.printTimeTable(population.getSchedules().get(1));
//    
    }
    
    public static void generateTimeTable(){
        Driver driver= new Driver();
        driver.data=new Data();
        driver.printAvailableData();
        
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
        Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitness();
        
        int t=0;
        while(population.getSchedules().get(0).getFitness()!=1.0){
            population = geneticAlgorithm.evolve(population).sortByFitness();
            t++;
            System.out.println("inside while "+t);
        }
        
        System.out.println("while loop runned for "+t);
        System.out.println(population.getSchedules().get(0).getClasses().get(20).getInstructor().getId());
        driver.printTimeTable(population.getSchedules().get(0));
        //driver.printTimeTable(population.getSchedules().get(1));
    
    }
    private void printTimeTable(Schedule schedule){
        
        Connection conn= MySql.ConnectDB();
        Statement stmt=null;
        String str=null;
        
        str="truncate table class";
         try {
            stmt=conn.createStatement();
            stmt.executeUpdate(str);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error in truncating");
                JOptionPane.showMessageDialog(null, e);
            }
        
         System.out.println("before forloop");
        for (int i=0;i<schedule.getClasses().size();i++){
            str="insert into class (classId , departmentId , courseId, instructorId , meetingTImeId, classroom_id)"
                 + " VALUES ("+(i+1)+
                            ",'"+schedule.getClasses().get(i).getDepartment().getName()+ 
                            "','"+schedule.getClasses().get(i).getCourse().getId()+
                            "','"+schedule.getClasses().get(i).getInstructor().getId()+
                            "','"+schedule.getClasses().get(i).getMeetingTime().getId()+
                            "','"+schedule.getClasses().get(i).getRoom().getId()+"')";
            
            System.out.println(str);
            try {
            stmt=conn.createStatement();
            stmt.executeUpdate(str);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error in inserting where i="+(i+1));
                JOptionPane.showMessageDialog(null, e);
            }
        }
        for (int i=0;i<schedule.getClasses().size();i++){
            System.out.print(schedule.getClasses().get(i).getId() + "  |  ");
            System.out.print(schedule.getClasses().get(i).getDepartment().getName()+ "  |  ");
            System.out.print(schedule.getClasses().get(i).getCourse().getName()+"   |  ");
            // Instructor ins= schedule.getClasses().get(i).getInstructor();
            //System.out.print(ins+"  ");
            System.out.print(schedule.getClasses().get(i).getInstructor().getName()+"  |   ");
            System.out.print(schedule.getClasses().get(i).getRoom().getId()+ "   |  ");
            System.out.println(schedule.getClasses().get(i).getMeetingTime().getTime());
            //System.out.println("  collisions "+schedule.getNumberOfConflicts());
            
            
        }
        System.out.println("============================================================");
    }
    
    private void printAvailableData(){
        
        System.out.println("Available Departments=>");
        data.getDepartments().forEach(x-> 
                System.out.println("name :"+ x.getName() + " capacity :" + x.getCapacity() + " courses :"+ x.getCourses()));
        System.out.println("Available Courses=>");
        data.getCourses().forEach(x ->
                System.out.println("course :"+x.getName() + " id :"+ x.getId()));
        
        System.out.println("Available Rooms=>");
        data.getRooms().forEach(x ->
                System.out.println("Room :"+ x.getId() + " capacity :" + x.getCapacity()));
        System.out.println("Available Instructors=>");
        data.getInstructors().forEach(x ->
                System.out.println("name :"+ x.getName()+ " id :"+x.getId()));
        
        System.out.println("Available instructorFix=>");
        data.getInstructorsFix().forEach(x->
                System.out.println("instrcutor "+x.getInstructorFix().getId()+ " department " + x.getDepartmentFix() + " course "+
                        x.getCourseFix()));
        
        System.out.println("Available MeetingRooms=>");
        data.getMeetingTimes().forEach(x ->
                System.out.println("id :"+x.getId() + " time:" +x.getTime()));
        
        System.out.println("---------------------------------------------------------------------------------------------\n");
        
        
    }   
        
}
