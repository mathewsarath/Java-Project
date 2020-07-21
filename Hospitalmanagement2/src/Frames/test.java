/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;
import hospitalmanagement2.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author aswin
 */
public class test {
    static private void currPatient(int i,Connection c) throws SQLException {
        i++;
        int id=1;
       String query = "SELECT * from Patient INNER JOIN current ON Patient.PatientID=current.pid WHERE doctor_id=1 ORDER BY currentid LIMIT 1";
        PreparedStatement st=c.prepareStatement(query);
       // st.setInt(0,id);
        //st.setInt(1,i);
         System.out.print(st);
       ResultSet res = st.executeQuery(query);
       
       System.out.print(res.next());
        //pres = res;
       // nextAvail();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Connection con;
        try{
        con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Demo","root",String.valueOf(""));
        currPatient(0,con);
    }
        catch(SQLException e)
        {
            System.out.print("hai");
        }
    }


    

}


