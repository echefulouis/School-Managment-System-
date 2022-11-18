/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamysqlproject;

import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author C22001143
 */
public class JavaMySQLProject {

   /**
     * @param args the command line arguments
     */
    
    public static Connection getDBConnection ()  throws SQLException
    {
    String connectionurl="jdbc:mysql://127.0.0.1:3306/javaproject";   
    String username ="root";
    String  password="root";
    
    Connection dbconn;
 
    try
    {
        //connection to a database
        dbconn = DriverManager.getConnection(connectionurl, username, password);

        System.out.println("Database connection was successful!");
        
        return dbconn;

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
        
    return null;
    }
    
    
    public static void main(String[] args)  throws SQLException
    {
    
    //Variables
    int choice1, choice2;
    String sid,fname,lname;
    
    
    Scanner in = new Scanner(System.in);
    Scanner str = new Scanner(System.in);
    
    //Loops for Modules
    while(true)
    {
        System.out.println("Welcome to School Database Management System");
        System.out.println("Enter 1. Student Module");
        System.out.println("Enter 2. Courses Module");
        System.out.println("Enter 3. Department Module");
        System.out.println("Enter 4. Exams Module");
        System.out.println("Enter 5. Staff Module");
        System.out.println("Enter 6. Class Section Module");
        System.out.print("Enter a choice: ");
        
        
        choice1 = in.nextInt();
        System.out.println("-----------------------------------------");
        
        //Optimize switch statement Later----Task
        switch(choice1){
        case 1:
            System.out.println("Welcome to the Student Module, Select an operation");
            System.out.println("1. Insert Student Detail");
            System.out.println("2. Update Student Details");
            System.out.println("3. Delete Student Detail");
            System.out.println("4. Select a Student");
            System.out.println("5. Exit");
            System.out.print("Enter a choice: ");
            choice2 = in.nextInt();
            System.out.println("-----------------------------------------");
            switch(choice2){
                case 1:
                    System.out.println("1. Insert New Data");
                    System.out.println("Enter Student ID : ");
                    sid=str.nextLine();
                    System.out.println("Enter Student First Name : ");
                    fname=str.nextLine();
                    System.out.println("Enter Student Last Name : : ");
                    lname=str.nextLine();
                    
                    //Add other Variasbles later----Task
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String insertq= "insert into Student(Student_ID,FirstName,LastName) values ('"+sid+ "','"+fname+"','"+lname+"')";
                    PreparedStatement insertst = conn.prepareStatement(insertq);
                    insertst.executeUpdate();
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {
                        System.out.println("The record has been inserted!");
                    }
                    break;
            }
        }
    
    }
   }
}
