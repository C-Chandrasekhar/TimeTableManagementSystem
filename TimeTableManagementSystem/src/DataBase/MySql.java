/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.*;
import javax.swing.*;


public class MySql {
    Connection con=null;
    
    public static Connection ConnectDB(){
        try{
            
            String str="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/timetablemanagementsystem";
            
            Class.forName(str);
            Connection conn = DriverManager.getConnection(url,"root" , "");
            JOptionPane.showMessageDialog(null, "connected to database");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "inside catch ");
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
   
}
