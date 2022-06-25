package xmlcssdemo.jdbcdemo;

import java.sql.*;
public class App
{
	public static void main(String args[]) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/klu";
		String username = "root";
		String password ="siva@123";
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement stmt = con.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT * FROM STUDENT");
		
		while(rs.next())
		{
			System.out.println("Roll No:"+rs.getInt(1));
			System.out.println("Name :"+rs.getString(2));
		}
		
		con.close();
	}
}