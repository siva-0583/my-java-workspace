package com.jdbc.jdbccrudoprations;

import java.sql.*;
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/klu";
        String username = "root";
        String password = "siva@123";
        
        Connection con = DriverManager.getConnection(url , username, password);
        
        Statement stmt= con.createStatement();
        //INSERT THE RECORD INTO A TABLE
       // String sqlQry = "INSERT INTO STUDENT VALUES(67,'Siva')";
       
        //UPDATEING THE RECORD IN A TABLE
        //String sqlQry ="UPDATE STUDENT SET NAME='Sri Siva Koteswara Rao' WHERE ROLLNO=67";
        
        //DELETEING THE RECORD IN A TABLE
        String sqlQry="DELETE FROM STUDENT WHERE ROLLNO=7";
        
        
         stmt.executeUpdate(sqlQry);
//    
//        String sqlQry = "SELECT * FROM STUDENT WHERE ROLLNO=1";
//        ResultSet rs=stmt.executeQuery(sqlQry);
//        
//        while(rs.next())
//        {
//        	System.out.println(rs.getString(2));
//        }
//        
//        con.close();
//        
        System.out.println("Done....");
        
        
    }
}
