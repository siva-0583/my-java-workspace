package dbconnection;
import java.sql.*;
public class StatementCRUDOperations 
{
  public static void main(String args[]) 
  {
    StatementCRUDOperations crudOperations = new StatementCRUDOperations();
    //crudOperations.createtable();
    crudOperations.insertrecord();
  }
  
  public void createtable() 
  {
    try
    {
      Connection con= DBConnection.getConnection();
      
      Statement stmt=con.createStatement();
      
 // String qury= " create table siva(id int primary key, name varchar(100) not null, gender varchar(10) not null, department varchar(100) not null,salary decimal(10,4) not null)";
      
  //int n=stmt.executeUpdate(qury);
  //System.out.println(n+" Table Created");
  
      con.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
  
  public void insertrecord()
  {
    try
    {
      Connection con= DBConnection.getConnection();
      Statement stmt=con.createStatement();
      int id=102;
      String name="KLU";
      String gender="FEMALE";
      String dept="EEE";
      Double salary=12000.50; 
//      int id1=102;
//      String name1="KLU";
//      String gender1="FEMALE";
//      String dept1="EEE";
//      Double salary1=12000.50; 
     int n=stmt.executeUpdate(" insert into siva values( "+id+" , '"+name+"' , '"+gender+"' , '"+dept+"' , "+salary+"  )  ");    
      //int n1=stmt.executeUpdate(" insert into employee values( "+id1+" , '"+name1+"' , '"+gender1+"' , '"+dept1+"' , "+salary1+"  )  ");    

      System.out.println(n+"records inserted");
      
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
  
  public void displayrecords() 
  {
    try {
      Connection con = DBConnection.getConnection();
      PreparedStatement pstmt=con.prepareStatement(" select sid,sdept from student");
      
      ResultSet rs=pstmt.executeQuery();
      int i=1;
      while(rs.next()) 
      {
        System.out.println("*** Student Record :"+i+" ***");
//        System.out.println("Student ID:"+rs.getInt(1));
//        System.out.println("Student Name:"+rs.getString(2));
//        System.out.println("Student Gender:"+rs.getString(3));
//        System.out.println("Student Department:"+rs.getString(4));
//        System.out.println("Student Programs:"+rs.getString(5));
//        System.out.println("Student CGPA:"+rs.getDouble(6));
//        System.out.println("Student Email ID:"+rs.getString(7));
        
//        System.out.println("Student ID:"+rs.getInt("sid"));
//        System.out.println("Student Name:"+rs.getString("sname"));
//        System.out.println("Student Gender:"+rs.getString("sgender"));
//        System.out.println("Student Department:"+rs.getString("sdept"));
//        System.out.println("Student Programs:"+rs.getString("sprogram"));
//        System.out.println("Student CGPA:"+rs.getDouble("scgpa"));
//        System.out.println("Student Email ID:"+rs.getString("semail"));
        
        System.out.println("Student ID:"+rs.getInt(1));
        System.out.println("Student Dept:"+rs.getString(2));
        
        i++;
      }
    }
    catch(Exception e) 
    {
      System.out.println(e);
    }
  }
}