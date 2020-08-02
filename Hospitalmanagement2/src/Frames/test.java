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
       String query = "INSERT INTO doctor (name,sex,specialized,incomeid,password,Type,house,place,district,state,pin,contact) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
       //INSERT INTO doctor ('name','sex','specialized','incomeid','password','Type','house','place','district','state','pin','contact') 
       //VALUES ('Vijay','M','Ortho',1234,'1324','doctor','plakkav','Malappuram','Malappuram','Kerala','673117',1234234511);
        PreparedStatement st=c.prepareStatement(query);
        st.setString(1,"Vijay");
        st.setString(2,"M");
        st.setString(3,"Ortho");
        st.setInt(4,1234);
        st.setString(5,"1324");
        st.setString(6,"doctor");
        st.setString(7,"plakkav");
        st.setString(8,"Malappuram");
        st.setString(9,"Malappuram");
        st.setString(10,"Kerala");
        st.setString(11,"673117");
        st.setInt(12,1234234511);
        //st.setInt(1,i);
         System.out.print(st);
       int res = st.executeUpdate();
       
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
            System.out.print("hai");
        }
    }


    

}


