package JssDAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class SchoolDAO {
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  static final String DB_URL = "jdbc:mysql://localhost/java_summer_school";

	   //  Database credentials
	  static final String USER = "root";
	  static final String PASS = "";
	  boolean isConnected=false;
	  private static Connection conn=null;

	
	  public SchoolDAO() {
		// TODO Auto-generated constructor stub
		   try{
		      System.out.println("Connecting to database...");
		      conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);	   
		      isConnected=true;
		   } catch (Exception e) 
		   {
			System.out.println("Connection is lost");  		   
		   }
	}
	  
	  public void connect(){
		   try{
 	 		      System.out.println("Connecting to database...");
			      conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);	   
			      isConnected=true;
			   } catch (Exception e) 
			   {
				System.out.println("Connection is lost");  		   
			   }
	  }
	
	  public List<School> findAll() throws SQLException{
		  if(!this.isConnected){
			  return null;
		  }
		      List<School> list=new ArrayList<>();
			  PreparedStatement stmt=conn.prepareStatement("SELECT id,name,city FROM schools ");
			  ResultSet rs=stmt.executeQuery();
			
			  while(rs.next()){
				  School s=new School(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
				  list.add(s);
			  }
			  
			  return list;		  
	  }
	  
	  public School findById(int id) throws SQLException{
		  if(this.isConnected)
		  {
			  PreparedStatement stmt=conn.prepareStatement("SELECT id,name,city FROM schools WHERE id=?");
			  stmt.setInt(1, id);
			  ResultSet rs=stmt.executeQuery();
			
			  if(rs.next()){
				  School s=new School(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
				  return s;
			  }
			  
			  return null;		 
		  }
		  return null;
		 
	  }
	  	  
	  public  List<School> findByName(String name) throws SQLException{
		  if(!this.isConnected){
			  return null;
		  }
		      List<School> list=new ArrayList<>();
			  PreparedStatement stmt=conn.prepareStatement("SELECT id,name,city FROM schools WHERE schools.name= ? ");
			  stmt.setString(1, name);
			  ResultSet rs=stmt.executeQuery();
			
			  while(rs.next()){
				  School s=new School(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
				  list.add(s);
			  }
			  
			  return list;		  
	  }
	    
	  public boolean insertSchool(School s) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO schools (id, name, city) VALUES (?, ? , ? )");
		      stmt.setInt(1, s.getId());
		      stmt.setString(2, s.getName());
		      stmt.setString(3, s.getCity());
		      boolean res=stmt.execute();
			  return true;		  
	  }
		  
	  public boolean updateSchool(School oldSchool, School newSchool) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("UPDATE schools SET id=?, name = ?, city=? WHERE schools.id = ?");
		      stmt.setInt(1,newSchool.getId());
		      stmt.setString(2, newSchool.getName());
		      stmt.setString(3, newSchool.getCity());
		      stmt.setInt(4, oldSchool.getId());
		      boolean res=stmt.execute();
			  return true;		  
	  }
		 
	  public boolean deleteSchool(School s) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("DELETE FROM schools WHERE schools.id = ?");
		      stmt.setInt(1,s.getId());
		      boolean res=stmt.execute();
			  return true;		  
	  }
	  
}