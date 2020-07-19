/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author aswin
 */
public class WindowClose extends WindowAdapter {
   public static DashBoard db;
    public void windowClosed(WindowEvent e){
        db.setVisible(true);
    }
    
}
