/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.util.ArrayList;

import domain.Class;
/**
 *
 * @author chandrasekhar ch
 */
public class Constraints {
    
    private int numberOfConflicts;
    private ArrayList<Class> classes;
    
    public Constraints(ArrayList<Class> classes){
         this.classes = classes;
    }
    public double calculateFitness(){
        numberOfConflicts=0;
        for (int i=0;i<classes.size(); i++){
            domain.Class x= classes.get(i);
            
            if(x.getMeetingTime().getId().charAt(1)=='f'){
                numberOfConflicts++;
            }
            if(x.getRoom().getCapacity() < x.getDepartment().getCapacity())
                numberOfConflicts++;
            
            for (int j=0;j<classes.size();j++){
                domain.Class y = classes.get(j);
                if(y.getMeetingTime() == x.getMeetingTime() && y.getId()!= x.getId()){
                    if(x.getRoom().getId().equals(y.getRoom().getId()))
                        numberOfConflicts++;
                    if(x.getInstructor().getId().equals(y.getInstructor().getId()))
                        numberOfConflicts++;
                }
            }
        }
        return 1/(double)(numberOfConflicts+1) ;
    }
}
