/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.util.ArrayList;

/**
 *
 * @author chandrasekhar ch
 */
public class GeneticAlgorithm {
    private Data data;
    
    public GeneticAlgorithm(Data data){
        this.data=data;
    }
    
    public Population evolve(Population population){
        return mutatePopulation(crossoverPopulation(population));
    }
    
    Population crossoverPopulation (Population population){
        Population crossoverPopulation = new Population(population.getSchedules().size(), data);
        for (int i=0;i<Driver.NUM_ELITE; i++)
            crossoverPopulation.getSchedules().set(i, population.getSchedules().get(i));
        for (int i=Driver.NUM_ELITE; i<population.getSchedules().size();i++){
            if(Driver.CROSSOVER_RATE > Math.random()){
                Schedule schedule1= selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                Schedule schedule2= selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                crossoverPopulation.getSchedules().set(i, crossoverSchedule(schedule1, schedule2));
            }
            else 
                crossoverPopulation.getSchedules().set(i, population.getSchedules().get(i));
        }
        return crossoverPopulation;
    }
    
    Schedule crossoverSchedule (Schedule schedule1 , Schedule schedule2){
        Schedule crossoverSchedule = new Schedule(data).initialise();
        for (int i=0;i<crossoverSchedule.getClasses().size();i++){
            if(Math.random() > 0.5)
                crossoverSchedule.getClasses().set(i, schedule1.getClasses().get(i));
            else
                crossoverSchedule.getClasses().set(i, schedule2.getClasses().get(i));
        }
        return crossoverSchedule;
    }
    
    Population mutatePopulation (Population population){
        Population mutatePopulation = new Population(population.getSchedules().size(), data);
        ArrayList<Schedule> schedules= mutatePopulation.getSchedules();
        for (int i=0;i<Driver.NUM_ELITE;i++)
            schedules.set(i, population.getSchedules().get(i));
        for (int i=Driver.NUM_ELITE; i< population.getSchedules().size();i++)
            schedules.set(i, mutateSchedule(population.getSchedules().get(i)));
        return mutatePopulation;
    }
    
    Schedule mutateSchedule (Schedule mutateSchedule){
        Schedule schedule=new Schedule(data).initialise();
        for (int i=0; i<mutateSchedule.getClasses().size(); i++){
            if(Driver.MUTATION_RATE > Math.random())
                mutateSchedule.getClasses().set(i, schedule.getClasses().get(i));
        }
        return mutateSchedule;
    }
    
    Population selectTournamentPopulation (Population population){
        Population tournamentPopulation = new Population(Driver.POPULATION_SIZE, data);
        for (int i=0;i<Driver.POPULATION_SIZE;i++){
            tournamentPopulation.getSchedules().set(i, population.getSchedules().get(
                                        (int)(Math.random()* population.getSchedules().size())));
        }
        return tournamentPopulation;
    }
}
