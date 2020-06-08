/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement2;
import java.sql.*;
/**
 *
 * @author aswin
 */
public class DocConnect {
    Connection conn = null;

     static Connection connect() throws SQLException
    {
     String url       = "jdbc:mysql://localhost:3307/Doc";
     String user      = "root";
     String password  = "";
     Connection a= DriverManager.getConnection(url, user, password);
     return a;
    }

}
