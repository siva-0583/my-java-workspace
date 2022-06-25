package com.jdbc.jdbccrudoprations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
public class OutSivaDetails 
{
   public static void main(String args[]) throws Exception
   {
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu","root","siva@123");
	   
	   CallableStatement stmt = con.prepareCall("{CALL getDetailsByOutSiva(?)}");
	   
	   stmt.registerOutParameter(1,Types.INTEGER);
	   
	   stmt.execute();
	   
	   int cnt = stmt.getInt(1);
	   
	   System.out.println("No: of row present in employee table:"+cnt);
	   
	   con.close();
   }
}
