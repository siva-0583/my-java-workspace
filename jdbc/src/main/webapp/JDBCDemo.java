package webapp;

import java.sql.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/")
@ApplicationPath("/rs")
public class JDBCDemo extends Application {
  
  @GET
  @Path("/insert/{N}/{I}")
  @Produces(MediaType.APPLICATION_JSON)
  public String insert(@PathParam("N") String name, @PathParam("I") int id) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=latin1&useConfigs=maxPerformance","root","siva@123");
      PreparedStatement ps = con.prepareStatement("insert into test1 values (?,?)");
      con.setAutoCommit(false);
      ps.setInt(1, id);
      ps.setString(2, name);
      int i = ps.executeUpdate();
      System.out.println(String.valueOf(i) + " Rows Affected");
      con.commit();
      con.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
    return name;
  }
  
  @GET
  @Path("/select")
  @Produces(MediaType.APPLICATION_JSON)
  public String select () {
    String s = "";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=latin1&useConfigs=maxPerformance","root","siva@123");
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs = stmt.executeQuery("select * from test1");
//      //rs.absolute(5);//first 5
//     // rs.beforeFirst();//complete all rows
//     // rs.moveToInsertRow();
//     // rs.updateInt("id",11);
//    //  rs.updateString("name","11two");
//     // rs.insertRow();
//      //rs.deleteRow();
//      ResultSetMetaData rsmd = rs.getMetaData();
//      System.out.println("total columes:"+rsmd.getColumnCount());
//      System.out.println("Column name first:"+rsmd.getColumnName(1));
//      System.out.println("Column type first:"+rsmd.getColumnTypeName(1));
//      System.out.println("Column Label first:"+rsmd.getColumnLabel(1));
 //     System.out.println("table name:"+rsmd.getTableName(1));
      DatabaseMetaData dbms  = con.getMetaData();
      System.out.println("Driver name"+dbms.getDriverName());
      System.out.println("Driver version:"+dbms.getDriverVersion());
      System.out.println("Database product Name :"+dbms.getDatabaseProductName());
      System.out.println("user name:"+dbms.getUserName());
      System.out.println("Database version :"+dbms.getDatabaseProductVersion());
      while(rs.next()) {
        s = s + "ID = " + rs.getInt(1) + ", Name = " + rs.getString(2) + " --- ";
      }
      con.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
    
    if (s == "")
      return "Empty Table";
    else
      return s;
  }
  @GET
  @Path("/callable/{I}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getEntries(@PathParam("I") int id) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=latin1&useConfigs=maxPerformance","root","@Mvssprem7");
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      String query = "CREATE PROCEDURE mydb.getName11 (IN P_ID INT, OUT P_NAME VARCHAR(30)) " +
          "BEGIN "+
          " SELECT name INTO P_NAME FROM test1 WHERE id = P_ID; "+
          "END";
          stmt.execute(query);
      CallableStatement cst = con.prepareCall("{CALL getName11(?, ?)}");
      cst.setInt(1, id);
      cst.registerOutParameter(2, java.sql.Types.VARCHAR);
      cst.executeUpdate();
      String response = cst.getString(2);
      return response;
    } catch(Exception e) {
      System.out.println(e);
    }
    return null;
  }
  

}