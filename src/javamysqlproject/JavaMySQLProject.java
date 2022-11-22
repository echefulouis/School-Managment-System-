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
        System.out.println("Enter 2. Course Module");
        System.out.println("Enter 3. Department Module");
        System.out.println("Enter 4. Exam Module");
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
                    System.out.println("LIST OF COURSES");
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
                    System.out.println("LIST OF COURSES");
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
                    System.out.println("LIST OF DEPARTMENTS");
                    System.out.printf("------------------------------------------------------%n");
                    System.out.printf("| %-15s | %-35s | %-35s |%n","Department ID","Department Name","Staff ID","Program Name");
                    System.out.printf("------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-15s | %-35s | %-35s |%n",rs.getString("Department_ID") ,rs.getString("Department_Name"), rs.getString("Program"));
                      
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
                    System.out.println("LIST OF DEPARTMENTS");
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
            while(true){
                System.out.println("Welcome to the Exam Module, Select an operation");
                System.out.println("1. Insert a new Exam");
                System.out.println("2. Select a Exam by Exam Code");
                System.out.println("3. Select all Exams");
                System.out.println("4. Update an Exam");
                System.out.println("5. Delete a Exam by Exam Code");
                System.out.print("Enter a choice: ");
                int choice5 = in.nextInt();
                System.out.println("-----------------------------------------");
                if(choice5 == 1){
                    //Remember to format the day and time datatype
                    System.out.println("1. Insert new Exam");
                    System.out.println("Enter Exam code : ");
                    String e_code=str.nextLine();
                    System.out.println("Enter Exam Room : ");
                    String e_room=str.nextLine();
                    System.out.println("Enter Exam Time: ");
                    String e_time=str.nextLine();
                    System.out.println("Enter Exam Date: ");
                    String e_date=str.nextLine();
                    System.out.println("Enter Department ID: ");
                    String e_dept_id=str.nextLine();
      
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String insertq= "insert into exams(Exam_Code,Room,Time,Date,Department_ID) values ('"+e_code+ "','"+e_room+"','"+e_time+"','"+e_date+"','"+e_dept_id+"')";
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
                else if (choice5 == 2){
                    System.out.println("2. Select an Exam by Exam Code");
                    System.out.println("Enter Exam Code : ");
                    String e_code=str.nextLine();                    
    
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String selectq= "select * from exams where Exam_Code like '%"+e_code+"%'";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF EXAM");
                    System.out.printf("------------------------------------------------------%n");
                    System.out.printf("| %-10s | %-10s | %-10s | %-15s | %-10s |%n","Exam Code","Exam Room","Exam Time","Exam Date","Department ID");
                    System.out.printf("------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-10s | %-10s | %-10s | %-15s | %-10s |%n",rs.getString("Exam_Code") ,rs.getString("Room"), rs.getString("Time"), rs.getString("Date"), rs.getString("Department_ID"));
                      
                    }
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else if(choice5 == 3){
                    System.out.println("3. Select all Exams");

                    try
                    {
                    Connection conn=getDBConnection();
                    String selectq= "select * from exams";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF EXAM");
                    System.out.printf("------------------------------------------------------%n");
                    System.out.printf("| %-10s | %-10s | %-10s | %-15s | %-10s |%n","Exam Code","Exam Room","Exam Time","Exam Date","Department ID");
                    System.out.printf("------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-10s | %-10s | %-10s | %-15s | %-10s |%n",rs.getString("Exam_Code") ,rs.getString("Room"), rs.getString("Time"), rs.getString("Date"), rs.getString("Department_ID"));
                      
                    }
                    }
                     catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
                else if(choice5 == 4){
                    System.out.println("4. Update an Exam Record");
                    System.out.println("Coming Soon");
                    break;
                }
                else if(choice5 == 5){
                    System.out.println("5. Delete a Exam by Exam Code");
                    System.out.println("Enter Exam Code: ");
                    String e_code=str.nextLine();                    
                    //Add other Variasbles later----Task
                    try
                    {
                    Connection conn=getDBConnection();
                    String deleteq= "delete from exams where Exam_Code= '"+e_code+"'";
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
             while(true){
                System.out.println("Welcome to the Staff Module, Select an operation");
                System.out.println("1. Insert a new Staff");
                System.out.println("2. Select a Staff by Staff ID");
                System.out.println("3. Select all Staffs");
                System.out.println("4. Update a Staff Detail");
                System.out.println("5. Delete a Staff by Staff ID");
                System.out.print("Enter a choice: ");
                int choice6 = in.nextInt();
                System.out.println("-----------------------------------------");
                if(choice6 == 1){
                    //Remember to format the day and time datatype
                    System.out.println("1. Insert new Staff");
                    System.out.println("Enter staff ID : ");
                    String s_id=str.nextLine();
                    System.out.println("Enter saff Salary: ");
                    String salary=str.nextLine();
                    System.out.println("Enter Date of Birth: ");
                    String dob=str.nextLine();
                    System.out.println("Enter Street: ");
                    String s_street=str.nextLine();
                    System.out.println("Enter City: ");
                    String s_city=str.nextLine();
                    System.out.println("Enter State: ");
                    String s_sate=str.nextLine();
                    System.out.println("Enter Zip: ");
                    String s_zip=str.nextLine();
                    System.out.println("Enter Staff Email Address: ");
                    String s_email=str.nextLine();
                    System.out.println("Enter First Name: ");
                    String s_first_name=str.nextLine();
                    System.out.println("Enter Last Name: ");
                    String s_last_name=str.nextLine();
                    System.out.println("Enter Department ID: ");
                    String dept_id=str.nextLine();
                    
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String insertq= "insert into staff(Staff_ID,Birthdate,Street,City,State,Zip,Staff_email,FirstName,LastName,Department_ID) values "
                            + "('"+s_id+ "','"+salary+"','"+dob+"','"+s_street+"','"+s_city+"','"+s_zip+"','"+s_email+"','"+s_first_name+"','"+s_last_name+"','"+dept_id+"')";
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
                else if (choice6 == 2){
                    System.out.println("2. Select an Staff by Staff ID");
                    System.out.println("Enter Staff ID : ");
                    String s_id=str.nextLine();                    
    
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String selectq= "select * from staff where staff_id like '%"+s_id+"%'";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF STAFFS");
                    System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-10s | %-25s | %-15s | %-15s | %-10s |%n",
                            "Staff ID","Salary","Date of Birth","Street","City","State","ZIP","Staff Email","First Name","Last Name","Department ID");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-10s | %-25s | %-15s | %-15s | %-10s |%n",
                            rs.getString("Staff_ID") ,rs.getString("Salary"), rs.getString("Birthdate"), rs.getString("Street"), rs.getString("City"),
                            rs.getString("State"), rs.getString("Zip"), rs.getString("Staff_email"), rs.getString("FirstName"),
                            rs.getString("LastName"), rs.getString("Department_ID"));
                      
                    }
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else if(choice6 == 3){
                    System.out.println("3. Select all Staffs");

                    try
                    {
                    Connection conn=getDBConnection();
                    String selectq= "select * from staff";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF STAFFS");
                    System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-10s | %-25s | %-15s | %-15s | %-10s |%n",
                            "Staff ID","Salary","Date of Birth","Street","City","State","ZIP","Staff Email","First Name","Last Name","Department ID");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-10s | %-10s | %-15s | %-15s | %-15s | %-15s | %-10s | %-25s | %-15s | %-15s | %-10s |%n",
                            rs.getString("Staff_ID") ,rs.getString("Salary"), rs.getString("Birthdate"), rs.getString("Street"), rs.getString("City"),
                            rs.getString("State"), rs.getString("Zip"), rs.getString("Staff_email"), rs.getString("FirstName"),
                            rs.getString("LastName"), rs.getString("Department_ID"));
                      
                    }
                    }
                     catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
                else if(choice6 == 4){
                    System.out.println("4. Update an Exam Record");
                    System.out.println("Coming Soon");
                    break;
                }
                else if(choice6 == 5){
                    System.out.println("5. Delete a Staff by Staff ID");
                    System.out.println("Enter Staff ID: ");
                    String s_id=str.nextLine();                    
                    //Add other Variasbles later----Task
                    try
                    {
                    Connection conn=getDBConnection();
                    String deleteq= "delete from staff where Staff_ID= '"+s_id+"'";
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
        
        case 6:
            System.out.println("Welcome to the Class Section Module, Select an operation");
           while(true){
                System.out.println("Welcome to the Class Section Module, Select an operation");
                System.out.println("1. Insert a new Class Section");
                System.out.println("2. Select a Section by Section ID");
                System.out.println("3. Select all Class Sections");
                System.out.println("4. Update a Class Section");
                System.out.println("5. Delete an Section by Section ID");
                System.out.print("Enter a choice: ");
                int choice7 = in.nextInt();
                System.out.println("-----------------------------------------");
                if(choice7 == 1){
                    //Remember to format the day and time datatype
                    System.out.println("1. Insert new Class Section");
                    System.out.println("Enter Section ID : ");
                    int section_id=in.nextInt();
                    System.out.println("Enter Professor ID : ");
                    String prof_id=str.nextLine();
                    System.out.println("Enter Session End Time: ");
                    String s_end_time=str.nextLine();
                    System.out.println("Enter Session Day: ");
                    String s_day=str.nextLine();
                    System.out.println("Enter Session Start Time: ");
                    String s_start_time=str.nextLine();
                    System.out.println("Enter Cousrse ID: ");
                    String s_course_id=str.nextLine();
      
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String insertq= "insert into class_section(Section_ID,Professor,End_Time,Day,Start_Time,Courses_CourseID) "
                            + "values ('"+section_id+ "','"+prof_id+"','"+s_end_time+"','"+s_day+"','"+s_start_time+"','"+s_course_id+"')";
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
                else if (choice7 == 2){
                    System.out.println("2. Select a Class Section by Section ID");
                    System.out.println("Enter Section ID : ");
                    String section_id=str.nextLine();                    
    
                    try
                    {
                    //insert data into a table of a database/schema
                    Connection conn=getDBConnection();
                    String selectq= "select * from class_section where Section_ID like '%"+section_id+"%'";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF CLASS SECTIONS");
                    System.out.printf("----------------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-20s | %-10s |%n","Exam Code","Professor ID","Session End Time","Session Day","Session Start Time","Cousrse ID");
                    System.out.printf("----------------------------------------------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-20s | %-10s |%n",
                            rs.getString("Section_ID") ,rs.getString("Professor"), rs.getString("End_Time"), rs.getString("Day"), rs.getString("Start_Time"), rs.getString("Courses_CourseID"));
                      
                    }
                    }
                     catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                else if(choice7 == 3){
                    System.out.println("3. Select all Class Sections");

                    try
                    {
                    Connection conn=getDBConnection();
                    String selectq= "select * from class_section";
                    PreparedStatement selectst = conn.prepareStatement(selectq);
                    rs= selectst.executeQuery();

                    //Add other student details later--Task
                    System.out.println("LIST OF CLASS SECTIONS");
                    System.out.printf("----------------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-20s | %-10s |%n","Exam Code","Professor ID","Session End Time","Session Day","Session Start Time","Cousrse ID");
                    System.out.printf("----------------------------------------------------------------------------------------------%n");
                    while (rs.next()) {
                    
                    System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-20s | %-10s |%n",
                            rs.getString("Section_ID") ,rs.getString("Professor"), rs.getString("End_Time"), rs.getString("Day"), rs.getString("Start_Time"), rs.getString("Courses_CourseID"));
                      
                    }
                    }
                     catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
                else if(choice7 == 4){
                    System.out.println("4. Update an Exam Record");
                    System.out.println("Coming Soon");
                    break;
                }
                else if(choice7 == 5){
                    System.out.println("5. Delete a Class Section by Section ID");
                    System.out.println("Enter Section ID: ");
                    String s_id=str.nextLine();                    
                    //Add other Variasbles later----Task
                    try
                    {
                    Connection conn=getDBConnection();
                    String deleteq= "delete from class_section where Section_ID= '"+s_id+"'";
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

        case 7:
            System.out.println("Thank You");
            System.exit(0);
            break;
        }
      }
   }
}
