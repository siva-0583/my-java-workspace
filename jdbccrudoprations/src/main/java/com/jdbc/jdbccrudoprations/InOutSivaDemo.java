package com.jdbc.jdbccrudoprations;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Types;
import java.sql.Connection;
public class InOutSivaDemo 
{

	public static void main(String[] args) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu","root","siva@123");
		
		CallableStatement stmt= con.prepareCall("{CALL  getDetailsByInOutSiva(?)}");
		
		stmt.registerOutParameter(1,  Types.INTEGER);
		
		stmt.setInt(1,1);
		
		stmt.execute();
		
		int cnt = stmt.getInt(1);
		System.out.println("No of rows present in employee table for the empid =1:"+cnt);
		
		con.close();
	}

}
