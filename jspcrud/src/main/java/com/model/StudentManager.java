package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentManager 
{
   String url = "jdbc:mysql://localhost:3306/klu";
   String dbuser = "root";
   String dbpwd = "siva@123";
   
   Connection con = null;
   PreparedStatement ps = null;
   
   public String deleteData(int sid)throws Exception
   {
	   con = DriverManager.getConnection(url, dbuser, dbpwd);
	   ps = con.prepareStatement("delete from student1 where studentid=?");
	   ps.setInt(1, sid);
	   
	   ps.execute();
	   con.close();
	   
	   return "Data Deleted Successfully.....";
   }
   
   public String updateData(Student S)throws Exception
   {
	   con = DriverManager.getConnection(url, dbuser,dbpwd);
	   ps = con.prepareStatement("update student1 set name=?,cgpa=? where studentid=?");
	   ps.setString(1,S.getName());
	   ps.setDouble(2,S.getCgpa());
	   ps.setInt(3,S.getStudentid());
	   
	  ps.execute(); 
	  con.close();
	  return "Data Updated Successfully......";
   }
   
   public String saveData(Student S)throws Exception
   {
	   con  = DriverManager.getConnection(url, dbuser, dbpwd);
	   ps = con.prepareStatement("insert into student1 values(?,?,?)");
	   ps.setInt(1, S.getStudentid());
	   ps.setString(2, S.getName());
	   ps.setDouble(3, S.getCgpa());
	   
	   ps.execute();
	   con.close();
	   return "Data Inserted Sucessfully......";
	   
	   
   }
   
   public List<Student> redData()
   {
	   List<Student> L = new ArrayList<Student>();
	   try
	   {
		   con = DriverManager.getConnection(url, dbuser, dbpwd);
		   ps = con.prepareStatement("select * from student1");
		   ResultSet rs = ps.executeQuery();
		   while(rs.next())
		   {
			   Student S = new Student();
			   S.setStudentid(rs.getInt(1));
			   S.setName(rs.getString(2));
			   S.setCgpa(rs.getDouble(3));
			   L.add(S);
		   }
		   con.close();
		   
	   }
	   catch(Exception e)
	   {
		   
	   }
	   return L;
	   
   }
   
}
