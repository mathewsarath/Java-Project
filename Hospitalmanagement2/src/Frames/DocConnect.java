/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;
import java.sql.*;
/**
 *
 * @author aswin
 */
public class DocConnect {
    Connection conn = null;
    private static String url = "jdbc:mysql://localhost:";
    private static String user,password;
    public DocConnect(String url,String portNum,String user,String password){
        this.url=this.url+portNum+"/"+url;
        this.user=user;
        this.password=password;
    }
   static Connection connect() throws SQLException
    {
     Connection a= DriverManager.getConnection(url, user, password);
     return a;
    }

}
