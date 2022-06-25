package com.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookManager 
{
	String url = "jdbc:mysql://localhost:3306/klu";
	String dbuser = "root";
	String dbpwd = "siva@123";
	
	Connection con = null;
	PreparedStatement ps = null;
	
	public List<Book> getDetails() throws Exception
	{
		con = DriverManager.getConnection(url, dbuser, dbpwd);
		ps = con.prepareStatement("select * from book");
		ResultSet rs = ps.executeQuery();
		List<Book> L = new ArrayList<Book>();
		
		while(rs.next())
		{
			Book B = new Book();
			B.setBookid(rs.getInt(1));
			B.setTitle(rs.getString(2));
			B.setPrice(rs.getDouble(3));
			
			
			L.add(B);
			
		}
		return L;
		
	}
}
