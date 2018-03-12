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
public class Population {
    private ArrayList<Schedule> schedules;
    
    public Population(int size , Data data){
        schedules = new ArrayList<Schedule> (size);
        for (int i=0;i<size;i++){
            schedules.add(new Schedule(data).initialise());
        }
    }
    
    public Population sortByFitness(){
        schedules.sort( (schedule1 , schedule2) -> {
                     int returnValue = 0;
                    if(schedule1.getFitness() > schedule2.getFitness())
                    returnValue=-1;
                    else if (schedule1.getFitness() < schedule2.getFitness())
                     returnValue=1;
                return returnValue;
        });
        return this;
    }
    public ArrayList<Schedule> getSchedules(){
        return this.schedules;
    }
}
