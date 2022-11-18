/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamysqlproject;

import java.sql.*;
/**
 *
 * @author C22001143
 */
public class JavaMySQLProject {

   /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws SQLException
    {
    Connection dbconn=null;
    Statement st= null;
    ResultSet rs = null;
    final  String username ="root";
    final String  password="root";
    String url="jdbc:mysql://127.0.0.1:3306/javaproject";
 
    try
    {
        //Step 1: Connection to a database
        dbconn = DriverManager.getConnection(url, username, password);
        System.out.println("Database connection was successful!");
        
        //Step 2: Create a statement
        st = dbconn.createStatement();

        //Step 3: Run a SQL query
        rs = st.executeQuery("select * from student");

        //Step 4: Output the retrieved data /result set
        while (rs.next()) {
              System.out.println(rs.getString("Student_ID") + " " + rs.getString("FirstName")+ 
                                  " " + rs.getString("LastName"));
        
            }
    }
    catch (Exception e)
            {
        e.printStackTrace();
            }
    }
    
}
