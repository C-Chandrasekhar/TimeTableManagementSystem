
package domain;

import java.util.ArrayList;
import java.util.Arrays;


public class MeetingTime {
    private String id;
    private String time;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    
    public MeetingTime(String id){
        this.id=id;
        list1= new ArrayList<String>(Arrays.asList("mon","tue","wed","thur","fri"));
        list2= new ArrayList<String>(Arrays.asList("8-9","9-10","10-11","11-12","12-13",
                "13-14","14-15","15-16","16-17","17-18"));
    }
    
    public String getId(){
        return id;
    }
    public String getTime(){
         String str1=list1.get((int)id.charAt(0)-(int)'1');
         String str2=list2.get((int)id.charAt(1)-(int)'a');
         
         return str1+" "+str2;
    }
}
