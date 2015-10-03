/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Danh Cooper
 */
public class DBConnection {
   Connection conn=null;
    public static Connection connect(){
      try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ass1","root", "");
          return conn;  
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          return null;
      }
    }
    
}
