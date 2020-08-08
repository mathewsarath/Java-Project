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
        String name="ram";
        int contact=123456789;
        String q2="INSERT INTO Token (Docid) SELECT Did FROM doctor WHERE name=? AND contact=?";
                PreparedStatement st2=c.prepareStatement(q2);
                st2.setString(1, name);
                st2.setInt(2, contact);
                System.out.print(st2);
                int rs2=st2.executeUpdate();
       //INSERT INTO doctor ('name','sex','specialized','incomeid','password','Type','house','place','district','state','pin','contact') 
       //VALUES ('Vijay','M','Ortho',1234,'1324','doctor','plakkav','Malappuram','Malappuram','Kerala','673117',1234234511);
        Statement st=c.createStatement();
         System.out.print(st);
       int res = st.executeUpdate(q2);
       
       System.out.print(res);
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
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root",String.valueOf(""));
        currPatient(0,con);
    }
        catch(SQLException e)
        {
            System.out.print(e);
        }
    }


    

}


