package dbconnection;
import java.sql.*;

public class TestConnection 
{
   public static void main(String args[])
   {
     try
     {
      // Class.forName("com.mysql.jdbc.Driver");
       Class.forName("com.mysql.cj.jdbc.Driver");
       System.out.println("Driver Class Loaded");
  
  DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root", "siva@123");
  System.out.println("Connection Established Successfully");
  
       
     }
     catch(Exception e)
     {
       System.out.println(e);
     }
     
   }
}