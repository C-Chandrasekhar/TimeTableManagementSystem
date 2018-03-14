/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

/**
 *
 * @author chandrasekhar ch
 */
public class Driver {
     public static final int POPULATION_SIZE=9;
     public static final double MUTATION_RATE= 0.1;
     public static final double CROSSOVER_RATE=0.9;
     public static final int SELECTION_SIZE=3;
     public static final int NUM_ELITE=1;
     
     private int scheduleNumb=0;
     private Data data;
    public static void main(String args []){
       
        Driver driver= new Driver();
        driver.data=new Data();
        driver.printAvailableData();
        
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
        Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitness();
        
        while(population.getSchedules().get(0).getFitness()!=1.0){
            population = geneticAlgorithm.evolve(population).sortByFitness();
        }
        /*for (int i=0;i<population.getSchedules().size();i++){
            Schedule schedule=population.getSchedules().get(i);
            System.out.println("       "+ schedule + "      " );
             System.out.println(schedule.getFitness());
             System.out.println(schedule.getNumberOfConflicts());
        }*/
        population.getSchedules().forEach(x ->
                System.out.println(x+ "  |  " +
                        String.format("%.5f", x.getFitness()) +"  |  " +x.getNumberOfConflicts())
        );
    }
    
    private void print(){
        
    }
    private void printAvailableData(){
        
        System.out.println("Available Departments=>");
        data.getDepartments().forEach(x-> 
                System.out.println("name :"+ x.getName() + " capacity :" + x.getCapacity() + " courses :"+ x.getCourses()));
        System.out.println("Available Courses=>");
        data.getCourses().forEach(x ->
                System.out.println("course :"+x.getName() + " id :"+ x.getId() + " faculty :"+x.getInstructors()));
        
        System.out.println("Available Rooms=>");
        data.getRooms().forEach(x ->
                System.out.println("Room :"+ x.getId() + " capacity :" + x.getCapacity()));
        System.out.println("Available Instructors=>");
        data.getInstructors().forEach(x ->
                System.out.println("name :"+ x.getName()+ " id :"+x.getId()));
        
        System.out.println("Available MeetingRooms=>");
        data.getMeetingTimes().forEach(x ->
                System.out.println("id :"+x.getId() + " time:" +x.getTime()));
        
        System.out.println("---------------------------------------------------------------------------------------------\n");
        
        
    }   
        
}
