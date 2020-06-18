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
    static Connection conn = null;
    private static String url = "jdbc:mysql://localhost:";
    private static String user,password;
    public DocConnect(String url,String portNum,String user,String password){
        this.url=this.url+portNum+"/"+url;
        this.user=user;
        this.password=password;
    }
   static void connect() throws SQLException
    {
     conn= DriverManager.getConnection(url, user, password);
    }

}
