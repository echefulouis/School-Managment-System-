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

        //System.out.println("Database connection was successful!");
        
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
    ResultSet rs = null;
    int choice1;
    
    Scanner in = new Scanner(System.in);
    Scanner str = new Scanner(System.in);
    
    //Loops for Modules
    while(true)
    {
        System.out.println("-----------------------------------------");
        System.out.println("Welcome to School Database Management System");
        System.out.println("Enter 1. Student Module");
        System.out.println("Enter 2. Courses Module");
        System.out.println("Enter 3. Department Module");
        System.out.println("Enter 4. Exams Module");
        System.out.println("Enter 5. Staff Module");
        System.out.println("Enter 6. Class Section Module");
        System.out.println("Enter 7. Exit");
        System.out.print("Enter a choice: ");
        
        
        choice1 = in.nextInt();
        System.out.println("-----------------------------------------");
        
        //Optimize switch statement Later----Task
        switch(choice1){
        case 1:    
            String sid,fname,lname;
            while(true){
                System.out.println("Welcome to the Student Module, Select an operation");
                System.out.println("1. Insert Student Detail");
                System.out.println("2. Select a Student");
                System.out.println("3. Select all Students");
                System.out.println("4. Update Student Details");
                System.out.println("5. Delete Student Detail");
                System.out.print("Enter a choice: ");
                int choice2 = in.nextInt();
                System.out.println("-----------------------------------------");
                if(choice2 == 1){
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
                else if (choice2 == 2){
                    System.out.println("2. Select a Student by Student_ID");
                    System.out.println("Enter Student ID : ");
                    sid=str.nextLine();                    
                    //Add other Variasbles later----Task
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String selectq= "select * from Student where Student_ID like '%"+sid+"%'";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF ALL STUDENTS");
                    System.out.printf("---------------------------------------%n");
                    System.out.printf("| %-10s | %-10s | %10s |%n","Student_ID","FirstName","LastName");
                    System.out.printf("--------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-10s | %-10s | %10s |%n",rs.getString("Student_ID") ,rs.getString("FirstName"), rs.getString("LastName"));
                       
                        }
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else if(choice2 == 3){
                    System.out.println("3. Select all students");

                    //Add other Variasbles later----Task
                    try
                    {
                    //Select all from student
                    Connection conn=getDBConnection();
                    String selectq= "select * from Student";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF ALL STUDENTS");
                    System.out.printf("---------------------------------------%n");
                    System.out.printf("| %-10s | %-10s | %10s |%n","Student_ID","FirstName","LastName");
                    System.out.printf("--------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-10s | %-10s | %10s |%n",rs.getString("Student_ID") ,rs.getString("FirstName"), rs.getString("LastName"));
                       
                        }
                    }
                     catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
                else if(choice2 == 4){
                    System.out.println("4. Update a Student Record");
                    System.out.println("Coming Soon");
                    break;
                }
                else if(choice2 == 5){
                    System.out.println("5. Delete a Student by Student_ID");
                    System.out.println("Enter Student ID : ");
                    sid=str.nextLine();                    
                    //Add other Variasbles later----Task
                    try
                    {
                    Connection conn=getDBConnection();
                    String deleteq= "delete from Student where Student_ID= '"+sid+"'";
                    PreparedStatement deletest = conn.prepareStatement(deleteq);
                    deletest.executeUpdate();
                    System.out.println("The record has been deleted!");
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else{
                    System.out.println("Invalid Selection");
                }
            }
            break;
        case 2:
            while(true){
                System.out.println("Welcome to the Courses Module, Select an operation");
                System.out.println("1. Insert Course");
                System.out.println("2. Select a Course by Course ID");
                System.out.println("3. Select all Courses");
                System.out.println("4. Update a Course");
                System.out.println("5. Delete a Course by Course ID");
                System.out.print("Enter a choice: ");
                int choice3 = in.nextInt();
                System.out.println("-----------------------------------------");
                if(choice3 == 1){
                    String c_name,c_id,staff_id,dept_id;
                    System.out.println("1. Insert New Course");
                    System.out.println("Enter Course Name : ");
                    c_name=str.nextLine();
                    System.out.println("Enter Course ID : ");
                    c_id=str.nextLine();
                    System.out.println("Enter Staff ID: ");
                    staff_id=str.nextLine();
                    System.out.println("Enter Department ID: ");
                    dept_id=str.nextLine();

                    //Add other Variasbles later----Task
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String insertq= "insert into courses(Course_Name,CourseID,Staff_ID,Department_ID) values ('"+c_name+ "','"+c_id+"','"+staff_id+"','"+dept_id+"')";
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
                else if (choice3 == 2){
                    System.out.println("2. Select a Course by Course ID");
                    System.out.println("Enter Course ID : ");
                    String c_id=str.nextLine();                    
                    //Add other Variasbles later----Task
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String selectq= "select * from courses where CourseID like '%"+c_id+"%'";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF Courses");
                    System.out.printf("--------------------------------------------------------------------------------%n");
                    System.out.printf("| %-35s | %-10s | %-10s | %-10s |%n","Course Name","Course ID","Staff ID","Department ID");
                    System.out.printf("--------------------------------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-35s | %-10s | %-10s | %-10s |%n",rs.getString("Course_Name") ,rs.getString("CourseID"), rs.getString("Staff_ID"),rs.getString("Department_ID"));
                       
                        }
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else if(choice3 == 3){
                    System.out.println("3. Select all Courses");

                    try
                    {
                    Connection conn=getDBConnection();
                    String selectq= "select * from courses";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF Courses");
                    System.out.printf("-------------------------------------------------------------------------------%n");
                    System.out.printf("| %-35s | %-10s | %-10s | %-10s |%n","Course Name","Course ID","Staff ID","Department ID");
                    System.out.printf("-------------------------------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-35s | %-10s | %-10s | %-10s |%n",rs.getString("Course_Name") ,rs.getString("CourseID"), rs.getString("Staff_ID"),rs.getString("Department_ID"));
                        }
                    }
                     catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
                else if(choice3 == 4){
                    System.out.println("4. Update a Course Record");
                    System.out.println("Coming Soon");
                    break;
                }
                else if(choice3 == 5){
                    System.out.println("5. Delete a Course by Course ID");
                    System.out.println("Enter Course ID : ");
                    String c_id=str.nextLine();                    
                    //Add other Variasbles later----Task
                    try
                    {
                    Connection conn=getDBConnection();
                    String deleteq= "delete from courses where CourseID= '"+c_id+"'";
                    PreparedStatement deletest = conn.prepareStatement(deleteq);
                    deletest.executeUpdate();
                    System.out.println("The record has been deleted!");
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else{
                    System.out.println("Invalid Selection");
                } 
            }
        break;
        
        case 3:
            System.out.println("Welcome to the Department Module, Select an operation");
            while(true){
                System.out.println("Welcome to the Department Module, Select an operation");
                System.out.println("1. Insert a new Department");
                System.out.println("2. Select a Department by Department ID");
                System.out.println("3. Select all Departments");
                System.out.println("4. Update a Department");
                System.out.println("5. Delete a Department by Department ID");
                System.out.print("Enter a choice: ");
                int choice4 = in.nextInt();
                System.out.println("-----------------------------------------");
                if(choice4 == 1){
                    String program_name,dept_name,dept_id;
                    System.out.println("1. Insert new Department");
                    System.out.println("Enter Department Name : ");
                    dept_name=str.nextLine();
                    System.out.println("Enter Department ID : ");
                    dept_id=str.nextLine();
                    System.out.println("Enter Program Name: ");
                    program_name=str.nextLine();
      
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String insertq= "insert into department(Department_Name,Department_ID,Program) values ('"+dept_name+ "','"+dept_id+"','"+program_name+"')";
                    PreparedStatement insertst = conn.prepareStatement(insertq);
                    insertst.executeUpdate();
                    System.out.println("The record has been inserted!");
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else if (choice4 == 2){
                    System.out.println("2. Select a Department by Department ID");
                    System.out.println("Enter Department ID : ");
                    String dept_id=str.nextLine();                    
    
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String selectq= "select * from department where Department_ID like '%"+dept_id+"%'";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                     System.out.println("LIST OF Courses");
                    System.out.printf("------------------------------------------------------%n");
                    System.out.printf("| %-15s | %-35s | %-35s |%n","Department ID","Department Name","Staff ID","Program Name");
                    System.out.printf("------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-15s | %-10s | %-35s |%n",rs.getString("Department_ID") ,rs.getString("Department_Name"), rs.getString("Program"));
                      
                    }
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else if(choice4 == 3){
                    System.out.println("3. Select all Department");

                    try
                    {
                    Connection conn=getDBConnection();
                    String selectq= "select * from department";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF Courses");
                    System.out.printf("------------------------------------------------------%n");
                    System.out.printf("| %-15s | %-35s | %-35s |%n","Department ID","Department Name","Staff ID","Program Name");
                    System.out.printf("------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-15s | %-35s | %-35s |%n",rs.getString("Department_ID") ,rs.getString("Department_Name"), rs.getString("Program"));
                      
                    }
                    }
                     catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
                else if(choice4 == 4){
                    System.out.println("4. Update a Department Record");
                    System.out.println("Coming Soon");
                    break;
                }
                else if(choice4 == 5){
                    System.out.println("5. Delete a Department by Department ID");
                    System.out.println("Enter Department ID : ");
                    String dept_id=str.nextLine();                    
                    //Add other Variasbles later----Task
                    try
                    {
                    Connection conn=getDBConnection();
                    String deleteq= "delete from department where Department_ID= '"+dept_id+"'";
                    PreparedStatement deletest = conn.prepareStatement(deleteq);
                    deletest.executeUpdate();
                    System.out.println("The record has been deleted!");
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else{
                    System.out.println("Invalid Selection");
                } 
            }
            break;
        
        case 4:
            System.out.println("Welcome to the Exams Module, Select an operation");
            while(true){
                System.out.println("Welcome to the Exam Module, Select an operation");
                System.out.println("1. Insert a new Exam");
                System.out.println("2. Select a Exam by Exam Code");
                System.out.println("3. Select all Exams");
                System.out.println("4. Update an Exam");
                System.out.println("5. Delete a  by Department ID");
                System.out.print("Enter a choice: ");
                int choice4 = in.nextInt();
                System.out.println("-----------------------------------------");
                if(choice4 == 1){
                    String program_name,dept_name,dept_id;
                    System.out.println("1. Insert new Exam");
                    System.out.println("Enter Department Name : ");
                    dept_name=str.nextLine();
                    System.out.println("Enter Department ID : ");
                    dept_id=str.nextLine();
                    System.out.println("Enter Program Name: ");
                    program_name=str.nextLine();
      
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String insertq= "insert into department(Department_Name,Department_ID,Program) values ('"+dept_name+ "','"+dept_id+"','"+program_name+"')";
                    PreparedStatement insertst = conn.prepareStatement(insertq);
                    insertst.executeUpdate();
                    System.out.println("The record has been inserted!");
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else if (choice4 == 2){
                    System.out.println("2. Select a Department by Department ID");
                    System.out.println("Enter Department ID : ");
                    String dept_id=str.nextLine();                    
    
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String selectq= "select * from department where Department_ID like '%"+dept_id+"%'";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    while (rs.next()) {
                    System.out.println(rs.getString("Department_ID") + " " + rs.getString("Department_Name")+ 
                                  " " + rs.getString("Program"));

                        }
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else if(choice4 == 3){
                    System.out.println("3. Select all Department");

                    try
                    {
                    Connection conn=getDBConnection();
                    String selectq= "select * from department";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF ALL DEPARTMENT");
                    while (rs.next()) {
                    System.out.println(rs.getString("Department_Name") + 
                                " " + rs.getString("Department_ID")+ 
                                  " " + rs.getString("Program"));

                        }
                    }
                     catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
                else if(choice4 == 4){
                    System.out.println("4. Update a Department Record");
                    System.out.println("Coming Soon");
                    break;
                }
                else if(choice4 == 5){
                    System.out.println("5. Delete a Department by Department ID");
                    System.out.println("Enter Department ID : ");
                    String dept_id=str.nextLine();                    
                    //Add other Variasbles later----Task
                    try
                    {
                    Connection conn=getDBConnection();
                    String deleteq= "delete from department where Department_ID= '"+dept_id+"'";
                    PreparedStatement deletest = conn.prepareStatement(deleteq);
                    deletest.executeUpdate();
                    System.out.println("The record has been deleted!");
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else{
                    System.out.println("Invalid Selection");
                } 
            }
            break;
        
        case 5:
            System.out.println("Welcome to the Staff Module, Select an operation");
            
            break;
        
        case 6:
            System.out.println("Welcome to the Class Section Module, Select an operation");
           
            break;

        case 7:
            System.out.println("Thank You");
            System.exit(0);
            break;
        }
      }
   }
}
