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
        
        for (int i=0;i<Driver.NUM_ELITE; i++){
            crossoverPopulation.getSchedules().set(i, population.getSchedules().get(i));
        }
        
        for (int i=Driver.NUM_ELITE; i<population.getSchedules().size();i++){
            if(Driver.CROSSOVER_RATE > Math.random()){
                Schedule schedule1= selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                Schedule schedule2= selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                
                crossoverPopulation.getSchedules().set(i, crossoverSchedule(schedule1, schedule2));
            }
            else {
                crossoverPopulation.getSchedules().set(i, population.getSchedules().get(i));
            }
        }
        return crossoverPopulation;
    }
    
    Schedule crossoverSchedule (Schedule schedule1 , Schedule schedule2){
        Schedule crossoverSchedule = new Schedule(data).initialise();
        
        for (int i=0;i<crossoverSchedule.getClasses().size();i++){
            
        }
        return crossoverSchedule;
    }
    
    Population mutatePopulation (Population population){
        return null;
    }
    
    Schedule mutateSchedule (Schedule schedule){
        return null;
    }
    
    Population selectTournamentPopulation (Population population){
        return null;
    }
}
